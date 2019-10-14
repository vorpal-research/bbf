package com.stepanov.bbf

import com.stepanov.bbf.executor.CompilerArgs
import com.stepanov.bbf.executor.compilers.JSCompiler
import com.stepanov.bbf.executor.compilers.JVMCompiler
import com.stepanov.bbf.util.BBFProperties
import com.stepanov.reduktor.executor.backends.JVMBackend
import kotlinx.coroutines.*
import net.sourceforge.argparse4j.ArgumentParsers
import org.apache.log4j.PropertyConfigurator
import java.io.File
import kotlin.system.exitProcess


fun main(args: Array<String>) {
    //Init log4j
    PropertyConfigurator.configure("backend-bugfinder/src/main/resources/log4j.properties")
    val parser = ArgumentParsers.newFor("bbf").build()
    parser.addArgument("-r", "--reduce")
            .required(false)
            .help("Reduce mode")
    parser.addArgument("-f", "--fuzz")
            .required(false)
            .help("Fuzzing mode")
    val arguments = parser.parseArgs(args)
    arguments.getString("reduce")?.let {
        val back = BBFProperties.getStringGroupWithoutQuotes("BACKEND_FOR_REDUCE").entries.first()
        val compiler = when (back.key) {
            "JVM" -> JVMCompiler(back.value)
            "JS" -> JSCompiler(back.value)
            else -> throw IllegalArgumentException("Illegal backend")
        }
        val tmpPath = CompilerArgs.pathToTmpFile
        require(!File(it).isDirectory) { "Specify file to reducing" }
        File(tmpPath).writeText(File(it).readText())
        val res = Reducer.reduce(tmpPath, compiler)
        for (r in res) {
            println("Result of reducing $it:\n${r.text}")
        }
        exitProcess(0)
    }
    arguments.getString("fuzz")?.let {
        require(File(it).isDirectory) { "Specify directory to take files for mutation" }
        val file = File(it).listFiles().random()
        BugFinder(file.absolutePath).findBugsInFile()
        exitProcess(0)
    }
}