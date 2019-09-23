package com.stepanov.reduktor.passes

import com.intellij.psi.PsiWhiteSpace
import com.stepanov.reduktor.executor.CompilerTestChecker
import com.stepanov.reduktor.util.getAllChildrenNodes
import org.jetbrains.kotlin.psi.KtFile
import org.jetbrains.kotlin.psi.KtPsiFactory

class RemoveWhitespaces(private val file: KtFile, private val checker: CompilerTestChecker) {

    fun transform() {
        file.node.getAllChildrenNodes()
                .filter { it.psi is PsiWhiteSpace }
                .filter { it.text.count { it == '\n' } > 1}
                .forEach {
                    checker.replaceNodeIfPossible(file, it, KtPsiFactory(file.project).createWhiteSpace("\n").node)
                }
        val children = file.node.getAllChildrenNodes()
        children
                .filterIndexed { index, astNode -> index > 0 && children[index - 1] is PsiWhiteSpace && astNode.psi is PsiWhiteSpace }
                .forEach { checker.replaceNodeIfPossible(file, it.psi, KtPsiFactory(file.project).createWhiteSpace(" ")) }
    }
}