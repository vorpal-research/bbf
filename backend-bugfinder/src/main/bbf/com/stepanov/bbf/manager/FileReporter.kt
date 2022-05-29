package com.stepanov.bbf.manager

import com.stepanov.bbf.executor.CompilerArgs
import com.stepanov.bbf.util.getRandomVariableName
import java.io.File
import java.util.*


//TODO Maybe add crashing message in comments
object FileReporter : Reporter {

    fun saveRegularBug(bug: Bug) {
        val compilerBugDir = bug.compilerVersion.filter { it != ' ' }
        val resDir = CompilerArgs.resultsDir
        val randomName = Random().getRandomVariableName(5)
        val newPath =
                if (resDir.endsWith('/')) "$resDir$compilerBugDir/${bug.type.name}_$randomName.kt"
                else "$resDir/$compilerBugDir/${bug.type.name}_$randomName.kt"
        File(newPath).writeText(bug.crashingCode)
    }

    fun saveDiffBug(bug: Bug, type: String) {
        val resDir = CompilerArgs.resultsDir
        val newPath =
                if (resDir.endsWith('/')) "${resDir}diff$type/${Random().getRandomVariableName(7)}.kt"
                else "${resDir}/diff$type/${Random().getRandomVariableName(7)}.kt"
        val diffCompilers = "// Different ${type.toLowerCase()} happens on:${bug.compilerVersion}"
        File(newPath.substringBeforeLast('/')).mkdirs()
        File(newPath).writeText("$diffCompilers\n${bug.crashingCode}")
    }

    override fun dump(bugs: List<Bug>) {
        for (bug in bugs) {
            when (bug.type) {
                BugType.DIFFBEHAVIOR -> saveDiffBug(bug, "Behavior")
                BugType.DIFFCOMPILE -> saveDiffBug(bug, "Compile")
                else -> saveRegularBug(bug)
            }
        }
    }

}