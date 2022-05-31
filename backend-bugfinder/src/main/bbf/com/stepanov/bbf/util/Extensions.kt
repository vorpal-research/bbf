package com.stepanov.bbf.util

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.tree.TokenSet
import com.stepanov.reduktor.util.getAllChildrenOfCurLevel
import org.jetbrains.kotlin.lexer.KtTokens
import org.jetbrains.kotlin.psi.psiUtil.allChildren
import ru.spbstu.kotlin.generate.util.asCharSequence
import ru.spbstu.kotlin.generate.util.nextString
import java.util.*

fun ASTNode.getAllChildrenNodes(): ArrayList<ASTNode> {
    val result = ArrayList<ASTNode>()
    var level = 1
    var childrens = this.getAllChildrenOfCurLevel()
    while (childrens.isNotEmpty()) {
        childrens.forEach { result.add(it) }
        ++level
        childrens = this.getAllChildrenOfTheLevel(level).toTypedArray()
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


fun List<ASTNode>.getAllChildren(): List<ASTNode> {
    if (this.isEmpty()) return listOf()
    val res = arrayListOf<ASTNode>()
    for (node in this) {
        node.getAllChildrenOfCurLevel().forEach { res.add(it) }
    }
    return res
}

fun ASTNode.getAllChildrenOfTheLevel(level: Int): List<ASTNode> {
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
fun ASTNode.getAllDFSChildren(): List<ASTNode> {
    val res = mutableListOf(this)
    for (child in this.getChildren(TokenSet.ANY)) {
        child.getAllDFSChildren().forEach { res.add(it) }
    }
    return res
}

inline fun <reified T : PsiElement> PsiElement.getAllPSIChildrenOfType(): List<T> =
        this.node.getAllChildrenNodes().asSequence().filter { it.psi is T }.map { it.psi as T }.toList()

inline fun <reified T : PsiElement> PsiElement.getAllPSIDFSChildrenOfType(): List<T> =
        this.node.getAllDFSChildren().asSequence().filter { it.psi is T }.map { it.psi as T }.toList()


fun PsiElement.isBlockExpr() = this.allChildren.first?.node?.elementType == KtTokens.LBRACE &&
        this.allChildren.last?.node?.elementType == KtTokens.RBRACE

fun getRandomBoolean(n: Int = 1): Boolean {
    var res = true
    repeat(n) { res = res && Random().nextBoolean() }
    return res
}

fun getTrueWithProbability(probability: Int): Boolean = Random().nextInt(100) in 0..probability

fun Random.getRandomVariableName(length: Int): String =
        this.nextString(('a'..'z').asCharSequence(), length, length + 1)
