package com.stepanov.reduktor.passes

import com.intellij.psi.PsiWhiteSpace
import com.stepanov.reduktor.executor.CompilerTestChecker
import com.stepanov.reduktor.util.*
import org.jetbrains.kotlin.lexer.KtTokens
import org.jetbrains.kotlin.psi.KtCallExpression
import org.jetbrains.kotlin.psi.KtFile
import org.jetbrains.kotlin.psi.KtNamedFunction
import org.jetbrains.kotlin.psi.KtPsiFactory

class FunInliner(private val file: KtFile, private val checker: CompilerTestChecker) {

    fun transform() {
        val funcs = file.getAllPSIChildrenOfType<KtNamedFunction>()
        for (f in funcs) {
            for (c in f.getAllPSIChildrenOfType<KtCallExpression>()) {
                val calledFunc = funcs.filter { c.calleeExpression?.text == it.name }
                if (calledFunc.size == 1) {
                    val called = calledFunc.first()
                    val lines = called.getAllPSIChildrenOfType<PsiWhiteSpace>()
                            .fold(0, { acc, next -> acc + next.text.count { it == '\n' } })
                    if (called != f && lines < 10 && called.valueParameters.size == c.valueArguments.size) {
                        performInlining(c, called)
                    }
                }
            }
        }
    }

    private fun performInlining(call: KtCallExpression, f: KtNamedFunction) {
        val funCopy = f.copy() as KtNamedFunction
        funCopy.bodyExpression?.let { body ->
            for ((i, arg) in call.valueArguments.withIndex()) {
                val par = f.valueParameters[i]
                val argCopy = factory.createExpression(arg.text)

                body.node.getAllChildrenNodes()
                        .filter { it.elementType == KtTokens.IDENTIFIER }
                        .filter { it.text == par.nameIdentifier?.text }
                        .forEach { it.psi.replaceThis(argCopy) }
            }
            val runExpression = if (f.hasBlockBody()) {
                KtPsiFactory(file.project).createExpression("run ${body.text}")
            } else {
                KtPsiFactory(file.project).createExpression("run {${body.text}}")
            }
            checker.replaceNodeIfPossible(file, call.node, runExpression.node)
        }
    }

    private val factory = KtPsiFactory(file)
}