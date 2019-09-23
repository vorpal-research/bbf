package com.stepanov.reduktor.passes

import com.stepanov.reduktor.executor.CompilerTestChecker
import com.stepanov.reduktor.util.getAllChildrenNodes
import org.jetbrains.kotlin.KtNodeTypes
import org.jetbrains.kotlin.lexer.KtTokens
import org.jetbrains.kotlin.psi.KtBinaryExpression
import org.jetbrains.kotlin.psi.KtFile

class ElvisOperatorSimplifier(private val file: KtFile, private val checker: CompilerTestChecker) {
    fun transform() {
        var elvExpr = getAllElvisExpressions()
        for (b in elvExpr) {
            checker.replaceNodeIfPossible(file, b.node, b.right!!.node)
        }
        elvExpr = getAllElvisExpressions()
        for (b in elvExpr) {
            checker.replaceNodeIfPossible(file, b.node, b.left!!.node)
        }
    }

    private fun getAllElvisExpressions() = file.node.getAllChildrenNodes()
            .map { it.psi }
            .filter {
                it is KtBinaryExpression && it.node.findChildByType(KtNodeTypes.OPERATION_REFERENCE) != null
                        && it.operationToken == KtTokens.ELVIS && it.left != null && it.right != null
            }
            .map { it as KtBinaryExpression }
}