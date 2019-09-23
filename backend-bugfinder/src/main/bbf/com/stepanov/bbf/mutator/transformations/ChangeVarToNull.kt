package com.stepanov.bbf.mutator.transformations

import org.jetbrains.kotlin.psi.KtExpression
import com.stepanov.bbf.executor.MutationChecker
import com.stepanov.bbf.util.getAllPSIChildrenOfType
import com.stepanov.bbf.util.getRandomBoolean

class ChangeVarToNull : Transformation() {

    override fun transform() {
        file.getAllPSIChildrenOfType<KtExpression>()
                .filter { getRandomBoolean(16) }
                .forEach { MutationChecker.replacePSINodeIfPossible(file, it, psiFactory.createExpression("null")) }
    }

}