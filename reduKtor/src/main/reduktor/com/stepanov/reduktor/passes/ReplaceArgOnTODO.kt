package com.stepanov.reduktor.passes

import com.stepanov.reduktor.executor.CompilerTestChecker
import com.stepanov.reduktor.util.getAllPSIChildrenOfType
import org.jetbrains.kotlin.psi.KtCallExpression
import org.jetbrains.kotlin.psi.KtFile
import org.jetbrains.kotlin.psi.KtPsiFactory
import org.jetbrains.kotlin.psi.KtValueArgument

class ReplaceArgOnTODO(private val file: KtFile, private val checker: CompilerTestChecker) {


    fun transform() {
        file
                .getAllPSIChildrenOfType<KtCallExpression>()
                .filter { it.valueArguments.size != 0 }
                .forEach { call ->
                    for (i in 0 until call.valueArguments.size - 1)
                        replaceArgOnTODO(call, i)
                    replaceLastArgOnTODO(call)
                }
    }

    private fun replaceArgOnTODO(call: KtCallExpression, i: Int) {
        val oldArg = call.valueArguments[i].copy() as KtValueArgument
        val nextArg = call.valueArguments[i + 1]
        call.valueArgumentList?.removeArgument(i)
        val todoArg = KtPsiFactory(file.project).createArgument("TODO()")
        call.valueArgumentList?.addArgumentBefore(todoArg, nextArg)
        if (!checker.checkTest(file.text)) {
            call.valueArgumentList?.removeArgument(i)
            call.valueArgumentList?.addArgumentBefore(oldArg, nextArg)
        }
    }

    private fun replaceLastArgOnTODO(call: KtCallExpression) {
        val size = call.valueArguments.size
        val lastArg = call.valueArguments.last()
        val argCopy = lastArg.copy() as KtValueArgument
        val todoArg = KtPsiFactory(file.project).createArgument("TODO()")
        call.valueArgumentList?.removeArgument(lastArg)
        call.valueArgumentList?.addArgument(todoArg)
        if (!checker.checkTest(file.text)) {
            call.valueArgumentList?.removeArgument(size - 1)
            call.valueArgumentList?.addArgument(argCopy)
        }
    }

}