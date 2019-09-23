package com.stepanov.reduktor.passes

import com.stepanov.reduktor.executor.CompilerTestChecker
import com.stepanov.reduktor.util.*
import org.apache.log4j.Logger
import org.jetbrains.kotlin.KtNodeTypes
import org.jetbrains.kotlin.lexer.KtTokens
import org.jetbrains.kotlin.psi.*
import org.jetbrains.kotlin.psi.psiUtil.allChildren
import org.jetbrains.kotlin.psi.psiUtil.parents
import java.util.*

class SimplifyWhen(private val file: KtFile, private val checker: CompilerTestChecker) {
    fun transform() {
        val whenExpressions = file.getAllPSIChildrenOfType<KtWhenExpression>()
        for (whenExp in whenExpressions) {
            val depth = whenExp.node.getAllParentsWithoutNode().count { it.elementType == KtNodeTypes.WHEN }
            if (whenToDepth.containsKey(depth))
                whenToDepth[depth]?.add(whenExp)
            else
                whenToDepth.put(depth, arrayListOf(whenExp))
        }
        for (listOfWhenExp in whenToDepth.values) {
            for (whenExp in listOfWhenExp) {
                if (whenExp.entries.size > 1) {
                    whenExp.entries[0].expression?.let { replaceWhen(whenExp, it) }
                }
                whenExp.elseExpression?.let { replaceWhen(whenExp, it) }
            }
        }
    }

    private fun replaceWhen(whenExp: KtWhenExpression, exp: KtExpression) {
        val oldWhen = whenExp.copy()
        exp.allChildren
                .filter { it.node.elementType == KtTokens.LBRACE || it.node.elementType == KtTokens.RBRACE }
                .forEach { pt -> exp.node.removeChild(pt.node) }
        if (exp.node.elementType == KtNodeTypes.BLOCK && whenExp.parents.any { it is KtProperty }) {
            val runExpression = KtPsiFactory(file.project).createExpression("run { ${exp.text}\n}")
            whenExp.replaceThis(runExpression)
            if (!checker.checkTest(file.text)) {
                runExpression.replaceThis(oldWhen)
            } else {
                log.debug("Successful when simplifying")
            }
        } else {
            whenExp.replaceThis(exp)
            if (!checker.checkTest(file.text)) {
                exp.replaceThis(oldWhen)
            } else {
                log.debug("Successful when simplifying")
            }
        }

    }

    private val whenToDepth = TreeMap<Int, ArrayList<KtWhenExpression>>(compareByDescending { it })
    private val log = Logger.getLogger("transformationManagerLog")

}