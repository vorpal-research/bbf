package com.stepanov.reduktor.passes

import com.stepanov.reduktor.executor.CompilerTestChecker
import com.stepanov.reduktor.util.*
import org.apache.log4j.Logger
import org.jetbrains.kotlin.lexer.KtTokens
import org.jetbrains.kotlin.psi.KtFile
import org.jetbrains.kotlin.psi.KtNamedFunction
import org.jetbrains.kotlin.psi.KtReturnExpression

class ReturnValueToVoid(private val file: KtFile, private val checker: CompilerTestChecker) {
    fun transform() {
        transformFile(file, false)
        transformFile(file, true)
    }

    fun transformFile(file: KtFile, justKeyword: Boolean) {
        val funcs = file.getAllPSIChildrenOfType<KtNamedFunction>().filter { it.hasDeclaredReturnType() }
        for (f in funcs) {
            val oldFun = f.copy() as KtNamedFunction
            f.node.removeChild(f.typeReference!!.node)
            f.node.removeChild(f.colon!!.node)
            if (!justKeyword) {
                f.node.getAllChildrenNodes()
                        .filter { it.psi is KtReturnExpression }
                        .forEach { f.node.removeChild(it) }
            } else {
                f.node.getAllChildrenNodes()
                        .filter { it.psi is KtReturnExpression }
                        .filter { it.findChildByType(KtTokens.RETURN_KEYWORD) != null }
                        .map { it.psi as KtReturnExpression }
                        .forEach { f.node.removeChild(it.returnKeyword.node) }
            }

            if (!checker.checkTest(file.text)) {
                f.replaceThis(oldFun)
                log.debug("REPLACED BACK")
            } else {
                log.debug("SUCCESSFUL DELETING OF RETURN VALUE")
            }
        }
    }

    private val log = Logger.getLogger("transformationManagerLog")
}