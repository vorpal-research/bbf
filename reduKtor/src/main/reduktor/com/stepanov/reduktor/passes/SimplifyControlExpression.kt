package com.stepanov.reduktor.passes

import com.stepanov.reduktor.executor.CompilerTestChecker
import com.stepanov.reduktor.util.getAllPSIChildrenOfType
import org.jetbrains.kotlin.psi.*


class SimplifyControlExpression(private val file: KtFile, private val checker: CompilerTestChecker) {
    fun transform() {
        val conExp = file.getAllPSIChildrenOfType<KtExpression>().filter { it.javaClass.simpleName in controlExpressions }
        val expToCond =
                conExp.map { exp ->
                    exp to
                            when (exp) {
                                is KtIfExpression -> exp.condition
                                is KtForExpression -> exp.loopParameter
                                is KtWhileExpression -> exp.condition
                                is KtWhenExpression -> exp.subjectExpression
                                else -> null
                            }
                }
                        .filter { it.second != null }
        expToCond.forEach { checker.replaceNodeIfPossible(file, it.first, it.second!!) }
    }


    private val controlExpressions =
            listOf("KtIfExpression", "KtWhenExpression", "KtWhileExpression", "KtForExpression")
}