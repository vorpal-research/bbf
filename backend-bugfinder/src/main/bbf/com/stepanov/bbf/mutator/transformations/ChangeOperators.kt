package com.stepanov.bbf.mutator.transformations

import com.intellij.lang.ASTNode
import com.stepanov.bbf.executor.MutationChecker
import org.jetbrains.kotlin.KtNodeTypes
import org.jetbrains.kotlin.lexer.KtTokens
import com.stepanov.bbf.util.getAllChildrenNodes
import com.stepanov.bbf.util.getRandomBoolean
import java.util.*

class ChangeOperators : Transformation() {

    override fun transform() {
        val operators = file.node.getAllChildrenNodes()
                .filter { it.treeParent.elementType == KtNodeTypes.OPERATION_REFERENCE || it.elementType == KtTokens.DOT }
        operators.forEach {
            when (it.text) {
                "<" -> replaceOperator(it.treeParent, listOf(">=", ">", "<=", "==", "!="))
                "<=" -> replaceOperator(it.treeParent, listOf(">=", "<", ">", "==", "!="))
                ">" -> replaceOperator(it.treeParent, listOf(">=", "<", "<=", "==", "!="))
                ">=" -> replaceOperator(it.treeParent, listOf(">", "<", "<=", "==", "!="))
                "==" -> replaceOperator(it.treeParent, "!=")
                "!=" -> replaceOperator(it.treeParent, "==")
                "+" -> replaceOperator(it.treeParent, listOf("-", "*", "/", "%"))
                "-" -> replaceOperator(it.treeParent, listOf("+", "*", "/", "%"))
                "/" -> replaceOperator(it.treeParent, listOf("-", "*", "+", "%"))
                "*" -> replaceOperator(it.treeParent, listOf("-", "+", "/", "%"))
                //TODO add ?.
                "." -> replaceOperator(it, "!!.")
                "+=" -> replaceOperator(it.treeParent, listOf("-=", "*=", "/="))
                "-=" -> replaceOperator(it.treeParent, listOf("+=", "*=", "/="))
                "*=" -> replaceOperator(it.treeParent, listOf("-=", "+=", "/="))
                "/=" -> replaceOperator(it.treeParent, listOf("-=", "*=", "+="))
                "&&" -> replaceOperator(it.treeParent, "||")
                "||" -> replaceOperator(it.treeParent, "&&")
                "++" -> replaceOperator(it, "--")
                "--" -> replaceOperator(it, "++")
                else -> return@forEach
            }
        }
    }

    private fun replaceOperator(replace: ASTNode, replacement: List<String>, isRandom: Boolean = true) {
        if (isRandom && getRandomBoolean() || !isRandom) {
            val index = Random().nextInt(replacement.size)
            replaceOperator(replace, replacement[index])
        }
    }

    private fun replaceOperator(replace: ASTNode, replacement: String, isRandom: Boolean = true) {
        if (isRandom && getRandomBoolean() || !isRandom) {
            val replacementNode =
                    if (replace.elementType == KtNodeTypes.OPERATION_REFERENCE)
                        psiFactory.createOperationName(replacement)
                    else
                        psiFactory.createExpression(replacement)

            MutationChecker.replacePSINodeIfPossible(file, replace.psi, replacementNode)
        }
    }


}