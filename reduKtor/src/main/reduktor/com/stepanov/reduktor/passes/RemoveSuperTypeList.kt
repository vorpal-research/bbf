package com.stepanov.reduktor.passes

import com.stepanov.reduktor.executor.CompilerTestChecker
import com.stepanov.reduktor.util.*
import org.jetbrains.kotlin.lexer.KtTokens
import org.jetbrains.kotlin.psi.KtClass
import org.jetbrains.kotlin.psi.KtFile
import org.jetbrains.kotlin.psi.KtNamedFunction
import org.jetbrains.kotlin.psi.KtPsiFactory

class RemoveSuperTypeList(private val file: KtFile, private val checker: CompilerTestChecker) {
    fun transform() {
        //file.getAllPSIChildrenOfType<KtClass>().map { tryToRemove(it) }
    }

    private fun tryToRemove(c: KtClass) {
        val oldClass = c.copy() as KtClass
        c.superTypeListEntries.map { c.removeSuperTypeListEntry(it) }
        c.getProperties().forEach { it.removeModifier(KtTokens.OVERRIDE_KEYWORD) }
        c.getAllPSIChildrenOfType<KtNamedFunction>().forEach {
            it.removeModifier(KtTokens.OVERRIDE_KEYWORD)
            if (it.typeReference == null && it.text.contains("TODO()"))
                it.replaceReturnValueTypeOnAny(KtPsiFactory(file.project))
        }
        //TODO if nothing changed dont check
        if (!checker.checkTest(file.text))
            c.replaceThis(oldClass)
    }
}