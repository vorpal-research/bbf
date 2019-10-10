package com.stepanov.bbf.executor

import com.intellij.lang.ASTNode
import com.intellij.lang.FileASTNode
import com.intellij.psi.PsiErrorElement
import com.stepanov.reduktor.util.getAllChildrenNodes
import com.stepanov.bbf.mutator.transformations.Transformation
import org.apache.log4j.Logger
import org.jetbrains.kotlin.psi.KtFile
import org.jetbrains.kotlin.psi.KtPsiFactory
import com.stepanov.bbf.util.getAllParentsWithoutNode
import com.stepanov.reduktor.executor.CompilerTestChecker
import com.stepanov.reduktor.executor.error.Error
import java.io.BufferedWriter
import java.io.File
import java.io.FileWriter

// Transformation is here only for PSIFactory
class TracesChecker(private val compilers: List<CommonCompiler>) : Transformation() {

//    override fun removeNodeIfPossible(file: KtFile, node: ASTNode): Boolean {
//        val tmp = KtPsiFactory(file.project).createWhiteSpace("\n")
//        return replaceNodeIfPossible(file, node, tmp.node)
//    }
//
//    override fun removeNodeIfPossible(file: FileASTNode, node: ASTNode) {
//        val ktFile = file.psi as KtFile
//        removeNodeIfPossible(ktFile, node)
//    }
//
//    override fun removeNodesIfPossible(file: KtFile, nodes: List<ASTNode>): Boolean {
//        val copies = mutableListOf<ASTNode>()
//        val whiteSpaces = mutableListOf<ASTNode>()
//        nodes.forEach { copies.add(it.copyElement()); whiteSpaces.add(KtPsiFactory(file.project).createWhiteSpace("\n").node) }
//        for ((i, node) in nodes.withIndex()) {
//            for (p in node.getAllParentsWithoutNode()) {
//                try {
//                    p.replaceChild(node, whiteSpaces[i])
//                    break
//                } catch (e: AssertionError) {
//                }
//            }
//        }
//        if (!checkTest(file.text)) {
//            for ((i, node) in nodes.withIndex()) {
//                for (p in whiteSpaces[i].getAllParentsWithoutNode()) {
//                    try {
//                        p.replaceChild(whiteSpaces[i], node)
//                        break
//                    } catch (e: AssertionError) {
//                    }
//                }
//            }
//            return false
//        } else return true
//    }
//
//
//    override fun replaceNodeIfPossible(file: KtFile, node: ASTNode, replacement: ASTNode): Boolean {
//        if (node.text.isEmpty() || node == replacement) return checkTest(file.text, file.name)
//        for (p in node.getAllParentsWithoutNode()) {
//            try {
//                val oldText = file.text
//                p.replaceChild(node, replacement)
//                if (oldText == file.text)
//                    continue
//                if (!checkTest(file.text, file.name)) {
//                    log.debug("REPLACING BACK")
//                    p.replaceChild(replacement, node)
//                    return false
//                } else {
//                    log.debug("SUCCESSFUL DELETING")
//                    return true
//                }
//            } catch (e: AssertionError) {
//                log.debug("Exception while deleting ${node.text} from $p")
//            }
//        }
//        return false
//    }

    fun checkTest(text: String): List<CommonCompiler>? {
        var resText = text
        if (!resText.contains("fun main(")) {
            resText += "fun main(args: Array<String>) {\n" +
                    "    println(box())\n" +
                    "}"
        }
        val writer = BufferedWriter(FileWriter(CompilerArgs.pathToTmpFile))
        writer.write(resText)
        writer.close()
        log.debug("Executing traced code:\n$resText")
        val res = checkTest(resText, CompilerArgs.pathToTmpFile)
        File(CompilerArgs.pathToTmpFile).delete()
        return res
    }


    fun checkTest(text: String, pathToFile: String): List<CommonCompiler>? {
        val hash = text.hashCode()
        if (alreadyChecked.containsKey(hash)) {
            log.debug("ALREADY CHECKED!!!")
            return alreadyChecked[hash]!!
        }
        //Check for syntax correctness
        if (psiFactory.createFile(text).node.getAllChildrenNodes().any { it.psi is PsiErrorElement }) {
            log.debug("Not correct syntax")
            alreadyChecked[hash] = null
            return null
        }


        val results = mutableListOf<Pair<CommonCompiler, String>>()
        for (comp in compilers) {
            val status = comp.compile(pathToFile)
            if (status.status == -1)
                return null
            val res = comp.exec(status.pathToCompiled)
            log.debug("Result of ${comp.compilerInfo}: $res\n")
            results.add(comp to res.trim())
        }
        val groupedRes = results.groupBy({ it.second }, valueTransform = { it.first })
        return if (groupedRes.size == 1) {
            null
        } else {
            val res = groupedRes.map { it.value.first() }
            alreadyChecked[hash] = res
            res
        }


//        val jvmComp = JVMCompiler()
//        val jsComp = JSCompiler()
//        val nativeCompiler = NativeCompiler()
//        //Now we need to check compiling. False if files cannot be compiled
//        if (!jvmComp.checkCompilingText(text) || !jsComp.checkCompilingText(text) || !nativeCompiler.checkCompilingText(text)) {
//            log.debug("CANT COMPILE")
//            alreadyChecked[hash] = false
//            return false
//        }
//        log.debug("JVM compiling")
//        val jvmStatus = jvmComp.compile(pathToFile)
//        log.debug("jvm Compile OK $jvmStatus")
//        if (jvmStatus.status == -1)
//            return false
//        val jvmRes = jvmComp.exec(jvmStatus.pathToCompiled)
//        log.debug("jvmRes = $jvmRes")
//        val jsStatus = jsComp.compile(pathToFile)
//        log.debug("js Compile OK")
//        if (jsStatus.status == -1)
//            return false
//        val jsRes = jsComp.exec(jsStatus.pathToCompiled)
//        log.debug("jsRes = $jsRes")
//        val nativeStatus = nativeCompiler.compile(pathToFile)
//        log.debug("native Compile OK")
//        if (nativeStatus.status == -1)
//            return false
//        var nativeRes = nativeCompiler.exec(nativeStatus.pathToCompiled)
//        //Native backend displays exception in input stream (we need fo filter it)
//        val excIndex = nativeRes.indexOf("Uncaught ")
//        if (excIndex != -1) {
//            nativeRes = nativeRes.substring(0, excIndex)
//        }
//
//        log.debug("nativeRes = $nativeRes")

//        alreadyChecked[hash] = jvmRes != jsRes
//        val res = (jvmRes.trim() != jsRes.trim()) || (jvmRes.trim() != nativeRes.trim())
//                || (jsRes.trim() != nativeRes.trim())
//        if (res) {
//            val jvmWords = jvmRes.split('\n').toSet()
//            val jsWords = jsRes.split('\n').toSet()
//            if (jvmWords + prevJVMResult == prevJVMResult && jsWords + prevJSResult == prevJSResult
//                    || prevJVMResult.isEmpty() && prevJSResult.isEmpty()) {
//                log.debug("Reduced from $oldText to $text")
//                log.debug("jsWords = $jsWords \n prev = $prevJSResult")
//                prevJVMResult = jvmWords
//                prevJSResult = jsWords
//                return true
//            } else return false
//        }
    }

    fun checkTest(tree: List<ASTNode>): List<CommonCompiler>? {
        if (tree.isEmpty()) return null
        val text = StringBuilder()
        for (el in tree)
            text.append(el.text)
        log.debug("Checking : $text")
        return checkTest(text.toString())
    }

    //    override fun getErrorInfo(): Error = Error("")
//
//    override fun getErrorMessage(): String = "error message"
//
//    override fun init(compilingPath: String, psiFactory: KtPsiFactory?): Error = Error("")
//
//    override fun reinit(): Error = Error("")
//
    override fun transform() = TODO()

    var pathToFile: String = ""
    var alreadyChecked: HashMap<Int, List<CommonCompiler>?> = HashMap()

    //Kostyl' for reduction process
    var prevJVMResult = setOf<String>()
    var prevJSResult = setOf<String>()

    private val log = Logger.getLogger("bugFinderLogger")
}