package com.stepanov.reduktor.passes

import com.intellij.psi.PsiElement
import com.stepanov.reduktor.executor.CompilerTestChecker
import com.stepanov.reduktor.util.*
import org.jetbrains.kotlin.lexer.KtTokens
import org.jetbrains.kotlin.psi.*
import org.jetbrains.kotlin.psi.psiUtil.allChildren
import org.jetbrains.kotlin.psi.psiUtil.getCallNameExpression

class SimplifyConstructor(private val file: KtFile, private val checker: CompilerTestChecker) {

    //TODO handle labmdas
    fun transform() {
        file.getAllPSIChildrenOfType<KtClass>()
                .filter { it.name != null && it.primaryConstructor != null }
                //Filter constructors with lambdas
                .filter { it.primaryConstructor!!.getAllPSIChildrenOfType<KtFunctionType>().isEmpty() }
                .forEach {
                    //Get all invocations
                    val invocations = file.getAllPSIChildrenOfType<KtCallExpression>()
                            .filter { call -> call.getCallNameExpression() != null }
                            .filter { call -> call.getCallNameExpression()!!.textMatches(it.name!!) }
                            .filter { call ->
                                call.valueArguments.size == it.primaryConstructorParameters.size
                                        && it.primaryConstructorParameters.isNotEmpty()
                            }
                            .map { it as KtCallElement }
                            .toMutableList()
                    val callees = file.getAllPSIChildrenOfType<KtSuperTypeCallEntry>()
                            .filter { call -> call.getCallNameExpression() != null }
                            .filter { call -> call.getCallNameExpression()!!.textMatches(it.name!!) }
                            .filter { call ->
                                call.valueArguments.size == it.primaryConstructorParameters.size
                                        && it.primaryConstructorParameters.isNotEmpty()
                            }
                    callees.forEach { invocations.add(it) }
                    var primaryConstructor: List<PsiElement>
                    var valueParameters = it.primaryConstructorParameters
                    if (valueParameters.isEmpty()) return@forEach
                    var i = 0
                    while (i < valueParameters.size - 1) {
                        primaryConstructor = it.primaryConstructor?.allChildren?.first { it is KtParameterList }?.allChildren?.toList()
                                ?: return@forEach
                        valueParameters = it.primaryConstructorParameters
                        if (valueParameters.size <= 1) return@forEach

                        val v = valueParameters[i]
                        val next = valueParameters[i + 1]
                        var fl = false
                        val oldCopy = it.primaryConstructor!!.copy() as KtPrimaryConstructor
                        primaryConstructor.forEach {
                            if (it == v)
                                fl = true
                            if (it == next)
                                fl = false
                            if (fl) {
                                file.node.removeChild(it.node)
                            }
                        }
                        //Remove from invocations
                        val oldArgsCopies = mutableListOf<KtValueArgument>()
                        invocations.forEach {
                            oldArgsCopies.add(it.valueArgumentList!!.arguments[i])
                            it.valueArgumentList?.removeArgument(i)
                        }
                        if (!checker.checkTest(file.text)) {
                            it.primaryConstructor!!.replaceThis(oldCopy)
                            for (j in 0 until invocations.size) {
                                val newArg = KtPsiFactory(file.project).createArgument(oldArgsCopies[j].text)
                                val invoke = invocations[j]
                                invoke.valueArgumentList!!.addArgumentBefore(newArg, invoke.valueArgumentList!!.arguments[i])
                            }
                            valueParameters = oldCopy.valueParameters
                            ++i
                        } else {
                            valueParameters = it.primaryConstructorParameters
                        }
                    }
                    //Process last element
                    primaryConstructor = it.primaryConstructor?.allChildren?.first?.allChildren?.toList()!!
                    val lastParam = it.primaryConstructorParameters.last()
                    val lastArgs = invocations.map { it.valueArguments.last() }
                    val constructorCopy = it.primaryConstructor!!.copy() as KtPrimaryConstructor
                    var prevComma: PsiElement? = null
                    primaryConstructor.forEach {
                        if (it == lastParam) {
                            file.node.removeChild(it.node)
                            prevComma?.let { comma -> file.node.removeChild(comma.node) }
                        } else if (it.node.elementType == KtTokens.COMMA)
                            prevComma = it
                    }
                    invocations.forEach {
                        it.valueArgumentList?.removeArgument(it.valueArguments.size - 1)
                    }
                    if (!checker.checkTest(file.text)) {
                        it.primaryConstructor?.replaceThis(constructorCopy)
                        for (j in 0 until invocations.size) {
                            val newArg = KtPsiFactory(file.project).createArgument(lastArgs[j].text)
                            invocations[j].valueArgumentList!!.addArgument(newArg)
                        }
                    }
                }
    }
}

private val ValueArgument.text: String
    get() = this.asElement().text

