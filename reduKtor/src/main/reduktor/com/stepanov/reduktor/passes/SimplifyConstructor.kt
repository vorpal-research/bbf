package com.stepanov.reduktor.passes

import com.intellij.psi.PsiElement
import com.stepanov.reduktor.executor.CompilerTestChecker
import com.stepanov.reduktor.util.*
import org.jetbrains.kotlin.lexer.KtTokens
import org.jetbrains.kotlin.psi.*
import org.jetbrains.kotlin.psi.psiUtil.allChildren
import org.jetbrains.kotlin.psi.psiUtil.getCallNameExpression

class SimplifyConstructor(private val file: KtFile, private val checker: CompilerTestChecker) {

    //TODO handle lambdas
    fun transform() {
        file.getAllPSIChildrenOfType<KtClass>()
                .filter { it.name != null && it.primaryConstructor != null }
                //Filter constructors with lambdas
                .filter { it.primaryConstructor!!.getAllPSIChildrenOfType<KtFunctionType>().isEmpty() }
                .forEach { ktClass ->
                    //Get all invocations
                    val invocations: MutableList<KtCallElement> = file.getAllPSIChildrenOfType<KtCallExpression>()
                            .asSequence()
                            .filter { call -> call.getCallNameExpression() != null }
                            .filter { call -> call.getCallNameExpression()!!.textMatches(ktClass.name!!) }
                            .filter { call ->
                                call.valueArguments.size == ktClass.primaryConstructorParameters.size
                                        && ktClass.primaryConstructorParameters.isNotEmpty()
                            }
                            .toMutableList()
                    val callees = file.getAllPSIChildrenOfType<KtSuperTypeCallEntry>()
                            .filter { call -> call.getCallNameExpression() != null }
                            .filter { call -> call.getCallNameExpression()!!.textMatches(ktClass.name!!) }
                            .filter { call ->
                                call.valueArguments.size == ktClass.primaryConstructorParameters.size
                                        && ktClass.primaryConstructorParameters.isNotEmpty()
                            }
                    callees.forEach { invocations.add(it) }
                    var primaryConstructor: List<PsiElement>
                    var valueParameters = ktClass.primaryConstructorParameters
                    if (valueParameters.isEmpty()) return@forEach
                    var i = 0
                    while (i < valueParameters.size - 1) {
                        primaryConstructor = ktClass.primaryConstructor?.allChildren?.first { it is KtParameterList }?.allChildren?.toList()
                                ?: return@forEach
                        valueParameters = ktClass.primaryConstructorParameters
                        if (valueParameters.size <= 1) return@forEach

                        val v = valueParameters[i]
                        val next = valueParameters[i + 1]
                        var fl = false
                        val oldCopy = ktClass.primaryConstructor!!.copy() as KtPrimaryConstructor
                        primaryConstructor.forEach { element ->
                            if (element == v)
                                fl = true
                            if (element == next)
                                fl = false
                            if (fl) {
                                file.node.removeChild(element.node)
                            }
                        }
                        //Remove from invocations
                        val oldArgsCopies = mutableListOf<KtValueArgument>()
                        invocations.forEach {
                            oldArgsCopies.add(it.valueArgumentList!!.arguments[i])
                            it.valueArgumentList?.removeArgument(i)
                        }
                        if (!checker.checkTest(file.text)) {
                            ktClass.primaryConstructor!!.replaceThis(oldCopy)
                            for (j in 0 until invocations.size) {
                                val newArg = KtPsiFactory(file.project).createArgument(oldArgsCopies[j].text)
                                val invoke = invocations[j]
                                invoke.valueArgumentList!!.addArgumentBefore(newArg, invoke.valueArgumentList!!.arguments[i])
                            }
                            valueParameters = oldCopy.valueParameters
                            ++i
                        } else {
                            valueParameters = ktClass.primaryConstructorParameters
                        }
                    }
                    //Process last element
                    primaryConstructor = ktClass.primaryConstructor?.allChildren?.first?.allChildren?.toList()!!
                    val lastParam = ktClass.primaryConstructorParameters.last()
                    val lastArgs = invocations.map { it.valueArguments.last() }
                    val constructorCopy = ktClass.primaryConstructor!!.copy() as KtPrimaryConstructor
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
                        ktClass.primaryConstructor?.replaceThis(constructorCopy)
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
