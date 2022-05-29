package com.stepanov.reduktor.util

import org.jetbrains.kotlin.psi.KtFile
import org.jetbrains.kotlin.psi.KtPsiFactory

object ExpressionFactory {

    fun initFactory(project: KtFile) {
        factory = KtPsiFactory(project)
    }

    lateinit var factory: KtPsiFactory
        private set
}

