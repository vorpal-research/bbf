package com.stepanov.bbf.executor.compilers

import com.stepanov.bbf.executor.*
import com.stepanov.bbf.util.Stream
import org.apache.log4j.Logger
import org.jetbrains.kotlin.cli.common.arguments.K2JVMCompilerArguments
import org.jetbrains.kotlin.cli.jvm.K2JVMCompiler
import org.jetbrains.kotlin.config.IncrementalCompilation
import org.jetbrains.kotlin.config.Services
import com.stepanov.bbf.util.readInputAndErrorStreams
import com.stepanov.bbf.util.readStream
import com.stepanov.reduktor.executor.KotlincInvokeStatus
import com.stepanov.reduktor.executor.error.ErrorType
import com.stepanov.reduktor.executor.error.Error
import com.stepanov.reduktor.util.MsgCollector
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeoutException

class JVMCompiler(private val arguments: String = "") : CommonCompiler() {
    override val compilerInfo: String
        get() = "JVM $arguments"


    override fun checkCompiling(pathToFile: String): Boolean {
        val status = tryToCompile(pathToFile)
        return !MsgCollector.hasCompileError && !status.hasTimeout && !MsgCollector.hasException
    }

    override fun getErrorMessage(pathToFile: String): String = tryToCompile(pathToFile).combinedOutput
    override fun isCompilerBug(pathToFile: String): Boolean =
            tryToCompile(pathToFile).hasException
    //Error(tryToCompile(pathToFile).combinedOutput).type != ErrorType.UNKNOWN


    override fun compile(path: String): CompilingResult {
        val kotlinc = CompilerArgs.pathToKotlinc
        val newPath = "tmp/lol.jar"
        val proc =
                if (arguments.isEmpty())
                    Runtime.getRuntime().exec("$kotlinc $path -include-runtime -d $newPath")
                else
                    Runtime.getRuntime().exec("$kotlinc $path -include-runtime $arguments -d $newPath")
        try {
            val a = proc.waitFor(5L, TimeUnit.SECONDS)
            if (!a) {
                return CompilingResult(-1, "")
            }
        } catch (e: IllegalThreadStateException) {
            return CompilingResult(-1, "")
        }
        val status = proc.readInputAndErrorStreams()
        //println("JVM Error = $status")
        //proc.destroy()
        while (proc.isAlive) proc.destroyForcibly()
        return if (analyzeErrorMessage(status)) CompilingResult(0, newPath) else CompilingResult(-1, "")
    }

    override fun tryToCompile(pathToFile: String): KotlincInvokeStatus {
        val threadPool = Executors.newCachedThreadPool()
        val args =
                if (arguments.isEmpty())
                    "$pathToFile -cp ${System.getProperty("java.class.path")} -d trash/".split(" ")
                else
                    "$pathToFile -cp ${System.getProperty("java.class.path")} $arguments -d trash/".split(" ")
        val compiler = K2JVMCompiler()
        val compilerArgs = K2JVMCompilerArguments().apply { K2JVMCompiler().parseArguments(args.toTypedArray(), this) }
        if (CompilerArgs.classpath.isNotEmpty())
            compilerArgs.classpath = CompilerArgs.classpath
        compilerArgs.jdkHome = CompilerArgs.jdkHome
        compilerArgs.jvmTarget = CompilerArgs.jvmTarget
        IncrementalCompilation.setIsEnabledForJvm(true)

        val services = Services.EMPTY
        MsgCollector.clear()
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

        val status = KotlincInvokeStatus(MsgCollector.crashMessages.joinToString("\n") +
                MsgCollector.compileErrorMessages.joinToString("\n"),
                !MsgCollector.hasCompileError,
                MsgCollector.hasException,
                hasTimeout)

        return status
    }

    //super.exec(path, CompilerType.JVM, Stream.INPUT)
    override fun exec(path: String): String {
        val proc = ProcessBuilder("/bin/bash", "-c", "java -jar $path").start()
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

    private fun analyzeErrorMessage(msg: String): Boolean = !msg.split("\n").any { it.contains(": error:") }

    private val log = Logger.getLogger("compilerErrorsLog")
}