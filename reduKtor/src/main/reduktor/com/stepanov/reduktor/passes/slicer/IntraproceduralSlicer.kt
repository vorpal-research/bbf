package com.stepanov.reduktor.passes.slicer

import com.intellij.lang.ASTNode
import com.stepanov.reduktor.executor.CompilerTestChecker
import com.stepanov.reduktor.util.*
import org.jetbrains.kotlin.KtNodeTypes
import org.jetbrains.kotlin.lexer.KtTokens
import org.jetbrains.kotlin.psi.*
import org.jetbrains.kotlin.psi.psiUtil.allChildren
import org.jetbrains.kotlin.psi.psiUtil.getParentOfType
import org.jetbrains.kotlin.psi.psiUtil.parents
import org.jetbrains.kotlin.types.expressions.OperatorConventions

class IntraproceduralSlicer(private val checker: CompilerTestChecker) : KtVisitorVoid() {

    fun computeSlice(file: KtFile, line: Int) {
        newFile = file
        endNode = file.getLine(line) ?: return
        //kostyl'
        if (endNode.psi is KtCallExpression) {
            val call = endNode.psi as KtCallExpression
            call.valueArguments.map { it.node }.filter { it.elementType == KtTokens.IDENTIFIER }.forEach { monElements.add(it) }
        } else {
            endNode.getAllChildrenNodes().filter { it.elementType == KtTokens.IDENTIFIER }.forEach { monElements.add(it) }
        }

        if (endNode.elementType == KtNodeTypes.FUN) {
            //WE NEED TO REDUCE FUNCTION FIRST
            //1 variant
            //val HDD = HierarchicalDeltaDebugger(newFile.node)
            //HDD.hdd(endNode)
            //2 variant
            val lines = endNode.text.lines()
            var copy = file.copy() as KtFile
            for (i in 1 until lines.size) {
                monElements.clear()
                val oldCopy = copy.copy() as KtFile
                computeSlice(copy, line + i)
                if (copy.text != oldCopy.text && !checker.checkTest(copy.text))
                    copy = oldCopy
            }
            newFile = copy
        } else {
            val func = endNode.psi.getParentOfType<KtNamedFunction>(false) ?: return
            if (func.hasBlockBody() && func.bodyExpression != null) {
                func.bodyExpression!!
                        .allChildren
                        .toList()
                        .filter { checkingExpressions.contains(it.node.elementType) }
                        .asReversed()
                        .map { it.accept(this) }
            }
            //Now try to delete global variables
            func.parents.forEach {
                it.allChildren.toList()
                        .filter { ch -> checkingExpressions.contains(ch.node.elementType) }
                        .asReversed()
                        .map { it.accept(this) }
            }
        }
    }

    override fun visitUnaryExpression(expression: KtUnaryExpression) {
        val identifier = expression.node.getAllChildrenNodes().filter { isIdentifier(it) }[0]
        if (monElements.any { it.text == identifier.text })
            checkAvInBlocks(expression.node)
        else
            checker.removeNodeIfPossible(newFile, expression.node)
    }

    override fun visitBinaryExpression(expression: KtBinaryExpression) {
        //Checking for operationToken exist
        if (expression.node.findChildByType(KtNodeTypes.OPERATION_REFERENCE) == null)
            return
        if (expression.operationToken == KtTokens.EQ
                || OperatorConventions.ASSIGNMENT_OPERATIONS.keys.contains(expression.operationToken)) {
            val left = expression.left?.node?.getAllChildrenNodes()?.filter { isIdentifier(it) }
            val right = expression.right?.node?.getAllChildrenNodes()?.filter { isIdentifier(it) }
            if (left?.size!! < 1)
                return
            if (monElements.any { it.text == left[0].text }) {
                checkAvInBlocks(expression.node)
                right?.forEach { monElements.add(it) }
            } else {
                checker.removeNodeIfPossible(newFile, expression.node)
            }
        }
    }

    private fun checkAvInBlocks(node: ASTNode) {
        val blockConstructions = node.getAllParents().filter { blockConstructions.contains(it.elementType) }
        for (b in blockConstructions) {
            b.getAllChildrenNodes()
                    .filter { isIdentifier(it) }
                    .forEach { monElements.add(it) }
        }
    }

    override fun visitProperty(property: KtProperty) {
        val left = property.nameIdentifier ?: return
        val right = property.initializer?.node?.getAllChildrenNodes()?.filter { isIdentifier(it) }
        if (monElements.any { it.text == left.text }) {
            checkAvInBlocks(property.node)
            right?.forEach { monElements.add(it) }
        } else checker.removeNodeIfPossible(newFile, property.node)
    }

    override fun visitCallExpression(expression: KtCallExpression) {
        val identifiers = expression.node.getAllChildrenNodes().filter { isIdentifier(it) }
        for (i in identifiers)
            if (monElements.any { it.text == i.text })
                return
        checker.removeNodeIfPossible(newFile, expression.node)
    }

    override fun visitDotQualifiedExpression(expression: KtDotQualifiedExpression) {
        val identifiers = expression.node.getAllChildrenNodes().filter { isIdentifier(it) }
        for (i in identifiers)
            if (monElements.any { it.text == i.text })
                return
        checker.removeNodeIfPossible(newFile, expression.node)
    }

    override fun visitKtFile(file: KtFile) {
        file.allChildren.toList().asReversed().map { it.accept(this) }
    }

    fun getNewFile(): KtFile = newFile

    private fun isIdentifier(node: ASTNode): Boolean = node.elementType == KtTokens.IDENTIFIER

    private val checkingExpressions = listOf(KtNodeTypes.PROPERTY, KtNodeTypes.BINARY_EXPRESSION,
            KtNodeTypes.DOT_QUALIFIED_EXPRESSION, KtNodeTypes.CALL_EXPRESSION)
    private val blockConstructions = listOf(KtNodeTypes.IF, KtNodeTypes.FOR, KtNodeTypes.TRY,
            KtNodeTypes.CATCH, KtNodeTypes.FINALLY, KtNodeTypes.WHILE, KtNodeTypes.DO_WHILE)
    private val monElements = HashSet<ASTNode>()

    private lateinit var newFile: KtFile
    private lateinit var endNode: ASTNode
}