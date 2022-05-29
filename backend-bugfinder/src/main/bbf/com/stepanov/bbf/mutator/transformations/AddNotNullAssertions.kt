package com.stepanov.bbf.mutator.transformations

import org.jetbrains.kotlin.psi.KtExpression
import com.stepanov.bbf.executor.MutationChecker
import com.stepanov.bbf.util.getAllPSIChildrenOfType

class AddNotNullAssertions : Transformation() {


    override fun transform() {
        file.getAllPSIChildrenOfType<KtExpression>()
                .map { tryToAddNotNullAssertion(it) }
    }

    private fun tryToAddNotNullAssertion(exp: KtExpression) {
        val newExp = psiFactory.createExpressionIfPossible("${exp.text}!!") ?: return
        MutationChecker.replacePSINodeIfPossible(file, exp, newExp)
    }
}
