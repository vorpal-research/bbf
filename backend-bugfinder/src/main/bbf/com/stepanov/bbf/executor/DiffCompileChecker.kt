package com.stepanov.bbf.executor

import com.stepanov.reduktor.executor.error.Error
import org.jetbrains.kotlin.psi.KtPsiFactory
import java.io.File

class DiffCompileChecker(private val compilers: List<CommonCompiler>) : MultiCompilerCrashChecker(null) {

    override fun checkTest(text: String, pathToFile: String): Boolean {
        val preCheck = isAlreadyCheckedOrWrong(text)
        if (preCheck.first) return preCheck.second
        val oldText = File(pathToFile).bufferedReader().readText()
        var writer = File(pathToFile).bufferedWriter()
        writer.write(text)
        writer.close()
        //TODO Decide what to do with it
        if (compilers.any { it.isCompilerBug(pathToFile) }) {
            alreadyChecked[text.hashCode()] = false
            return false
        }
        val compilersToStatus = compilers.map { it to it.checkCompilingText(text) }
        val res = compilersToStatus.map { it.second }.toSet().size != 1
        writer = File(pathToFile).bufferedWriter()
        writer.write(oldText)
        writer.close()
        alreadyChecked[text.hashCode()] = res
        return res
    }

    override fun init(compilingPath: String, psiFactory: KtPsiFactory?): Error {
        return Error("")
    }
}