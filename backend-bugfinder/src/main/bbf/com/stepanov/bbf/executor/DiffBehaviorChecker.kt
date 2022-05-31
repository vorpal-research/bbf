package com.stepanov.bbf.executor

import com.stepanov.bbf.util.checkCompilingForAllBackends
import com.stepanov.reduktor.executor.error.Error
import org.apache.log4j.Logger
import org.jetbrains.kotlin.psi.KtPsiFactory
import java.io.File

class DiffBehaviorChecker(private val compilers: List<CommonCompiler>) : MultiCompilerCrashChecker(null) {

    private fun compileAndGetExecResult(): List<Pair<CommonCompiler, String>> {
        val results = mutableListOf<Pair<CommonCompiler, String>>()
        for (comp in compilers) {
            val status = comp.compile(pathToFile)
            if (status.status == -1)
                return listOf()
            val res = comp.exec(status.pathToCompiled)
            log.debug("Result of ${comp.compilerInfo}: $res\n")
            results.add(comp to res.trim())
        }
        return results
    }

    private fun isSameDiffBehavior(text: String): Boolean {
        val psiFile = psiFactory.createFile(text)
        if (!compilers.checkCompilingForAllBackends(psiFile)) {
            log.debug("Cannot compile with main")
            return false
        }
        log.debug("Executing traced code:\n$text")
        val results = compileAndGetExecResult()
        if (results.isEmpty()) return false
        val backup = prevResults.map { it }
        for ((ind, res) in results.withIndex()) {
            val prevRes = prevResults[ind]
            val curRes = res.second.split("\n").filter { it.isNotEmpty() }
            log.debug("prevRes for ${res.first.compilerInfo}: $prevRes\ncurRes: $curRes\n\n")
            if (curRes.any { !prevRes.contains(it) }) {
                for ((j, b) in backup.withIndex()) {
                    prevResults[j] = b
                }
                return false
            }
            prevResults[ind] = curRes
        }
        val set = results.map { it.second }.toSet()
        val res = results.size == set.size
        log.debug("Result = $res")
        if (!res) {
            for ((ind, b) in backup.withIndex()) {
                prevResults[ind] = b
            }
        }
        return res
    }

    override fun checkTest(text: String, pathToFile: String): Boolean {
        val preCheck = isAlreadyCheckedOrWrong(text)
        if (preCheck.first) return preCheck.second
        val oldText = File(pathToFile).bufferedReader().readText()
        var writer = File(pathToFile).bufferedWriter()
        writer.write(text)
        writer.close()
        val res = isSameDiffBehavior(text)
        writer = File(pathToFile).bufferedWriter()
        writer.write(oldText)
        writer.close()
        alreadyChecked[text.hashCode()] = res
        return res
    }

    override fun init(compilingPath: String, psiFactory: KtPsiFactory?): Error {
        val results = compileAndGetExecResult()
        results.forEachIndexed { _, pair -> prevResults.add(pair.second.split("\n").filter { it.isNotEmpty() }) }
        return Error("")
    }


    val prevResults: MutableList<List<String>> = ArrayList()

    private val log = Logger.getLogger("bugFinderLogger")
}