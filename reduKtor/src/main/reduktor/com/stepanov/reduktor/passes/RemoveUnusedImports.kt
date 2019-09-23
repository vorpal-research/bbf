package com.stepanov.reduktor.passes

import com.intellij.psi.PsiWhiteSpace
import com.stepanov.reduktor.executor.CompilerTestChecker
import com.stepanov.reduktor.util.*
import org.jetbrains.kotlin.psi.KtFile
import org.jetbrains.kotlin.psi.KtImportDirective
import org.jetbrains.kotlin.psi.psiUtil.allChildren

class RemoveUnusedImports(private val file: KtFile, private val checker: CompilerTestChecker) {
    fun transform() {
        file.importList?.let { importList ->
            for (im in importList.allChildren.toList()) {
                if (im !is KtImportDirective)
                    continue
                //Deleting
                checker.removeNodeIfPossible(file, im.node)
            }
        }
        filterPsiWhitespaces(file)
    }

    private fun filterPsiWhitespaces(file: KtFile) {
        val children = file.importList!!.node.getAllChildrenOfCurLevel()
        for (i in 1 until children.size) {
            if (children[i] is PsiWhiteSpace && children[i - 1] is PsiWhiteSpace) {
                file.importList?.node?.removeChild(children[i])
            }
        }
    }
}