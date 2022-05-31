package com.stepanov.bbf.manager

import java.io.File

object TextReporter : Reporter {

    override fun dump(bugs: List<Bug>) {
        val file = File(checkNotNull(ReportProperties.getPropValue("PATH_TO_TEXT_FILE")) { error("PATH_TO_TEXT") })
        //Sorting
        val sortedBugs = bugs.sortedWith(Bug::compareTo)
        val bugsToStr = sortedBugs.joinToString(separator = "\n\n\n")
        {
            """*******************************************************************
                |Compiler: ${it.compilerVersion}
            |Type: ${it.type}
            |CrashingCode: ${it.crashingCode}
            |Message: ${it.msg}
            |*******************************************************************""".trimMargin()
        }
        file.appendText(bugsToStr)
    }


}