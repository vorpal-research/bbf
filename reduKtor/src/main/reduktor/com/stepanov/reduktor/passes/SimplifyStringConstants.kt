package com.stepanov.reduktor.passes

import com.stepanov.reduktor.executor.CompilerTestChecker
import com.stepanov.reduktor.util.getAllPSIChildrenOfType
import org.jetbrains.kotlin.psi.KtFile
import org.jetbrains.kotlin.psi.KtPsiFactory
import org.jetbrains.kotlin.psi.KtStringTemplateExpression

class SimplifyStringConstants(private val file: KtFile, private val checker: CompilerTestChecker) {
    fun transform() {
        val stringConsts = file.getAllPSIChildrenOfType<KtStringTemplateExpression>()
        stringConsts.forEach { checker.replaceNodeIfPossible(file, it, KtPsiFactory(file.project).createStringTemplate("")) }
    }
}
