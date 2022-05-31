package com.stepanov.reduktor.passes.slicer

import com.stepanov.reduktor.executor.CompilerTestChecker
import com.stepanov.reduktor.util.dependencyTree.DependencyTree
import com.stepanov.reduktor.util.getAllChildrenNodes
import com.stepanov.reduktor.util.getAllPSIChildrenOfType
import org.apache.log4j.Logger
import org.jetbrains.kotlin.KtNodeTypes
import org.jetbrains.kotlin.psi.*

//TODO Globals?
class FunctionSlicer(private val checker: CompilerTestChecker) : KtVisitorVoid() {
   fun computeSlice(file: KtFile, func: KtNamedFunction) {
        val functions: List<KtNamedFunction> = file.node.getAllChildrenNodes()
                .filter { it.psi is KtNamedFunction }
                .map { it.psi as KtNamedFunction }

        val prohibitedKeys = mutableListOf<String>()
        for (f in functions) {
            //Put if absent else delete
            val sig = getSignature(f)
            if (!prohibitedKeys.contains(sig)) {
                if (signatureToFuncNode.containsKey(sig)) {
                    prohibitedKeys.add(sig)
                    signatureToFuncNode.remove(sig)
                } else {
                    signatureToFuncNode[sig] = f
                }
            }
        }
        sliceFunc.add(func)
        func
                .getAllPSIChildrenOfType<KtCallExpression>()
                .forEach { signatureToFuncNode[getSignature(it)]?.let { it1 -> sliceFunc.add(it1) } }


        val nodes = file.getAllPSIChildrenOfType<KtNamedFunction>()
        nodes.forEach { functionTree.getOrAddNode(it) }
        nodes.forEach { visitNamedFunction(it) }

        val funcToSave = HashSet<KtNamedFunction>()
        for (s in sliceFunc) {
            handleFunTree(s).forEach { funcToSave.add(it) }
        }
        for (n in nodes) {
            if (!funcToSave.map { it.node }.contains(n.node)) {
                val res = checker.removeNodeIfPossible(file, n.node)
                log.debug("TRY TO REMOVE ${n.name} $res")
            }
        }
    }

    private fun handleFunTree(sliceFunc: KtNamedFunction): HashSet<KtNamedFunction> {
        val funcToNotDelete = HashSet<KtNamedFunction>()
        val sliceFuncNode = functionTree.find(sliceFunc) ?: return funcToNotDelete
        funcToNotDelete.add(sliceFuncNode)
        getAllParents(sliceFuncNode, funcToNotDelete, false)
        return funcToNotDelete
    }

    private fun getAllParents(func: KtNamedFunction, container: HashSet<KtNamedFunction>, isChild: Boolean) {
        val node = functionTree.getOrAddNode(func)
        if (node.getParents().isNotEmpty() && !isChild) {
            node.getParents()
                    .filterNot { getSignature(it.typeNode) == getSignature(node.typeNode) }
                    .forEach { container.add(it.typeNode); getAllParents(it.typeNode, container, false) }
        }
        if (node.getChildren().isNotEmpty()) {
            node.getChildren()
                    .filterNot { getSignature(it.typeNode) == getSignature(node.typeNode) }
                    .forEach { container.add(it.typeNode); getAllParents(it.typeNode, container, true) }
        }
        return
    }

    override fun visitNamedFunction(function: KtNamedFunction) {
        //Get all call expression and build tree
        function.node.getAllChildrenNodes()
                .filter { it.elementType == KtNodeTypes.CALL_EXPRESSION }
                .forEach { visitCall(function, it.psi as KtCallExpression) }
    }

    private fun visitCall(f: KtNamedFunction, expression: KtCallExpression) {
        val funcNode = functionTree.findNode(f) ?: return
        val signature = getSignature(expression)
        val calledFunc = signatureToFuncNode[signature] ?: return
        val calledNode = functionTree.findNode(calledFunc) ?: return
        //Avoid recursion in tree
        if (!(funcNode.getParents().contains(calledNode) || calledNode.getChildren().contains(funcNode))) {
            funcNode.addChild(calledNode)
            calledNode.addParent(funcNode)
        }
    }

    private fun getSignature(f: KtNamedFunction): String {
        val signature = StringBuilder()
        signature.append(f.name)
        signature.append(f.typeParameters.size)
        signature.append(f.valueParameters.size)
        return signature.toString()
    }

    private fun getSignature(expression: KtCallExpression): String {
        val signature = StringBuilder()
        signature.append(expression.calleeExpression?.text)
        signature.append(expression.typeArguments.size)
        signature.append(expression.valueArguments.size)
        return signature.toString()
    }

    private var sliceFunc = HashSet<KtNamedFunction>()
    private var signatureToFuncNode = HashMap<String, KtNamedFunction>()
    private var functionTree = DependencyTree<KtNamedFunction>()

    private val log = Logger.getLogger("transformationManagerLog")
}