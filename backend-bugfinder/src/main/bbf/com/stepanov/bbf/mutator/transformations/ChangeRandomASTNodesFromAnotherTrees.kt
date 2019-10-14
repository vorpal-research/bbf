package com.stepanov.bbf.mutator.transformations

import com.stepanov.bbf.executor.CompilerArgs
import com.stepanov.bbf.executor.MutationChecker
import com.stepanov.bbf.util.NodeCollector
import com.stepanov.bbf.util.getAllChildrenNodes
import com.stepanov.reduktor.parser.PSICreator
import org.apache.log4j.Logger
import java.io.File
import kotlin.random.Random


class ChangeRandomASTNodesFromAnotherTrees : Transformation() {

    override fun transform() {
        val randConst = Random.nextInt(numOfTries.first, numOfTries.second)
        log.debug("Trying to change some nodes to nodes from other programs $randConst times")
        for (i in 0..randConst) {
            log.debug("Try №$i of $randConst")
            val nodes = file.node.getAllChildrenNodes().filter { it.elementType !in NodeCollector.excludes }
            val randomNode = nodes[Random.nextInt(0, nodes.size - 1)]
            //Searching nodes of same type in another files
            val line = File("database.txt").bufferedReader().lines()
                    .filter { it.takeWhile { it != ' ' } == randomNode.elementType.toString() }.findFirst()
            if (!line.isPresent) continue
            val files = line.get().dropLast(1).takeLastWhile { it != '[' }.split(", ")
            val randomFile =
                    if (files.size == 1)
                        files[0]
                    else
                        files[Random.nextInt(0, files.size - 1)]
            val psi = PSICreator("").getPSIForFile("${CompilerArgs.baseDir}/$randomFile")
            val sameTypeNodes = psi.node.getAllChildrenNodes().filter { it.elementType == randomNode.elementType }
            val targetNode =
                    if (sameTypeNodes.size == 1)
                        sameTypeNodes[0]
                    else
                        sameTypeNodes[Random.nextInt(0, sameTypeNodes.size - 1)]
            MutationChecker.replaceNodeIfPossible(file, randomNode, targetNode)
        }
    }

    val numOfTries = 50 to 1000
    private val log = Logger.getLogger("mutatorLogger")
}