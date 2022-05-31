package com.stepanov.reduktor.passes

import com.intellij.lang.ASTNode
import com.intellij.lang.FileASTNode
import com.intellij.psi.PsiWhiteSpace
import com.stepanov.reduktor.executor.CompilerTestChecker
import com.stepanov.reduktor.util.*
import org.apache.log4j.Logger

class HierarchicalDeltaDebugger(private val tree: FileASTNode, private val checker: CompilerTestChecker) {

    fun hdd(maxLevel: Int = Int.MAX_VALUE) {
        log.debug("Starting to reduce ${tree.text}")
        var nodes = tree.getAllChildrenOfCurLevel().toList()
        while (nodes.isNotEmpty() || level > maxLevel) {
            log.debug("Cur level is $level \n")
            val minconfig = ddmin(nodes.toList())
            log.debug("MINCONFIG = ${minconfig.map { it }}")
            log.debug("VERIFY BEFORE LEVEL $level = ${checker.checkTest(tree.text)}")
            deleteNodes(tree, minconfig, level)
            log.debug("VERIFY LEVEL $level = ${checker.checkTest(tree.text)}")
            ++level
            nodes = tree.getAllChildrenOfTheLevel(level)
            log.debug("RES after level $level: ${tree.text}")
        }
        log.debug("Result: ${tree.text}")
    }

    private fun deleteNodes(tree: FileASTNode, minconf: List<ASTNode>, level: Int): FileASTNode {
        val child = tree.getAllChildrenOfTheLevel(level)
        child
                .filter { !minconf.contains(it) && it !is PsiWhiteSpace }
                .forEach { checker.removeNodeIfPossible(tree, it); log.debug("Deleting $it") }
        return tree
    }

    private fun deleteNodes(tree: FileASTNode, minconf: List<ASTNode>, level: Int, nodes: List<ASTNode>): FileASTNode {
        val child = tree.getAllChildrenOfTheLevel(level)
        child
                .filter { !minconf.contains(it) && it !is PsiWhiteSpace && containsAstNodeText(nodes, it) }
                .forEach { checker.removeNodeIfPossible(tree, it); log.debug("Deleting $it") }
        return tree
    }

    private fun containsAstNodeText(list: List<ASTNode>, el: ASTNode): Boolean =
            list.any { it.startOffset == el.startOffset && it.elementType == el.elementType && it.text == el.text }

    private fun getCopyWithDeletingNodes(matchingNodes: Boolean, minconf: List<ASTNode>, nodes: List<ASTNode>): FileASTNode {
        val copyTree = tree.copyElement() as FileASTNode
        val child = copyTree.getAllChildrenOfTheLevel(level)
        if (matchingNodes) {
            child
                    .filterNot { containsAstNodeText(minconf, it) || it is PsiWhiteSpace || !containsAstNodeText(nodes, it) }
                    .forEach { copyTree.removeChild(it) }
        } else {
            child
                    .filterNot { !containsAstNodeText(minconf, it) || it is PsiWhiteSpace || !containsAstNodeText(nodes, it) }
                    .forEach { copyTree.removeChild(it) }
        }
        return copyTree
    }


    private fun getSublist(tree: List<ASTNode>, n: Int): ArrayList<List<ASTNode>> {
        val subList: ArrayList<List<ASTNode>> = arrayListOf()
        val step = tree.size / n
        if (step < 2) return tree.indices.mapTo(subList) { listOf(tree[it]) }
        var cur = 0
        for (i in 0 until n) {
            if (i == tree.size)
                break
            if (i == n - 1)
                subList.add(tree.slice(cur until tree.size))
            else
                subList.add(tree.slice(cur until cur + step))
            cur += step
        }
        return subList
    }

    private fun getCompleteness(subList: ArrayList<List<ASTNode>>): ArrayList<List<ASTNode>> {
        val completeness: ArrayList<List<ASTNode>> = arrayListOf()
        for (i in 0 until subList.size) {
            val comp = subList.getAllWithout(i)
            completeness.add(comp.flatten())
        }
        return completeness
    }

    private fun ddmin_(tree: List<ASTNode>, n: Int): List<ASTNode> {
        // Dividing
        var step = tree.size / n
        if (step == 0) ++step
        val subList = getSublist(tree, n)
        //Try to check subset
        for (sub in subList) {
            if (checker.checkTest(getCopyWithDeletingNodes(true, sub, tree).text)) {
                return if (tree.size == 1)
                    tree
                else
                    ddmin_(sub, 2)
            }
        }
        //Try to check completeness of subsets
        if (n != 2) {
            val completeness = getCompleteness(subList)
            for (com in completeness) {
                if (checker.checkTest(getCopyWithDeletingNodes(true, com, tree).text)) {
                    return ddmin_(com, maxOf(n - 1, 2))
                }
            }
        }
        //Increase the granularity
        if (step != 1)
            return ddmin_(tree, minOf(2 * n, tree.size))
        return tree
    }

    private fun ddmin(tree: List<ASTNode>): List<ASTNode> {
        return ddmin_(tree, 2)
    }

    var level = 1

    private val log = Logger.getLogger("reducerLogger")
}