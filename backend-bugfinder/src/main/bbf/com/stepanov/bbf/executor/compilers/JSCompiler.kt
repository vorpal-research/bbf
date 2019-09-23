package com.stepanov.bbf.executor.compilers

import com.stepanov.bbf.executor.*
import com.stepanov.bbf.util.Stream
import org.jetbrains.kotlin.cli.common.arguments.K2JSCompilerArguments
import org.jetbrains.kotlin.cli.js.K2JSCompiler
import org.jetbrains.kotlin.config.Services
import com.stepanov.bbf.util.readInputAndErrorStreams
import com.stepanov.bbf.util.readStream
import com.stepanov.reduktor.executor.KotlincInvokeStatus
import com.stepanov.reduktor.util.MsgCollector
import java.io.*
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeoutException

//TODO: Add bug saving
class JSCompiler(private val arguments: String = "") : CommonCompiler() {

    override val compilerInfo: String
        get() = "JS $arguments"

    override fun getErrorMessage(pathToFile: String): String = tryToCompile(pathToFile).combinedOutput

    override fun checkCompiling(pathToFile: String): Boolean {
        val status = tryToCompile(pathToFile)
        return !MsgCollector.hasCompileError && !status.hasTimeout && !MsgCollector.hasException
    }

    override fun isCompilerBug(pathToFile: String) =
            tryToCompile(pathToFile).combinedOutput.contains("Exception:", true)

    override fun tryToCompile(pathToFile: String): KotlincInvokeStatus {
        val tmpPath = "/tmp/tmp.js"
        File(tmpPath).delete()
        val args =
                if (arguments.isEmpty())
                    "$pathToFile -libraries ${CompilerArgs.pathToJsKotlinLib} -output $tmpPath".split(" ")
                else
                    "$pathToFile $arguments -libraries ${CompilerArgs.pathToJsKotlinLib} -output $tmpPath".split(" ")
//        val args = ("$pathToFile -libraries ${CompilerArgs.pathToJsKotlinLib} " +
//                "-output $tmpPath").split(" ")
        val compiler = K2JSCompiler()
        val compilerArgs = K2JSCompilerArguments().apply { K2JSCompiler().parseArguments(args.toTypedArray(), this) }
        MsgCollector.clear()
        val services = Services.EMPTY
        val threadPool = Executors.newCachedThreadPool()
        val futureExitCode = threadPool.submit {
            compiler.exec(MsgCollector, services, compilerArgs)
        }
        var hasTimeout = false
        try {
            futureExitCode.get(5L, TimeUnit.SECONDS)
        } catch (ex: TimeoutException) {
            hasTimeout = true
            futureExitCode.cancel(true)
        }
        File(tmpPath).delete()
        val status = KotlincInvokeStatus(MsgCollector.crashMessages.joinToString("\n") +
                MsgCollector.compileErrorMessages.joinToString("\n"),
                !MsgCollector.hasCompileError,
                MsgCollector.hasException,
                hasTimeout)
        return status
    }

    //super.exec(path, CompilerType.JS, Stream.INPUT)
    override fun exec(path: String): String {
        val proc = ProcessBuilder("/bin/bash", "-c", "node $path").start()
        try {
            val a = proc.waitFor(5L, TimeUnit.SECONDS)
            if (!a) {
                while (proc.isAlive) proc.destroyForcibly()
                return ""
            }
        } catch (e: IllegalThreadStateException) {
            println("exit value = ${proc.exitValue()}")
        }
        val result = proc.readStream(Stream.INPUT)
        while (proc.isAlive) proc.destroyForcibly()
        return result
    }

//    override fun compile(path: String): CompilingResult {
//        val resultFilePath = "/home/stepanov/Kotlin/testProjects/backendBugsTests/lol.js"
//        try {
//            File(resultFilePath).delete()
//        } catch (e: FileNotFoundException) {
//        }
////        println("path = $path")
////        val text = BufferedReader(FileReader(File(path))).readLines().joinToString("\n")
////        println("file = $text")
////        println("CHECK COMPILING = ${checkCompiling(path)}")
////        println("CHECK COMPILING TEXT = ${checkCompilingText(text)}")
//        val args = ("$path -libraries ${CompilerArgs.pathToJsKotlinLib} " +
//                "-output $resultFilePath").split(" ")
//        val compiler = K2JSCompiler()
//        val compilerArgs = K2JSCompilerArguments().apply { K2JSCompiler().parseArguments(args.toTypedArray(), this) }
//        val services = Services.EMPTY
//        val threadPool = Executors.newCachedThreadPool()
//        val futureExitCode = threadPool.submit {
//            compiler.exec(MsgCollector, services, compilerArgs)
//        }
//        var hasTimeout = false
//        try {
//            futureExitCode.get(3L, TimeUnit.SECONDS)
//        } catch (ex: TimeoutException) {
//            hasTimeout = true
//        }
//        val isSuccess = !MsgCollector.hasCompileError && !hasTimeout
////        println("JsError1 = ${MsgCollector.compileErrorMessages.joinToString()}")
////        println("JsError2 = ${MsgCollector.crashMessages.joinToString()}")
//        MsgCollector.clear()
//        return if (isSuccess) {
//            val oldStr = FileReader(File(resultFilePath)).readText()
//            val newStr = "const kotlin = require(\"${CompilerArgs.pathToJsKotlinLib}/kotlin.js\");\n\n$oldStr"
//            val fw = FileWriter(resultFilePath, false)
//            val bw = BufferedWriter(fw)
//            bw.write(newStr)
//            bw.close()
//            CompilingResult(0, resultFilePath)
//        } else {
//            CompilingResult(-1, "")
//        }
//    }

    override fun compile(path: String): CompilingResult {
        val newPath = "tmp/lol.js"
        val proc =
                if (arguments.isEmpty())
                    Runtime.getRuntime().exec("${CompilerArgs.pathToKotlincJS} $path " +
                            "-libraries ${CompilerArgs.pathToJsKotlinLib} -output $newPath\n")
                else
                    Runtime.getRuntime().exec("${CompilerArgs.pathToKotlincJS} $path " +
                            "$arguments -libraries ${CompilerArgs.pathToJsKotlinLib} -output $newPath\n")
        try {
            while (proc.waitFor() != 0) {
            }
        } catch (e: IllegalThreadStateException) {
            return CompilingResult(-1, "")
        }
        val status = proc.readInputAndErrorStreams()
        while (proc.isAlive) {
            proc.destroyForcibly()
        }
        //proc.destroy()
        val isSuccess = analyzeErrorMessage(status)
        //println("success = $isSuccess")
        return if (isSuccess) {
            val oldStr = FileReader(File(newPath)).readText()
            val newStr = "const kotlin = require(\"${CompilerArgs.pathToJsKotlinLib}/kotlin.js\");\n\n$oldStr"
            val fw = FileWriter(newPath, false)
            val bw = BufferedWriter(fw)
            bw.write(newStr)
            bw.close()
            CompilingResult(0, newPath)
        } else {
            CompilingResult(-1, "")
        }
    }

    private fun analyzeErrorMessage(msg: String): Boolean = !msg.split("\n").any { it.contains(": error:") }

}