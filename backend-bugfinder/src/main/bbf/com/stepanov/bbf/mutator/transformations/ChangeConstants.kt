package com.stepanov.bbf.mutator.transformations

import org.jetbrains.kotlin.psi.*
import com.stepanov.bbf.executor.MutationChecker
import com.stepanov.bbf.util.getAllPSIChildrenOfType
import com.stepanov.bbf.util.getRandomVariableName
import java.util.*

class ChangeConstants : Transformation() {

    enum class Type { BOOLEAN, INTEGER, DOUBLE }

    override fun transform() {
        val constants = file.getAllPSIChildrenOfType<KtConstantExpression>()
        val stringConstants = file.getAllPSIChildrenOfType<KtStringTemplateEntry>()
        constants.forEach {
            when {
                it.text == "true" || it.text == "false" -> changeExpression(it, Type.BOOLEAN)
                it.textContains('.') -> changeExpression(it, Type.DOUBLE)
                else -> changeExpression(it, Type.INTEGER)
            }
        }
        //println("constants = ${stringConstants.map { it.text }}")
        stringConstants
                .forEach { changeStringConst(it) }
    }

    private fun changeExpression(exp: KtExpression, type: Type, isRandom: Boolean = true) {
        val replacement = when (type) {
            Type.BOOLEAN -> psiFactory.createExpression("${Random().nextBoolean()}")
            Type.DOUBLE -> psiFactory.createExpression("${Random().nextDouble()}")
            Type.INTEGER -> psiFactory.createExpression("${Random().nextInt()}")
        }
        if (isRandom && Random().nextBoolean() || !isRandom)
            MutationChecker.replacePSINodeIfPossible(file, exp, replacement)
    }


    private fun changeStringConst(exp: KtStringTemplateEntry, isRandom: Boolean = true) =
            if (isRandom && Random().nextBoolean() || !isRandom)
                MutationChecker.replacePSINodeIfPossible(file, exp,
                        psiFactory.createExpression(Random().getRandomVariableName(NAME_SIZE)))
            else false

    private val NAME_SIZE = 5
}