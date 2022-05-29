package com.stepanov.reduktor.passes

import com.stepanov.reduktor.executor.CompilerTestChecker
import com.stepanov.reduktor.util.*
import org.jetbrains.kotlin.lexer.KtTokens
import org.jetbrains.kotlin.psi.KtBlockExpression
import org.jetbrains.kotlin.psi.KtFile
import org.jetbrains.kotlin.psi.KtPsiFactory
import org.jetbrains.kotlin.psi.KtTryExpression

class TryCatchDeleter(private val file: KtFile, private val checker: CompilerTestChecker) {

    fun transform() {
        file.beforeAstChange()
        val tryExpressions = file.getAllPSIChildrenOfType<KtTryExpression>()
        for (t in tryExpressions) {
            if (t.node.getAllChildrenNodes().all { it.elementType != KtTokens.TRY_KEYWORD }) continue
            val oldBlock = KtPsiFactory(file.project).createFunction("fun foo() ${t.tryBlock.text}").bodyExpression as KtBlockExpression
            val tryBackup = t.copy()
            val block = t.tryBlock
            if (block.lBrace != null) {
                //Delete braces
                block.deleteChildInternal(block.lBrace!!.node)
                block.deleteChildInternal(block.rBrace!!.node)
            }
            t.replaceThis(block)
            if (!checker.checkTest(file.text, file.name)) {
                block.replaceThis(tryBackup)
            }
//            //Try to replace
//            val backup = checker.replaceNodeOnItChild(file, t.node, block.node) as? KtTryExpression?
//            if (backup != null) {
//                //val afterTryNode = backup.allChildren.toList()[1].node
//                //backup.node.addChild(oldBlock.node, afterTryNode)
//            }
        }
    }

}