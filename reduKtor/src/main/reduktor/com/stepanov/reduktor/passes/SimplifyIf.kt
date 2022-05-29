package com.stepanov.reduktor.passes

import com.intellij.psi.PsiElement
import com.stepanov.reduktor.executor.CompilerTestChecker
import com.stepanov.reduktor.util.*
import org.apache.log4j.Logger
import org.jetbrains.kotlin.psi.*
import org.jetbrains.kotlin.psi.psiUtil.allChildren

class SimplifyIf(private val file: KtFile, private val checker: CompilerTestChecker) {

    fun transform() {
        val ifExpressions = file.getAllPSIChildrenOfType<KtIfExpression>()
        for (ifExp in ifExpressions) {
            //Try to replace if on it condition if condition is BinaryExpression
            if (ifExp.condition is KtBinaryExpression) {
                val cond = ifExp.condition as KtBinaryExpression
                if (cond.children.size >= 3) {
                    var res: PsiElement? = null
                    if (cond.operationReference.prevSibling != null) {
                        res = checker.replaceNodeOnItChild(file, ifExp.node, cond.left!!.node)?.psi
                        if (res == null) continue
                    }
                    val binRes = res as? KtBinaryExpression
                    if (binRes != null && binRes.operationReference.nextSibling != null) {
                        if (checker.replaceNodeOnItChild(file, binRes.node, binRes.right!!.node) == null) continue
                    }
                }
            }

            //Try to replace if condition is BinaryExpression on left or right side
            if (ifExp.condition is KtBinaryExpression) {
                val cond = ifExp.condition as KtBinaryExpression
                if (cond.children.size >= 3) {
                    var res: PsiElement? = null
                    if (cond.operationReference.prevSibling != null) {
                        res = checker.replaceNodeOnItChild(file, cond.node, cond.left!!.node)?.psi
                        if (res == null) continue
                    }
                    val binRes = res as? KtBinaryExpression
                    if (binRes != null && binRes.operationReference.nextSibling != null) {
                        if (checker.replaceNodeOnItChild(file, binRes.node, binRes.right!!.node) == null) continue
                    }
                }
            }


            //Try to replace if on then
            ifExp.then?.let { then ->
                val oldIf = ifExp.copy() as KtIfExpression
                //Remove rbrace and lbrace from then
                then.allChildren.first?.replaceThis(psiFactory.createWhiteSpace())
                then.allChildren.last?.replaceThis(psiFactory.createWhiteSpace())
                //Replace node if possible
                ifExp.replaceThis(then)
                if (!checker.checkTest(file.text)) {
                    if (ifExp.condition is KtIsExpression) {
                        val isExp = ifExp.condition as KtIsExpression
                        if (isExp.isNegated) {
                            then.replaceThis(oldIf)
                            return@let
                        }
                        val asExp = psiFactory.createExpression("${isExp.leftHandSide.text} as ${isExp.typeReference?.text}")
                        then.addBefore(asExp, then.firstChild)
                        if (!checker.checkTest(file.text)) {
                            then.replaceThis(oldIf)
                        }
                    } else {
                        if (oldIf.`else` == null) {
                            then.replaceThis(oldIf)
                        } else {
                            val copy = oldIf.copy()
                            val el = oldIf.`else`!!
                            then.replaceThis(el)
                            if (!checker.checkTest(file.text)) {
                                el.replaceThis(copy)
                            }
                        }
                    }
                }
            }
            //Try to replace if condition on constant
            if (ifExp.condition != null) {
                val trueExp = psiFactory.createExpression("true")
                val falseExp = psiFactory.createExpression("false")
                if (!checker.replaceNodeIfPossible(file, ifExp.condition!!.node, trueExp.node))
                    checker.replaceNodeIfPossible(file, ifExp.condition!!.node, falseExp.node)
            }
        }
    }

    private val psiFactory = KtPsiFactory(file.project)
    private val log = Logger.getLogger("transformationManagerLog")

}