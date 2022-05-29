//package com.stepanov.reduktor.passes
//
//import com.intellij.lang.ASTNode
//import com.intellij.lang.FileASTNode
//import com.intellij.psi.PsiWhiteSpace
//import com.stepanov.reduktor.parser.PSICreator
//import com.stepanov.reduktor.executor.CommonCompilerCrashTestChecker
//import com.stepanov.reduktor.util.getAllChildrenOfTheLevel
//import com.stepanov.reduktor.util.getAllWithout
//import org.apache.log4j.Logger
//import org.codehaus.plexus.util.FileUtils
//import org.jetbrains.kotlin.psi.KtFile
//import org.jetbrains.kotlin.psi.KtPsiFactory
//import java.io.File
//import java.util.concurrent.Callable
//import java.util.concurrent.Executors
//import java.util.concurrent.Future
//
//
////Experiments have shown that it does not work
//class ParallelHierarchialDeltaDebugger(private val tree: FileASTNode, private val projPath: String) {
//
//    fun getLevelNum(): Int {
//        var cur = 0
//        while (true) {
//            if (tree.getAllChildrenOfTheLevel(cur).isEmpty())
//                return cur
//            else
//                ++cur
//        }
//    }
//
//    fun hdd() {
//        val levels = getLevelNum()
//        println("LEVELS = ${levels}")
//        val procs = 8
//        val executor = Executors.newFixedThreadPool(procs)
//        val taskList = mutableListOf<Callable<Pair<List<ASTNode>, Int>>>()
//        for (i in 0 until procs)
//            taskList.add(createHDDTask(tree.psi as KtFile, i, i + 1))
//        println("Tasks = ${taskList.size}")
//        val res = mutableListOf<Future<Pair<List<ASTNode>, Int>>>()
//        for (task in taskList) {
//            res.add(executor.submit(task))
//        }
//        while (!res.all { it.isDone }) {
//        }
//        res.forEach { println("AFTER ${it.get().second} = ${it.get().first}") }
////        log.debug("Starting to reduce ${tree.text}")
////        var nodes = tree.getAllChildrenOfCurLevel().toList()
////        while (nodes.isNotEmpty() || level > maxLevel) {
////            log.debug("Cur level is $level \n")
////            val minconfig = DDMIN(nodes.toList())
////            log.debug("MINCONFIG = ${minconfig.map { it }}")
////            log.debug("VERIFY BEFORE LEVEL $level = ${checker.checkTest(tree.text)}")
////            deleteNodes(tree, minconfig, level)
////            log.debug("VERIFY LEVEL $level = ${checker.checkTest(tree.text)}")
////            ++level
////            nodes = tree.getAllChildrenOfTheLevel(level)
////            log.debug("RES after level $level: ${tree.text}")
////        }
////        log.debug("Result: ${tree.text}")
//    }
//
//    private fun createNewProjectCopy(id: Int): String {
//        val newPath = projPath + id
//        FileUtils.removePath(newPath)
//        FileUtils.copyDirectoryStructure(File(projPath), File(newPath))
//        return newPath
//    }
//
//    private fun createHDDTask(reduceFile: KtFile, index: Int, level: Int): Callable<Pair<List<ASTNode>, Int>> {
//        val newPath = createNewProjectCopy(index)
//        val newCreator = PSICreator(newPath)
//        val newFiles = newCreator.getPSI()
//        val bugFileName = reduceFile.name.drop(newPath.length - index.toString().length)
//        var newFileWithBug = reduceFile
//        for (f in newFiles) {
//            val cutName = f.name.drop(newPath.length)
//            if (cutName == bugFileName) {
//                newFileWithBug = f
//                break
//            }
//        }
//        val nodes = newFileWithBug.node.getAllChildrenOfTheLevel(level)
//        return ParallelHDD(newFileWithBug.node, level, nodes, newPath)
//    }
//
//
//    private val log = Logger.getLogger("reducerLogger")
//
//    private class ParallelHDD(private val tree: FileASTNode, private val level: Int, private val nodes: List<ASTNode>,
//                              private val path: String)
//        : Callable<Pair<List<ASTNode>, Int>> {
//
//        private val checker = CommonCompilerCrashTestChecker()
//        private val log = Logger.getLogger("transformationManagerLog")
//
//        override fun call(): Pair<List<ASTNode>, Int> {
//            log.debug("BEFORE $level = ${nodes}")
//            val fileToReduce = tree.psi as KtFile
//            checker.pathToFile = fileToReduce.name
//            checker.init(path, KtPsiFactory(fileToReduce))
//            checker.refreshAlreadyCheckedConfigurations()
//            checker.pathToFile = fileToReduce.name
//            return Pair(DDMIN(nodes), level)
//        }
//
//        private fun deleteNodes(tree: FileASTNode, minconf: List<ASTNode>, level: Int): FileASTNode {
//            val childs = tree.getAllChildrenOfTheLevel(level)
//            childs
//                    .filter { !minconf.contains(it) && it !is PsiWhiteSpace }
//                    .forEach { checker.removeNodeIfPossible(tree, it); }
//            return tree
//        }
//
//        private fun deleteNodes(tree: FileASTNode, minconf: List<ASTNode>, level: Int, nodes: List<ASTNode>): FileASTNode {
//            val childs = tree.getAllChildrenOfTheLevel(level)
//            childs
//                    .filter { !minconf.contains(it) && it !is PsiWhiteSpace && containsAstNodeText(nodes, it) }
//                    .forEach { checker.removeNodeIfPossible(tree, it) }
//            return tree
//        }
//
//        private fun containsAstNodeText(list: List<ASTNode>, el: ASTNode): Boolean =
//                list.any { it.startOffset == el.startOffset && it.elementType == el.elementType && it.text == el.text }
//
//        private fun getCopyWithDeletingNodes(matchingNodes: Boolean, minconf: List<ASTNode>, nodes: List<ASTNode>): FileASTNode {
//            val copyTree = tree.copyElement() as FileASTNode
//            val childs = copyTree.getAllChildrenOfTheLevel(level)
//            if (matchingNodes) {
//                childs
//                        .filterNot { containsAstNodeText(minconf, it) || it is PsiWhiteSpace || !containsAstNodeText(nodes, it) }
//                        .forEach { copyTree.removeChild(it) }
//            } else {
//                childs
//                        .filterNot { !containsAstNodeText(minconf, it) || it is PsiWhiteSpace || !containsAstNodeText(nodes, it) }
//                        .forEach { copyTree.removeChild(it) }
//            }
//            return copyTree
//        }
//
//
//        private fun getSublist(tree: List<ASTNode>, n: Int): ArrayList<List<ASTNode>> {
//            val subList: ArrayList<List<ASTNode>> = arrayListOf()
//            val step = tree.size / n
//            if (step < 2) return (0 until tree.size).mapTo(subList) { listOf(tree[it]) }
//            var cur = 0
//            for (i in 0 until n) {
//                if (i == tree.size)
//                    break
//                if (i == n - 1)
//                    subList.add(tree.slice(cur until tree.size))
//                else
//                    subList.add(tree.slice(cur until cur + step))
//                cur += step
//            }
//            return subList
//        }
//
//        private fun getCompleteness(subList: ArrayList<List<ASTNode>>): ArrayList<List<ASTNode>> {
//            val completeness: ArrayList<List<ASTNode>> = arrayListOf()
//            for (i in 0 until subList.size) {
//                val comp = subList.getAllWithout(i)
//                completeness.add(comp.flatten())
//            }
//            return completeness
//        }
//
//        private fun DDMIN_(tree: List<ASTNode>, n: Int): List<ASTNode> {
//            // Dividing
//            var step = tree.size / n
//            if (step == 0) ++step
//            val subList = getSublist(tree, n)
//            //Try to check subset
//            for (sub in subList) {
//                if (checker.checkTest(getCopyWithDeletingNodes(true, sub, tree).text)) {
//                    if (tree.size == 1)
//                        return tree
//                    else
//                        return DDMIN_(sub/*.filterRowPsiWhiteSpaces()*/, 2)
//                }
//            }
//            //Try to check completeness of subsets
//            if (n != 2) {
//                val completeness = getCompleteness(subList)
//                for (com in completeness) {
//                    if (checker.checkTest(getCopyWithDeletingNodes(true, com, tree).text)) {
//                        /* DD_MIN(_, max(n - 1, 2)*/
//                        return DDMIN_(com, maxOf(n - 1, 2))
//                        //return DDMIN_(com.filterRowPsiWhiteSpaces(), n - 1)
//                    }
//                }
//            }
//            //Increase the granularity
//            if (step != 1)
//            /* DDMIN_(_, min(2*n, |Cx|) */
//                return DDMIN_(tree, minOf(2 * n, tree.size))
//            //return DDMIN_(tree, 2 * n)
//            return tree
//        }
//
//        private fun DDMIN(tree: List<ASTNode>): List<ASTNode> {
//            val res = DDMIN_(tree, 2)
//            return res
//        }
//    }
//}