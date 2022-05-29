package com.stepanov.bbf.mutator.transformations

import com.stepanov.bbf.executor.MutationChecker
import org.jetbrains.kotlin.lexer.KtTokens
import org.jetbrains.kotlin.psi.KtArrayAccessExpression
import org.jetbrains.kotlin.psi.KtBinaryExpression
import org.jetbrains.kotlin.psi.KtExpression
import org.jetbrains.kotlin.psi.KtUnaryExpression
import com.stepanov.bbf.util.getAllPSIDFSChildrenOfType
import java.util.*

class ChangeOperatorsToFunInvocations : Transformation() {

    override fun transform() {
        var oldText = file.text
        var newText: String
        while (true) {
            transformImpl()
            newText = file.text
            if (newText == oldText)
                break
            else
                oldText = newText
        }
    }

    //To handle nested constructions
    private fun transformImpl() {
        for (psiNode in file.getAllPSIDFSChildrenOfType<KtExpression>()) {
            //Probablity!
            if (Random().nextBoolean())
                continue

            when (psiNode) {
                is KtArrayAccessExpression -> handleArrayAccessExpression(psiNode)
                is KtUnaryExpression -> handleUnaryExpression(psiNode)
                is KtBinaryExpression -> handleBinaryExpression(psiNode)
            }
        }
    }


    private fun handleArrayAccessExpression(exp: KtArrayAccessExpression) {
        val parent = exp.parent
        val base = exp.arrayExpression ?: return
        if (parent is KtBinaryExpression && parent.operationToken.toString().contains("EQ"))
            return
        val params = exp.indexExpressions.joinToString(separator = ",") { it.text }
        val newCall = createCall(base.text, "get", params)
        MutationChecker.replacePSINodeIfPossible(file, exp, newCall)
        //exp.replaceThis(newCall)
    }


    private fun handleUnaryExpression(exp: KtUnaryExpression) {
        val newCall = when (exp.operationToken) {
            KtTokens.PLUS -> "unaryPlus"
            KtTokens.MINUS -> "unaryMinus"
            KtTokens.PLUSPLUS -> "inc"
            KtTokens.MINUSMINUS -> "dec"
            KtTokens.EXCL -> "not"
            else -> return
        }
        exp.baseExpression?.let {
            //exp.replaceThis(createCall(it.text, newCall))
            MutationChecker.replacePSINodeIfPossible(file, exp, createCall(it.text, newCall))
        }
    }

    private fun handleBinaryExpression(exp: KtBinaryExpression) {
        val left = exp.left ?: return
        val right = exp.right ?: return
        if (exp.operationToken == KtTokens.EQEQ) {
            val newExp = psiFactory.createExpression("(${left.text})?.equals(${right.text}) ?: (${right.text} === null)")
            MutationChecker.replacePSINodeIfPossible(file, exp, newExp)
            //exp.replaceThis(newExp)
            return
        } else if (exp.operationToken in allowedEqs) {
            if (left is KtArrayAccessExpression) {
                val arrayExp = left.arrayExpression ?: return
                val params = "${left.indexExpressions.joinToString(separator = ",") { it.text }}, ${right.text}"
                val newCall = createCall(arrayExp.text, "set", params)
                //exp.replaceThis(newCall)
                MutationChecker.replacePSINodeIfPossible(file, exp, newCall)
                return
            }
        }
        val newCall = when (exp.operationToken) {
            KtTokens.PLUS -> "plus"
            KtTokens.MINUS -> "minus"
            KtTokens.MUL -> "times"
            KtTokens.DIV -> "div"
            KtTokens.RANGE -> "rangeTo"
            KtTokens.IN_KEYWORD -> "contains"
            KtTokens.PERC -> "rem"
//            KtTokens.PLUSEQ -> "plusAssign"
//            KtTokens.MINUSEQ -> "minusAssign"
//            KtTokens.MULTEQ -> "timesAssign"
//            KtTokens.DIVEQ -> "divAssign"
            else -> return
        }
        MutationChecker.replacePSINodeIfPossible(file, exp, createCallWithBraces(left.text, newCall, right.text))
        //exp.replaceThis(createCallWithBraces(left.text, newCall, right.text))
    }

    private fun createCall(base: String, func: String, params: String = "") =
            psiFactory.createExpression("$base.$func($params)")

    private fun createCallWithBraces(base: String, func: String, params: String = "") =
            psiFactory.createExpression("($base).$func($params)")

    private val allowedEqs = listOf(KtTokens.EQ, KtTokens.MINUSEQ, KtTokens.PLUSEQ,
            KtTokens.MULTEQ, KtTokens.DIVEQ, KtTokens.PERCEQ)

}