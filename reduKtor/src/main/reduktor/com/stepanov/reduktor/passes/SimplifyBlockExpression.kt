package com.stepanov.reduktor.passes

import com.stepanov.reduktor.executor.CompilerTestChecker
import com.stepanov.reduktor.util.getAllPSIChildrenOfType
import org.jetbrains.kotlin.psi.KtBlockExpression
import org.jetbrains.kotlin.psi.KtFile
import org.jetbrains.kotlin.psi.psiUtil.parents

class SimplifyBlockExpression(private val file: KtFile, private val checker: CompilerTestChecker) {
    fun transform() {
        file.getAllPSIChildrenOfType<KtBlockExpression>().forEach { block ->
            val newBlock = block.copy() as KtBlockExpression
            if (newBlock.lBrace != null)
                newBlock.node.removeChild(newBlock.lBrace!!.node)
            if (newBlock.rBrace != null)
                newBlock.node.removeChild(newBlock.rBrace!!.node)
            for (p in block.parents.toList().reversed()) {
                if (checker.replaceNodeIfPossible(file, p, newBlock))
                    break
            }
        }
    }
}