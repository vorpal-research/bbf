package com.stepanov.bbf.util

import com.intellij.lang.ASTNode
import com.intellij.lang.FileASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiWhiteSpace
import com.intellij.psi.tree.IElementType
import com.intellij.psi.tree.TokenSet
import com.stepanov.reduktor.util.getAllChildrenOfCurLevel
import org.jetbrains.kotlin.KtNodeTypes
import org.jetbrains.kotlin.lexer.KtTokens
import org.jetbrains.kotlin.psi.*
import org.jetbrains.kotlin.psi.psiUtil.allChildren
import ru.spbstu.kotlin.generate.util.asCharSequence
import ru.spbstu.kotlin.generate.util.nextString
import java.io.BufferedReader
import java.io.File
import java.io.FileOutputStream
import java.io.FileReader
import java.nio.file.Files
import java.nio.file.Paths
import java.util.*
import java.util.function.BiPredicate


fun KtProperty.getLeft(): List<PsiElement> =
        if (this.allChildren.toList().any { it.node.elementType.index.toInt() == 179 }) this.allChildren.toList().takeWhile { it.node.elementType.index.toInt() != 179 }
        else listOf()

fun KtProperty.getLeftIdentifier(): PsiElement? =
        this.allChildren.toList().first { it.node.elementType.index.toInt() == 141 }

fun KtProperty.getRight(): List<PsiElement> =
        if (this.allChildren.toList().any { it.node.elementType.index.toInt() == 179 }) this.allChildren.toList().takeLastWhile { it.node.elementType.index.toInt() != 179 }
        else listOf()


fun ASTNode.getAllChildrenOfCurLevel(): Array<ASTNode> = this.getChildren(TokenSet.ANY)
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
    var node = this.treeParent ?: return arrayListOf<ASTNode>()
    while (true) {
        result.add(node)
        if (node.treeParent == null)
            break
        node = node.treeParent
    }
    return result
}


fun <T> Iterable<T>.getAllWithout(index: Int): List<T> {
    val list: ArrayList<T> = arrayListOf<T>()
    var count = 0
    for (item in this) {
        if (count++ != index) list.add(item)
    }
    return list
}

fun <T> Iterable<T>.getAllWithoutLast(index: Int): List<T> {
    val list: ArrayList<T> = arrayListOf<T>()
    var count = 0
    for (item in this) {
        if (count++ != index) list.add(item)
    }
    return list
}

fun <ASTNode> List<ASTNode>.filterRowPsiWhiteSpaces(): List<ASTNode> {
    if (this.isEmpty()) return listOf()
    val res = arrayListOf<ASTNode>()
    res.add(this[0])
    for (i in 1 until this.size) {
        if (!(this[i] is PsiWhiteSpace && this[i - 1] is PsiWhiteSpace))
            res.add(this[i])
    }
    return res
}

fun List<com.intellij.lang.ASTNode>.getAllChildren(): List<com.intellij.lang.ASTNode> {
    if (this.isEmpty()) return listOf()
    val res = arrayListOf<com.intellij.lang.ASTNode>()
    for (node in this) {
        node.getAllChildrenOfCurLevel().forEach { res.add(it) }
    }
    return res
}

fun List<com.intellij.lang.ASTNode>.getAllChildrenOfTheLevel(level: Int): List<com.intellij.lang.ASTNode> {
    if (this.isEmpty())
        return listOf()
    var res = this
    for (i in 1 until level)
        res = res.getAllChildren()
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

fun <T> Iterable<T>.filterWithNext(predicate: (T, T) -> Boolean): List<T> {
    val dest = ArrayList<T>()
    for (i in 0 until this.count() - 1) {
        if (!predicate(this.elementAt(i), this.elementAt(i + 1)))
            dest.add(this.elementAt(i))
    }
    return dest
}

fun PsiElement.replaceChild(replacing: PsiElement, replacement: PsiElement) {
    replacing.replaceThis(replacement)
}

fun PsiElement.replaceThis(replacement: PsiElement) {
    for (p in this.node.getAllParentsWithoutNode()) {
        try {
            p.replaceChild(this.node, replacement.node)
            return
        } catch (e: AssertionError) {
        }
    }
}

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

fun KtProperty.initByTODOWithAnyType(psiFactory: KtPsiFactory) {
    val todo = psiFactory.createExpression("TODO()")
    val anyType = psiFactory.createType("Any")
    this.initializer = todo
    this.typeReference = anyType
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


fun ASTNode.getAllChildrenOfType(type: IElementType): List<ASTNode> =
        this.getAllChildrenNodes().filter { it.elementType == type }

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


fun PsiElement.debugPrint() {
    println("---BEGIN PSI STRUCTURE---")
    debugPrint(0)
    println("---END PSI STRUCTURE---")
}

fun PsiElement.debugPrint(indentation: Int) {
    println("|".repeat(indentation) + toString())
    for (child in children)
        child.debugPrint(indentation + 1)
    if (children.isEmpty())
        println("|".repeat(indentation + 1) + "'$text'")
}

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

fun String.isSubstringOf(other: String): Boolean {
    val m = this.length
    val n = other.length

    for (i in 0..n - m) {
        var j = 0
        while (j < m) {
            if (other[i + j] != this[j]) {
                break
            }
            j++
        }
        if (j == m)
            return true
    }
    return false
}

fun removeMainFromFiles(dir: String) {
    val files = mutableListOf<File>()
    Files.find(Paths.get(dir), Int.MAX_VALUE, BiPredicate { t, u -> u.isRegularFile })
            .forEach { files.add(it.toFile()) }
    files.forEach {
        if (!it.name.contains("mutated"))
            return@forEach
        var text = BufferedReader(FileReader(it)).readText()
        text = text.removeSuffix("fun main(args: Array<String>) {\n" +
                "    println(box())\n" +
                "}")
        val fooStream = FileOutputStream(it, false)
        fooStream.write(text.toByteArray())
        fooStream.close()
    }
}