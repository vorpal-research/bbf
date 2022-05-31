package com.stepanov.bbf.tracer

import com.intellij.psi.PsiElement
import org.jetbrains.kotlin.psi.*
import java.io.BufferedWriter
import java.io.File
import java.io.FileWriter
import com.stepanov.reduktor.parser.PSICreator
import com.stepanov.bbf.executor.MutationChecker
import org.jetbrains.kotlin.builtins.isFunctionType
import org.jetbrains.kotlin.builtins.isFunctionTypeOrSubtype
import org.jetbrains.kotlin.psi.psiUtil.*
import org.jetbrains.kotlin.resolve.BindingContext
import org.jetbrains.kotlin.resolve.bindingContextUtil.getAbbreviatedTypeOrType
import org.jetbrains.kotlin.types.KotlinType
import org.jetbrains.kotlin.types.typeUtil.isAnyOrNullableAny
import com.stepanov.bbf.util.getAllPSIChildrenOfType
import com.stepanov.bbf.util.getAllPSIDFSChildrenOfType
import com.stepanov.bbf.util.isBlockExpr
import com.stepanov.bbf.util.replaceThis
import java.lang.StringBuilder

//TODO delete getType fun
class Tracer(private var tree: KtFile, private val ctx: BindingContext) : KtVisitorVoid() {

    fun trace(): KtFile {
        //Handle all functions
        tree.getAllPSIChildrenOfType<KtNamedFunction>().forEach { it.accept(this) }
        //Classes
        tree.getAllPSIChildrenOfType<KtClass>().forEach { handleClass(it) }

        //Global vars

        //newTree.debugPrint()
        //Handle all control instructions
        tree.getAllPSIChildrenOfType<KtIfExpression>().forEach { it.accept(this) }
        tree.getAllPSIChildrenOfType<KtDoWhileExpression>().forEach { it.accept(this) }
        tree.getAllPSIChildrenOfType<KtWhileExpression>().forEach { it.accept(this) }
        tree.getAllPSIChildrenOfType<KtWhenExpression>().forEach { it.accept(this) }
        tree.getAllPSIChildrenOfType<KtTryExpression>().forEach { it.accept(this) }
        //Saving
//        tree.name = tree.name.dropLastWhile { it != '/' } + "traced/traced_" + tree.name.split('/').last()
        saveTracedFile(tree)
        return PSICreator("").getPSIForFile(tree.name)
    }

    private fun handleClass(klass: KtClass) {
        if (klass.isInterface() || klass.isEnum() || klass is KtEnumEntry || klass.isAnnotation())
            return
        if (klass.getAllPSIChildrenOfType<KtFunction>().any { it.name == "toString" })
            return
        //Filter extension fields
        val fields = getFieldsFromClass(klass).filterNot { it.isExtensionDeclaration() }
        if (fields.isEmpty()) return
        val newFun = StringBuilder()
        newFun.append("var res = \"\"\n")
        for (f in fields) {
            val type = f.getType() ?: continue
            if (type.isFunctionTypeOrSubtype)
                continue
            if (f.text.contains("lateinit")) {
                newFun.append("if (this::${f.name}.isInitialized) {\n")
            }
            var c = 0
            var args = type.arguments
            if (type.isIterable()) {
                newFun.append("res += ${f.name}.map {")
                while (args.size == 1 && args.first().type.isIterable()) {
                    newFun.append("it.map {")
                    args = args.first().type.arguments
                    c++
                }
                newFun.append("it.toString() }")
                repeat(c) { newFun.append("}") }
                newFun.append("\n")
            } else {
                newFun.append("res += ${f.name}.toString()\n")
            }
            if (f.text.contains("lateinit")) {
                newFun.append("}\n")
            }
        }
        newFun.append("return res\n}\n")
        val newFunc = factory.createFunction("override fun toString(): String")
        val block = factory.createBlock(newFun.toString())
        newFunc.node.addChild(block.node, null)
        //TODO addIfPossible
        if (klass.body != null)
            MutationChecker.addNodeIfPossible(tree, klass.body!!.rBrace!!, newFunc, true)
        else
            MutationChecker.addNodeIfPossible(tree, klass, factory.createBlock(newFunc.text))
//            klass.body!!.addBefore(newFunc, klass.body!!.rBrace)
//        else
//            klass.add(factory.createBlock(newFunc.text))
    }

    private fun saveTracedFile(newFile: KtFile) {
//        val dir = newFile.name.substring(0, newFile.name.indexOfLast { it == '/' })
//        File(dir).mkdir()
        BufferedWriter(FileWriter(File(newFile.name))).apply { write(newFile.text); close() }
    }

    private fun createNewBlockExpr(expr: KtExpression, msg: String): KtExpression {
        if (expr is KtBlockExpression) {
            expr.lBrace?.let { expr.deleteChildInternal(it.node) }
            expr.rBrace?.let { expr.deleteChildInternal(it.node) }
        }
        //If msg contains quotes
        val newMsg = msg.filter { it != '"' }
        return factory.createBlock("println(\"$newMsg\");\n${expr.text}")
    }

    override fun visitNamedFunction(function: KtNamedFunction) {
        val block = function.getChildOfType<KtBlockExpression>() ?: return
        //Init by args
        val trackingVars = function.valueParameters
                .asSequence()
                .filter { it.getType()?.isFunctionType == false && it.getType()?.isAnyOrNullableAny() == false }
                .map { it.name }
                .filterNotNull()
                .map { factory.createExpression("println($it);") }
                .toMutableList()
        handleBlock(block, trackingVars)
    }

    private fun handleBlock(block: PsiElement, trackingVars: List<KtExpression>) {
        val curTrack = trackingVars.toMutableList()
        for (el in block.getAllPSIDFSChildrenOfType<PsiElement>()) {
            if (el.getParentOfType<KtBlockExpression>(true) != block || el.getParentOfType<KtClassBody>(true) != block)
                continue
            if (el is KtClassBody && el.isBlockExpr()) {
                if (el.text != block.text)
                    handleBlock(el, curTrack)
            }
            if (el is KtBlockExpression) {
                if (el.text != block.text)
                    handleBlock(el, curTrack)
            }
            if (el is KtProperty) {
                val clazzWithPropType = getClassWithName(el.getType()?.toString())
                if (clazzWithPropType != null &&
                        clazzWithPropType.getAllPSIChildrenOfType<KtNamedFunction>().all { it.name != "toString()" }) continue
                if (!el.hasInitializer()) continue
                // Handle objectLiteral
                if (el.initializer is KtObjectLiteralExpression) continue
                if (el.getType()?.isFunctionTypeOrSubtype == true || el.getType()?.isAnyOrNullableAny() == true) continue
                if (el.name != null) {
                    curTrack.add(factory.createExpression("println(${el.name});"))
                }
            }
            if (el is KtReturnExpression) {
                if (el.parent is KtBlockExpression) {
                    curTrack.forEach {
                        el.parent.addBefore(it, el)
                        el.parent.addBefore(factory.createWhiteSpace("\n"), el)
                    }
                } else {
                    val newBlock = factory.createBlock("${curTrack.joinToString("\n") { it.text }}\n${el.text}")
                    el.replaceThis(newBlock)
                }
            }
        }
    }

    override fun visitIfExpression(expression: KtIfExpression) {
        expression.then?.let { it.replaceThis(createNewBlockExpr(it, "THEN")) }
        expression.`else`?.let { it.replaceThis(createNewBlockExpr(it, "ELSE")) }
    }

    override fun visitDoWhileExpression(expression: KtDoWhileExpression) {
        val msg = "DO WHILE (\${${expression.condition?.text}})"
        expression.body?.let { it.replaceThis(createNewBlockExpr(it, msg)) }
    }

    override fun visitWhileExpression(expression: KtWhileExpression) {
        val msg = "WHILE (\${${expression.condition?.text}})"
        expression.body?.let { it.replaceThis(createNewBlockExpr(it, msg)) }
    }

    override fun visitWhenExpression(expression: KtWhenExpression) {
        for (entry in expression.entries) {
            entry.expression?.let { entryExpression ->
                entryExpression.replaceThis(createNewBlockExpr(entryExpression, "WHEN ${
                    entry.conditions.joinToString { condition ->
                        if (condition.text.first() == '"')
                            condition.text.substring(1, condition.textLength - 1)
                        else
                            condition.text
                    }
                }"))
            }
        }
    }

    override fun visitTryExpression(expression: KtTryExpression) {
        expression.tryBlock.replaceThis(createNewBlockExpr(expression.tryBlock, "TRY"))
        for (catch in expression.catchClauses) {
            catch.catchBody?.let { it.replaceThis(createNewBlockExpr(it, "CATCH ${catch.catchParameter?.text}")) }
        }
        expression.finallyBlock?.finalExpression?.let { it.replaceThis(createNewBlockExpr(it, "FINALLY")) }
    }

    private fun getFieldsFromClass(klass: KtClass): List<KtExpression> {
        val res = mutableListOf<KtExpression>()
        klass.primaryConstructorParameters.forEach {
            if (it.hasValOrVar()) res.add(it)
        }
        klass.getProperties().forEach { res.add(it) }
        return res
    }


    private fun getClassWithName(name: String?): KtClass? = tree.getAllPSIChildrenOfType<KtClass>().find { it.name == name }
    private fun KotlinType.isIterable(): Boolean = this.memberScope.getFunctionNames().any { it.toString() == "iterator" }
    private fun KtExpression.getType(): KotlinType? {
        val typesOfExpressions = this.getAllPSIChildrenOfType<KtExpression>().mapNotNull { ctx.getType(it) }
        val typeReferences = this.getAllPSIChildrenOfType<KtTypeReference>().mapNotNull { it.getAbbreviatedTypeOrType(ctx) }
        return when {
            typesOfExpressions.isNotEmpty() -> typesOfExpressions.first()
            typeReferences.isNotEmpty() -> typeReferences.first()
            else -> null
        }
    }

    private val factory: KtPsiFactory = KtPsiFactory(tree)

}