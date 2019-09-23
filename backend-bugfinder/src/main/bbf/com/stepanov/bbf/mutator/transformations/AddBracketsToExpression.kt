package com.stepanov.bbf.mutator.transformations

import com.stepanov.bbf.executor.MutationChecker
import org.jetbrains.kotlin.psi.KtExpression
import org.jetbrains.kotlin.psi.KtWhenExpression
import com.stepanov.bbf.util.getAllPSIChildrenOfType
import com.stepanov.bbf.util.getRandomBoolean

class AddBracketsToExpression : Transformation() {

    override fun transform() {
        file.getAllPSIChildrenOfType<KtExpression>().filter { getRandomBoolean(4) }.forEach {
            //KOSTYL'!!!!!!
            if (it is KtWhenExpression) return@forEach

            val newExpr = psiFactory.createExpression("(${it.text})")
            MutationChecker.replacePSINodeIfPossible(file, it, newExpr)
        }
    }
}