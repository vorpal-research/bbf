package com.stepanov.bbf.util

import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.stepanov.bbf.executor.CommonCompiler
import com.stepanov.reduktor.util.replaceReturnValueTypeOnUnit
import com.stepanov.reduktor.util.replaceThis
import org.jetbrains.kotlin.psi.KtExpression
import org.jetbrains.kotlin.psi.KtNamedFunction
import org.jetbrains.kotlin.psi.KtPsiFactory
import org.jetbrains.kotlin.psi.KtTypeReference
import org.jetbrains.kotlin.resolve.BindingContext
import org.jetbrains.kotlin.resolve.bindingContextUtil.getAbbreviatedTypeOrType
import org.jetbrains.kotlin.types.KotlinType
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.SequenceInputStream

enum class Stream {
    INPUT, ERROR, BOTH
}

fun KtExpression.getType(ctx: BindingContext): KotlinType? {
    val typesOfExpressions = this.getAllPSIChildrenOfType<KtExpression>().mapNotNull { ctx.getType(it) }
    val typeReferences = this.getAllPSIChildrenOfType<KtTypeReference>().mapNotNull { it.getAbbreviatedTypeOrType(ctx) }
    return when {
        typesOfExpressions.isNotEmpty() -> typesOfExpressions.first()
        typeReferences.isNotEmpty() -> typeReferences.first()
        else -> null
    }
}


fun KtNamedFunction.initBodyByValue(psiFactory: KtPsiFactory, value: String) {
    if (!this.hasBody()) {
        return
    } else if (this.hasBlockBody()) {
        if (this.typeReference == null) {
            replaceReturnValueTypeOnUnit(psiFactory)
            this.node.removeChild(this.bodyExpression!!.node)
            this.add(psiFactory.createEmptyBody())
            return
        }
        val eq = psiFactory.createEQ()
        val space = psiFactory.createWhiteSpace(" ")
        val valExp = psiFactory.createExpression(value)
        this.node.removeChild(this.bodyExpression!!.node)
        this.add(eq)
        this.add(space)
        this.add(valExp)
    } else {
        val valExp = psiFactory.createExpression(value)
        this.bodyExpression!!.replaceThis(valExp)
    }
}

fun PsiElement.find(el: PsiElement): PsiElement? = this.node.getAllChildrenNodes().find { it.psi == el }?.psi

//Returns true if all compilers compiling
fun List<CommonCompiler>.checkCompilingForAllBackends(psiFile: PsiFile): Boolean =
        this.map { it.checkCompilingText(psiFile.text) }.all { it }