package com.stepanov.bbf

import com.stepanov.bbf.executor.CompilerArgs
import java.io.File

object BBFExecutor {
    fun execute(pathToBaseDir: String, numThreads: Int = 1) {
        while (true) {
            val listOfFiles = File(pathToBaseDir).listFiles().filter { it.name.endsWith(".kt") }
            listOfFiles.shuffled().forEach {
                BugFinder(it.absolutePath).findBugsInFile()
            }
        }
    }
}