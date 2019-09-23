package com.stepanov.bbf.manager

import com.stepanov.bbf.executor.CompilerType
import com.stepanov.bbf.util.getRandomVariableName
import java.io.File
import java.util.*


//TODO link directory to compiler version
//TODO Maybe add crashing message in comments
object FileReporter : Reporter {

    override fun dump(bugs: List<Bug>) {
        for (bug in bugs) {
            val compiler = when {
                bug.compilerVersion.contains("JVM", true) -> "JVMPATH"
                bug.compilerVersion.contains("JS", true) -> "JSPATH"
                bug.compilerVersion.contains("Native", true) -> "NATIVEPATH"
                else -> "DIFFBEHAVIOR"
            }
            val dir = ReportProperties.getPropValue(compiler)
            val name = Random().getRandomVariableName(5)
            File("$dir/$name.kt").writeText(bug.crashingCode)
        }
    }

}