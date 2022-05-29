package com.stepanov.bbf.mutator.transformations

import com.intellij.lang.ASTNode
import com.stepanov.bbf.executor.MutationChecker
import org.jetbrains.kotlin.psi.psiUtil.parents
import com.stepanov.bbf.util.getAllChildrenNodes
import com.stepanov.bbf.util.replaceThis
import kotlin.random.Random
import org.apache.log4j.Logger

class ChangeRandomASTNodes : Transformation() {

    override fun transform() {
        val numOfSwaps = Random.nextInt(numOfSwaps.first, numOfSwaps.second)
        for (i in 0 until numOfSwaps) {
            log.debug("Swap $i of $numOfSwaps")
            val children = file.node.getAllChildrenNodes()
            //Swap random nodes
            var randomNode1 = children[Random.nextInt(children.size)]
            var randomNode2 = children[Random.nextInt(children.size)]
            while (true) {
                if (randomNode1.text.trim().isEmpty() /*|| randomNode1.text.contains("\n")*/
                        || randomNode1.parents().contains(randomNode2))
                    randomNode1 = children[Random.nextInt(children.size)]
                else if (randomNode2.text.trim().isEmpty() /*|| randomNode2.text.contains("\n")*/
                        || randomNode2.parents().contains(randomNode1))
                    randomNode2 = children[Random.nextInt(children.size)]
                else break
            }
            val new = swap(randomNode1, randomNode2)
            if (!MutationChecker.checkTextCompiling(file.text)) {
                swap(new.first, new.second)
            }
        }
    }

    private fun swap(randomNode1: ASTNode, randomNode2: ASTNode): Pair<ASTNode, ASTNode> {
        //var tmp1 = psiFactory.createWhiteSpace()
        //var tmp2 = psiFactory.createWhiteSpace()
        //val tmp3 = tmp1.copy()
        //val tmp4 = tmp2.copy()
        val tmp1 = psiFactory.createProperty("val a = 1")
        val tmp2 = psiFactory.createProperty("val a = 2")
        randomNode1.treeParent.addChild(tmp1.node, randomNode1)
        randomNode2.treeParent.addChild(tmp2.node, randomNode2)
        tmp1.replaceThis(randomNode2.psi)
        tmp2.replaceThis(randomNode1.psi)
        return randomNode2 to randomNode1
    }

    val numOfSwaps = 50 to 1000
    private val log = Logger.getLogger("mutatorLogger")
}