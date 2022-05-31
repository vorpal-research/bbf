package com.stepanov.reduktor.util

import com.intellij.lang.ASTNode
import com.intellij.lang.FileASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiWhiteSpace
import com.intellij.psi.tree.TokenSet
import com.stepanov.reduktor.executor.CompilerTestChecker
import org.jetbrains.kotlin.KtNodeTypes
import org.jetbrains.kotlin.psi.*
import org.jetbrains.kotlin.psi.psiUtil.findDescendantOfType

//TEMPORARY SOLUTION
private var visited: ArrayList<ASTNode> = ArrayList()
private var curIndex = 0
private var search: ASTNode? = null

fun KtFile.getLine(line: Int): ASTNode? {
    if (line == 1) {
        search = this.node.firstChildNode
        val whitespace = this.findDescendantOfType<PsiWhiteSpace> { it.textContains('\n') }
        search = whitespace?.prevSibling?.node
        return search
    }
    visited = arrayListOf()
    curIndex = -1
    search = null
    getLine(line - 2, this.node)
    return search
}

private fun getLine(line: Int, node: ASTNode) {
    if (visited.contains(node))
        return
    visited.add(node)
    if (curIndex == line && search == null) {
        search = node.treeNext
    }
    for (ch in node.getAllChildrenOfCurLevel()) {
        if (ch is PsiWhiteSpace && ch.textContains('\n')) {
            curIndex += ch.node.text.count { it == '\n' }
        }
        getLine(line, ch)
    }
}

fun ASTNode.getAllChildrenOfCurLevel(): Array<ASTNode> = this.getChildren(TokenSet.ANY)
fun ASTNode.getAllChildrenNodes(): ArrayList<ASTNode> {
    val result = ArrayList<ASTNode>()
    var level = 1
    var children = this.getAllChildrenOfCurLevel()
    while (children.isNotEmpty()) {
        children.forEach { result.add(it) }
        ++level
        children = this.getAllChildrenOfTheLevel(level).toTypedArray()
    }
    return result
}

fun ASTNode.getAllParents(): ArrayList<ASTNode> {
    val result = arrayListOf<ASTNode>()
    var node = this
    while (true) {
        result.add(node)
        if (node.treeParent == null)
            break
        node = node.treeParent
    }
    return result
}

fun ASTNode.getAllParentsWithoutNode(): ArrayList<ASTNode> {
    val result = arrayListOf<ASTNode>()
    var node = this.treeParent ?: return arrayListOf()
    while (true) {
        result.add(node)
        if (node.treeParent == null)
            break
        node = node.treeParent
    }
    return result
}


fun <T> Iterable<T>.getAllWithout(index: Int): List<T> {
    val list: ArrayList<T> = arrayListOf()
    for ((count, item) in this.withIndex()) {
        if (count != index) list.add(item)
    }
    return list
}

fun List<com.intellij.lang.ASTNode>.getAllChildren(): List<com.intellij.lang.ASTNode> {
    if (this.isEmpty()) return listOf()
    val res = arrayListOf<com.intellij.lang.ASTNode>()
    for (node in this) {
        node.getAllChildrenOfCurLevel().forEach { res.add(it) }
    }
    return res
}

fun FileASTNode.getAllChildrenOfTheLevel(level: Int): List<com.intellij.lang.ASTNode> {
    var res = this.getAllChildrenOfCurLevel().toList()
    for (i in 1 until level)
        res = res.getAllChildren()
    return res
}

fun com.intellij.lang.ASTNode.getAllChildrenOfTheLevel(level: Int): List<com.intellij.lang.ASTNode> {
    var res = this.getAllChildrenOfCurLevel().toList()
    for (i in 1 until level)
        res = res.getAllChildren()
    return res
}

fun PsiElement.replaceThis(replacement: PsiElement) {
    for (p in this.node.getAllParentsWithoutNode()) {
        try {
            p.replaceChild(this.node, replacement.node)
            return
        } catch (_: AssertionError) {
        }
    }
}

fun ASTNode.replaceThis(replacement: ASTNode) = this.psi.replaceThis(replacement.psi)


fun KtNamedFunction.getSignature(): String {
    val sign = StringBuilder()
    sign.append(this.name + "(")
    for (p in this.valueParameters.getAllWithout(this.valueParameters.size - 1)) {
        sign.append(p.typeReference?.text + ", ")
    }
    this.valueParameters.lastOrNull()?.let {
        sign.append(it.typeReference?.text)
    }
    sign.append(")")
    return sign.toString()
}

fun getClassWithName(projectFiles: List<KtFile>, name: String): KtClass? {
    for (f in projectFiles) {
        f.node.getAllChildrenNodes()
                .filter { it.elementType == KtNodeTypes.CLASS }
                .map { it.psi as KtClass }
                .find { it.fqName?.asString() == name }
                ?.let { return it }
    }
    return null
}

fun KtNamedFunction.initBodyByTODO(psiFactory: KtPsiFactory) {
    if (!this.hasBody()) {
        return
    } else if (this.hasBlockBody()) {
        if (this.typeReference == null)
            replaceReturnValueTypeOnUnit(psiFactory)
        val eq = psiFactory.createEQ()
        val space = psiFactory.createWhiteSpace(" ")
        val todo = psiFactory.createExpression("TODO()")
        this.node.removeChild(this.bodyExpression!!.node)
        this.add(eq)
        this.add(space)
        this.add(todo)
    } else {
        val todo = psiFactory.createExpression("TODO()")
        this.bodyExpression!!.replaceThis(todo)
    }
}

fun KtProperty.initByTODO(psiFactory: KtPsiFactory) {
    val todo = psiFactory.createExpression("TODO()")
    val anyType = psiFactory.createType("Any")
    this.initializer = todo
    if (this.typeReference == null)
        this.typeReference = anyType
}

fun KtNamedFunction.replaceReturnValueTypeOnAny(psiFactory: KtPsiFactory) {
    val anyType = psiFactory.createType("Any")
    this.typeReference = anyType
}

fun KtNamedFunction.replaceReturnValueTypeOnUnit(psiFactory: KtPsiFactory) {
    val anyType = psiFactory.createType("Unit")
    this.typeReference = anyType
}

inline fun <reified T : PsiElement> PsiElement.getAllPSIChildrenOfType(): List<T> =
        this.node.getAllChildrenNodes().filter { it.psi is T }.map { it.psi as T }

fun PsiElement.checkAndReplaceBackIfError(checker: CompilerTestChecker, file: KtFile, oldCopy: PsiElement): Boolean {
    if (!checker.checkTest(file.text, file.name)) {
        this.replaceThis(oldCopy)
        return false
    }
    return true
}
