@file:Suppress(Warnings.DEPRECATION, "OverridingDeprecatedMember")

package org.jetbrains.kootstrap.idea

import com.intellij.lang.ASTNode
import com.intellij.openapi.editor.Document
import com.intellij.openapi.fileTypes.FileType
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.Computable
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.codeStyle.ChangedRangesInfo
import com.intellij.psi.codeStyle.CodeStyleManager
import com.intellij.psi.codeStyle.Indent
import com.intellij.util.IncorrectOperationException
import com.intellij.util.ThrowableRunnable
import kotlinx.Warnings
import org.jetbrains.kootstrap.util.function

class MockCodeStyleManager(private val myProject: Project) : CodeStyleManager() {
    override fun reformatTextWithContext(p0: PsiFile, p1: ChangedRangesInfo) = Unit
    override fun getProject(): Project = myProject

    @Throws(IncorrectOperationException::class)
    override fun reformat(
            element: PsiElement): PsiElement = reformat(element, false)

    @Throws(IncorrectOperationException::class)
    override fun reformat(
            element: PsiElement,
            canChangeWhiteSpacesOnly: Boolean): PsiElement = element

    @Throws(IncorrectOperationException::class)
    override fun reformatRange(
            element: PsiElement,
            startOffset: Int,
            endOffset: Int,
            canChangeWhiteSpacesOnly: Boolean): PsiElement = element

    @Throws(IncorrectOperationException::class)
    override fun reformatRange(
            element: PsiElement,
            startOffset: Int,
            endOffset: Int): PsiElement = element

    @Throws(IncorrectOperationException::class)
    override fun reformatText(
            file: PsiFile,
            startOffset: Int,
            endOffset: Int) {
        reformatText(file, setOf(TextRange(startOffset, endOffset)))
    }

    @Throws(IncorrectOperationException::class)
    override fun reformatText(
            file: PsiFile,
            ranges: Collection<TextRange>) = Unit

    @Throws(IncorrectOperationException::class)
    override fun reformatTextWithContext(
            file: PsiFile,
            ranges: Collection<TextRange>) = Unit

    @Throws(IncorrectOperationException::class)
    override fun reformatNewlyAddedElement(
            parent: ASTNode,
            addedElement: ASTNode) = Unit

    @Throws(IncorrectOperationException::class)
    override fun adjustLineIndent(
            file: PsiFile,
            offset: Int): Int = offset

    override fun adjustLineIndent(
            document: Document,
            offset: Int): Int = offset

    @Throws(IncorrectOperationException::class)
    override fun adjustLineIndent(
            file: PsiFile,
            rangeToAdjust: TextRange) = Unit

    override fun getLineIndent(
            file: PsiFile,
            offset: Int): String? = ""

    override fun getLineIndent(
            document: Document,
            offset: Int): String? = ""

    override fun getIndent(
            text: String,
            fileType: FileType): Indent = MyIndent()

    override fun isLineToBeIndented(
            file: PsiFile,
            offset: Int): Boolean = false

    data class MyIndent(val amount: Int = 0) : Indent {
        override fun isGreaterThan(indent: Indent) = function {
            if (indent is MyIndent) amount > indent.amount
            else false
        }

        override fun min(anotherIndent: Indent) = function {
            if (anotherIndent is MyIndent) MyIndent(Math.min(amount, anotherIndent.amount))
            else null
        }

        override fun max(anotherIndent: Indent) = function {
            if (anotherIndent is MyIndent) MyIndent(Math.max(amount, anotherIndent.amount))
            else null
        }

        override fun add(indent: Indent) = function {
            if (indent is MyIndent) MyIndent(amount + indent.amount)
            else null
        }

        override fun subtract(indent: Indent) = function {
            if (indent is MyIndent) MyIndent(amount - indent.amount)
            else null
        }

        override fun isZero() = amount == 0
    }

    override fun fillIndent(indent: Indent, fileType: FileType) = function {
        if (indent is MyIndent) " ".repeat(indent.amount)
        else ""
    }

    override fun zeroIndent(): Indent = MyIndent()

    override fun isSequentialProcessingAllowed(): Boolean = true

    override fun performActionWithFormatterDisabled(
            r: Runnable) = r.run()

    override fun <T : Throwable> performActionWithFormatterDisabled(
            r: ThrowableRunnable<T>) = r.run()

    override fun <T> performActionWithFormatterDisabled(
            r: Computable<T>): T = r.compute()

}
