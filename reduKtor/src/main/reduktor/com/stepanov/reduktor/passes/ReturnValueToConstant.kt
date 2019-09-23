package com.stepanov.reduktor.passes

import com.stepanov.reduktor.executor.CompilerTestChecker
import com.stepanov.reduktor.util.getAllChildrenNodes
import com.stepanov.reduktor.util.getAllPSIChildrenOfType
import org.jetbrains.kotlin.KtNodeTypes
import org.jetbrains.kotlin.psi.KtFile
import org.jetbrains.kotlin.psi.KtNamedFunction
import org.jetbrains.kotlin.psi.KtPsiFactory
import org.jetbrains.kotlin.psi.KtReturnExpression

class ReturnValueToConstant(private val file: KtFile, private val checker: CompilerTestChecker) {

    fun transform() {
        val functions = file.getAllPSIChildrenOfType<KtNamedFunction>()
        for (f in functions) {
            if (typeConstants.containsKey(f.typeReference?.text)) {
                val returns = f.node.getAllChildrenNodes()
                        .filter { it.elementType == KtNodeTypes.RETURN }
                        .map { it.psi as KtReturnExpression }
                for (r in returns) {
                    val type = f.typeReference!!.text
                    val replace = KtPsiFactory(file.project).createExpression(typeConstants[type]!!)
                    if (r.returnedExpression != null)
                        checker.replaceNodeIfPossible(file, r.returnedExpression!!.node, replace.node)
                }
            }
        }
    }

    private val typeConstants = mapOf(Pair("Int", "1"), Pair("Double", "0.0"), Pair("String", "\"\""))
}