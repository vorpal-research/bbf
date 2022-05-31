package com.stepanov.reduktor.passes

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiWhiteSpace
import com.stepanov.reduktor.executor.CompilerTestChecker
import com.stepanov.reduktor.util.*
import org.jetbrains.kotlin.psi.KtFile
import org.jetbrains.kotlin.psi.psiUtil.children
import java.util.*
import kotlin.Comparator

class PSIReducer(private val file: KtFile, private val checker: CompilerTestChecker) {

    val fileNode = file.node
    val children = fileNode.getAllChildrenNodes()
    val tokensNum = children.size + fileNode.getAllChildrenOfCurLevel().size
    val tokens = mutableMapOf<ASTNode, Pair<Int, Int>>(fileNode to Pair(tokensNum, tokensNum))
    val tokensWithParentBFSOrder = mutableMapOf<ASTNode, Triple<Int, Int, Int>>()

    private fun fillMap() {
        var level = 0
        var counter = tokensNum
        var children = fileNode.getAllChildrenOfTheLevel(level)
        while (children.isNotEmpty()) {
//            println("level = $level children = $children")
            level++
            children
                    .asReversed()
                    .forEach { tokens[it] = it.getAllChildrenNodes().size to counter; counter--; /*println("c = $counter")*/ }
            children = fileNode.getAllChildrenOfTheLevel(level)

        }
    }


    fun transform() {
        fillMap()
        for (token in tokens) {
            //println("tok = ${token.key} val = ${token.value} parent = ${token.key.treeParent} contains = ${tokens.containsKey(token.key.treeParent)}")
            if (token.key.getAllParentsWithoutNode().size == 0)
                tokensWithParentBFSOrder[token.key] = Triple(token.value.first, Integer.MAX_VALUE, token.value.second)
            else
                tokensWithParentBFSOrder[token.key] = Triple(token.value.first, tokens[token.key.treeParent]!!.second, token.value.second)

        }
        startReduce(fileNode)
    }

    private fun startReduce(firstNode: ASTNode) {
        val queue = PriorityQueue(QueueComparator())
        firstNode.children().forEach { queue.offer(it to tokensWithParentBFSOrder[it]!!) }
        var nodeForHandle = queue.poll().first
        while (queue.isNotEmpty()) {
            handleNode(nodeForHandle, queue)
            nodeForHandle = queue.poll().first
        }
    }

    private fun handleNode(node: ASTNode, queue: PriorityQueue<Pair<ASTNode, Triple<Int, Int, Int>>>) {
        if (node.psi is PsiWhiteSpace) return
        //println("node = ${node.psi} ${node.text}")
        //FIRST IF EXPRESSION TRY TO REPLACE ON ANOTHER EXPRESSION
        //TODO Try in reversed order from the smallest node
        //TODO we cant try to replace on each expression
//        if (node.psi is KtExpression) {
//            val replacingCandidates = node.psi.getAllPSIChildrenOfType<KtExpression>().map { it.node }
//            //Trying to replace
//            for (candidate in replacingCandidates) {
//                val res = checker.replaceNodeIfPossible(file, node, candidate)
//                print("Trying to replace ${node.psi} on ${candidate.psi} $res")
//                if (res) {
//                    queue.addFromMapToQueue(candidate)
//                }
//            }
//        }
        //ELSE TRYING TO REMOVE
        val res = checker.removeNodeIfPossible(file, node)
        if (!res) {
            queue.addChildrenFromMapToQueue(node)
        }
    }

    class QueueComparator : Comparator<Pair<ASTNode, Triple<Int, Int, Int>>> {
        override fun compare(o1: Pair<ASTNode, Triple<Int, Int, Int>>?, o2: Pair<ASTNode, Triple<Int, Int, Int>>?): Int {
            val firstComparison = o1!!.second.first.compareTo(o2!!.second.first)
            if (firstComparison != 0) return -firstComparison
            val secondComparison = o1.second.second.compareTo(o2.second.second)
            if (secondComparison != 0) return -secondComparison
            return -o1.second.third.compareTo(o2.second.third)
        }

    }

    private fun getEntire(map: Map<ASTNode, Triple<Int, Int, Int>>, node: ASTNode) = node to map[node]!!

    private fun PriorityQueue<Pair<ASTNode, Triple<Int, Int, Int>>>.addChildrenFromMapToQueue(node: ASTNode) =
            node.getAllChildrenOfCurLevel().forEach { this.offer(it to tokensWithParentBFSOrder[it]!!) }

    private fun PriorityQueue<Pair<ASTNode, Triple<Int, Int, Int>>>.addFromMapToQueue(node: ASTNode) =
            this.offer(node to tokensWithParentBFSOrder[node]!!)

}