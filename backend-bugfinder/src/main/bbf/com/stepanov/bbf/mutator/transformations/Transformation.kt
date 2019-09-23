package com.stepanov.bbf.mutator.transformations

import org.jetbrains.kotlin.psi.KtFile
import org.jetbrains.kotlin.psi.KtPsiFactory

abstract class Transformation {
    abstract fun transform()

    val psiFactory = KtPsiFactory(file.project)

    companion object {
        lateinit var file: KtFile
    }

}