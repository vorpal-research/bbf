package com.stepanov.reduktor.passes

import com.stepanov.reduktor.executor.CompilerTestChecker
import com.stepanov.reduktor.util.getAllPSIChildrenOfType
import com.stepanov.reduktor.util.replaceThis
import org.apache.log4j.Logger
import org.jetbrains.kotlin.lexer.KtTokens
import org.jetbrains.kotlin.psi.*
import org.jetbrains.kotlin.psi.psiUtil.allChildren


class SimplifyFor(private val file: KtFile, private val checker: CompilerTestChecker) {

    fun transform() {
        val forExpressions = file.getAllPSIChildrenOfType<KtForExpression>()
        for (f in forExpressions) {
            if (f.loopParameter == null || f.loopRange == null || f.body == null) continue
            val oldFor = f.copy() as KtForExpression
            val newProp = try {
                if (f.destructuringDeclaration != null) {
                    psiFactory.createDestructuringDeclaration("val ${f.loopParameter!!.text} = (${f.loopRange!!.text}).iterator().next()")
                } else {
                    psiFactory.createProperty("val ${f.loopParameter!!.text} = (${f.loopRange!!.text}).iterator().next()")
                }
            } catch (e: Exception) {
                continue
            }
            val body = f.body?.copy()
            //Remove lbrace and rbrace from body
            if (body?.allChildren?.first?.node?.elementType == KtTokens.LBRACE)
                body?.node?.removeChild(body.allChildren.first!!.node)
            if (body?.allChildren?.last?.node?.elementType == KtTokens.RBRACE)
                body?.node?.removeChild(body.allChildren.last!!.node)
            val newBlock = KtPsiFactory(file.project).createBlock("${newProp.text}\n${body!!.text}")
            newBlock.lBrace?.delete()
            newBlock.rBrace?.delete()
            f.replaceThis(newBlock)
            if (!checker.checkTest(file.text))
                newBlock.replaceThis(oldFor)
            else
                log.debug("SUCCESSFUL FOR SIMPLIFYING")
        }
    }

    private val log = Logger.getLogger("transformationManagerLog")
    private val psiFactory = KtPsiFactory(file.project)

}