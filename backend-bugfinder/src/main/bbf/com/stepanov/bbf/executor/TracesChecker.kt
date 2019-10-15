package com.stepanov.bbf.executor

import com.intellij.lang.ASTNode
import com.intellij.lang.FileASTNode
import com.intellij.psi.PsiErrorElement
import com.stepanov.reduktor.util.getAllChildrenNodes
import com.stepanov.bbf.mutator.transformations.Transformation
import com.stepanov.bbf.util.checkCompilingForAllBackends
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

        val psiFile = psiFactory.createFile(text)
        //Check for syntax correctness
        if (psiFile.node.getAllChildrenNodes().any { it.psi is PsiErrorElement }) {
            log.debug("Not correct syntax")
            alreadyChecked[hash] = null
            return null
        }

        log.debug("Trying to compile with main function:")
        if (!compilers.checkCompilingForAllBackends(psiFile)) {
            log.debug("Cannot compile with main")
            return null
        }

        log.debug("Executing traced code:\n$text")
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
    }

    override fun transform() = TODO()

    var alreadyChecked: HashMap<Int, List<CommonCompiler>?> = HashMap()
    private val log = Logger.getLogger("bugFinderLogger")
}