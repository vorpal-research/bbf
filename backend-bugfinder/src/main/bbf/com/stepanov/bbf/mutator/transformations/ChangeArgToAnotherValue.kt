package com.stepanov.bbf.mutator.transformations

import org.jetbrains.kotlin.psi.KtCallExpression
import org.jetbrains.kotlin.psi.KtNamedFunction
import org.jetbrains.kotlin.psi.psiUtil.getCallNameExpression
import com.stepanov.bbf.executor.MutationChecker
import com.stepanov.bbf.util.generateDefValuesAsString
import com.stepanov.bbf.util.getAllPSIChildrenOfType

class ChangeArgToAnotherValue : Transformation() {

    //TODO For user classes
    override fun transform() {
        file.getAllPSIChildrenOfType<KtNamedFunction>().forEach { f ->
            getAllInvocations(f).forEach { inv ->
                inv.valueArguments.forEachIndexed { argInd, arg ->
                    if (argInd < f.valueParameters.size) {
                        val type = f.valueParameters[argInd].typeReference?.text ?: return@forEachIndexed
                        val newRandomValue = generateDefValuesAsString(type)
                        if (newRandomValue.isEmpty()) return@forEachIndexed
                        val newArg = psiFactory.createArgument(newRandomValue)
                        MutationChecker.replacePSINodeIfPossible(file, arg, newArg)
                    }
                }
            }
        }
    }

    private fun getAllInvocations(func: KtNamedFunction): List<KtCallExpression> {
        val res = mutableListOf<KtCallExpression>()
        file.getAllPSIChildrenOfType<KtCallExpression>()
                .filter {
                    it.getCallNameExpression()?.getReferencedName() == func.name &&
                            it.valueArguments.size == func.valueParameters.size
                }
                .forEach { res.add(it) }
        return res
    }
}