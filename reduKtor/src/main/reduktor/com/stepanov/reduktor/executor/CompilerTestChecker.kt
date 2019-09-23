package com.stepanov.reduktor.executor

import com.intellij.lang.ASTNode
import com.intellij.lang.FileASTNode
import com.intellij.psi.PsiElement
import com.stepanov.reduktor.executor.error.Error
import org.jetbrains.kotlin.psi.KtFile
import org.jetbrains.kotlin.psi.KtPsiFactory

interface CompilerTestChecker {

    fun removeNodeIfPossible(file: KtFile, node: ASTNode): Boolean
    fun removeNodeIfPossible(file: FileASTNode, node: ASTNode)
    fun removeNodesIfPossible(file: KtFile, nodes: List<ASTNode>): Boolean
    fun replaceNodeIfPossible(file: KtFile, node: ASTNode, replacement: ASTNode): Boolean
    fun replaceNodeIfPossible(file: KtFile, node: PsiElement, replacement: PsiElement) =
            replaceNodeIfPossible(file, node.node, replacement.node)
    fun replaceNodeOnItChild(file: KtFile, node: ASTNode, replacement: ASTNode): ASTNode? = node

    fun checkTest(text: String): Boolean
    fun checkTest(text: String, pathToFile: String): Boolean
    fun checkTest(tree: List<ASTNode>): Boolean

    fun getErrorInfo(): Error
    fun getErrorMessage(): String

    fun init(compilingPath: String, psiFactory: KtPsiFactory? = null): Error
    fun reinit(): Error

    fun refreshAlreadyCheckedConfigurations() {
        alreadyChecked.clear()
    }

    var pathToFile: String
    var alreadyChecked: HashMap<Int, Boolean>
}