package com.stepanov.reduktor.passes

import com.stepanov.reduktor.executor.CompilerTestChecker
import org.jetbrains.kotlin.psi.*

class SimplifyLambdaExpression(private val file: KtFile, private val checker: CompilerTestChecker) {

//    fun transform() {
//        val lambdas = file.getAllPSIChildrenOfType<KtLambdaExpression>()
//        lambdas
//                .filter { it.getAllPSIChildrenOfType<KtBlockExpression>().isNotEmpty() }
//                .filter { it.bodyExpression != null }
//                .forEach {
//                    val copy = it.copy() as KtLambdaExpression
//                    val body = it.bodyExpression!! as KtExpression
//                    val block = KtPsiFactory(file.project).createBlock(body.text)
//                    it.replaceThis(block)
//                    if (!checker.checkTest(file.text))
//                        block.replaceThis(copy)
//                }
//    }
}