package com.stepanov.bbf.manager

import java.io.File
import java.io.FileNotFoundException

object TextReporter : Reporter {

    override fun dump(bugs: List<Bug>) {
        val file = File(ReportProperties.getPropValue("PATH_TO_TEXT_FILE"))
        //Sorting
        val sortedBugs = bugs.sortedWith(Comparator { o1, o2 -> o1.compareTo(o2) })
        val bugsToStr = sortedBugs.joinToString(separator = "\n\n\n")
        {
            """*******************************************************************
                |Compiler: ${it.compilerVersion}
            |Type: ${it.type}
            |CrashingCode: ${it.crashingCode}
            |Message: ${it.msg}
            |*******************************************************************""".trimMargin()
        }
        file.writeText(bugsToStr)
    }


}