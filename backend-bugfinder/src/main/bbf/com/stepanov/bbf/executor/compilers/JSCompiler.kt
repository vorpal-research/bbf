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
import java.lang.Exception
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeoutException

class JSCompiler(private val arguments: String = "") : CommonCompiler() {

    override val compilerInfo: String
        get() = "JS $arguments"

    override val pathToCompiled: String
        get() = "tmp/tmp.js"

    override fun getErrorMessage(pathToFile: String): String = tryToCompile(pathToFile).combinedOutput

    override fun checkCompiling(pathToFile: String): Boolean {
        val status = tryToCompile(pathToFile)
        return !MsgCollector.hasCompileError && !status.hasTimeout && !MsgCollector.hasException
    }

    override fun isCompilerBug(pathToFile: String) =
            tryToCompile(pathToFile).hasException

    override fun tryToCompile(pathToFile: String): KotlincInvokeStatus {
        val tmpPath = "tmp/tmp.js"
        File(tmpPath).delete()
        MsgCollector.clear()
        val args =
                if (arguments.isEmpty())
                    "$pathToFile -libraries ${CompilerArgs.pathToJsKotlinLib} -output $tmpPath".split(" ")
                else
                    "$pathToFile $arguments -libraries ${CompilerArgs.pathToJsKotlinLib} -output $tmpPath".split(" ")
//        val args = ("$pathToFile -libraries ${CompilerArgs.pathToJsKotlinLib} " +
//                "-output $tmpPath").split(" ")
        val compiler = K2JSCompiler()
        val compilerArgs = K2JSCompilerArguments().apply { K2JSCompiler().parseArguments(args.toTypedArray(), this) }
        compilerArgs.kotlinHome = CompilerArgs.kotlinHome
        val services = Services.EMPTY
        val threadPool = Executors.newCachedThreadPool()
        val futureExitCode = threadPool.submit {
            compiler.exec(MsgCollector, services, compilerArgs)
        }
        var hasTimeout = false
        try {
            futureExitCode.get(10L, TimeUnit.SECONDS)
        } catch (ex: TimeoutException) {
            hasTimeout = true
            futureExitCode.cancel(true)
        }
        val status = KotlincInvokeStatus(MsgCollector.crashMessages.joinToString("\n") +
                MsgCollector.compileErrorMessages.joinToString("\n"),
                !MsgCollector.hasCompileError,
                MsgCollector.hasException,
                hasTimeout)
        File(tmpPath).delete()
        return status
    }

    override fun exec(path: String, streamType: Stream): String = commonExec("node $path", streamType)

    override fun compile(path: String): CompilingResult {
        val command =
                if (arguments.isEmpty())
                    "${CompilerArgs.pathToKotlincJS} $path -libraries ${CompilerArgs.pathToJsKotlinLib} -output $pathToCompiled\n"
                else
                    "${CompilerArgs.pathToKotlincJS} $path $arguments -libraries ${CompilerArgs.pathToJsKotlinLib} -output $pathToCompiled\n"
        val status: String
        try {
            status = commonExec(command, Stream.BOTH)
        } catch (e: Exception) {
            return CompilingResult(-1, "")
        }
        val isSuccess = analyzeErrorMessage(status)
        return if (isSuccess) {
            val oldStr = FileReader(File(pathToCompiled)).readText()
            val newStr = "const kotlin = require(\"${CompilerArgs.pathToJsKotlinLib}/kotlin.js\");\n\n$oldStr"
            val fw = FileWriter(pathToCompiled, false)
            val bw = BufferedWriter(fw)
            bw.write(newStr)
            bw.close()
            CompilingResult(0, pathToCompiled)
        } else {
            CompilingResult(-1, "")
        }
    }
    private fun analyzeErrorMessage(msg: String): Boolean = !msg.split("\n").any { it.contains(": error:") }

}