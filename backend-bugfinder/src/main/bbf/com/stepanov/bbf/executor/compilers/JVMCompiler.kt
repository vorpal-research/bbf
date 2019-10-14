package com.stepanov.bbf.executor.compilers

import com.stepanov.bbf.executor.CommonCompiler
import com.stepanov.bbf.executor.CompilerArgs
import com.stepanov.bbf.executor.CompilingResult
import com.stepanov.bbf.util.Stream
import com.stepanov.reduktor.executor.KotlincInvokeStatus
import com.stepanov.reduktor.util.MsgCollector
import org.apache.commons.io.FileUtils
import org.apache.log4j.Logger
import org.jetbrains.kotlin.cli.common.arguments.K2JVMCompilerArguments
import org.jetbrains.kotlin.cli.jvm.K2JVMCompiler
import org.jetbrains.kotlin.config.IncrementalCompilation
import org.jetbrains.kotlin.config.Services
import java.io.File
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeoutException

class JVMCompiler(private val arguments: String = "") : CommonCompiler() {
    override val compilerInfo: String
        get() = "JVM $arguments"

    override val pathToCompiled: String
        get() = "tmp/tmp.jar"


    override fun checkCompiling(pathToFile: String): Boolean {
        val status = tryToCompile(pathToFile)
        return !MsgCollector.hasCompileError && !status.hasTimeout && !MsgCollector.hasException
    }

    override fun getErrorMessage(pathToFile: String): String = tryToCompile(pathToFile).combinedOutput
    override fun isCompilerBug(pathToFile: String): Boolean =
            tryToCompile(pathToFile).hasException

    override fun compile(path: String): CompilingResult {
        val kotlinc = CompilerArgs.pathToKotlinc
        val command =
                if (arguments.isEmpty())
                    "$kotlinc $path -include-runtime -d $pathToCompiled"
                else
                    "$kotlinc $path -include-runtime $arguments -d $pathToCompiled"
        val status: String
        try {
            status = commonExec(command, Stream.BOTH)
        } catch (e: Exception) {
            return CompilingResult(-1, "")
        }
        return if (analyzeErrorMessage(status)) CompilingResult(0, pathToCompiled) else CompilingResult(-1, "")
    }

    override fun tryToCompile(pathToFile: String): KotlincInvokeStatus {
        val threadPool = Executors.newCachedThreadPool()
        val trashDir = "tmp/trash/"
        //Clean dir
        if (File(trashDir).exists())
            FileUtils.cleanDirectory(File(trashDir))
        val args =
                if (arguments.isEmpty())
                    "$pathToFile -d $trashDir".split(" ")
                else
                    "$pathToFile $arguments -d $trashDir".split(" ")
        val compiler = K2JVMCompiler()
        val compilerArgs = K2JVMCompilerArguments().apply { K2JVMCompiler().parseArguments(args.toTypedArray(), this) }
        if (CompilerArgs.classpath.isNotEmpty())
            compilerArgs.classpath = CompilerArgs.classpath
        else
            compilerArgs.classpath = System.getProperty("java.class.path")
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

        return status
    }

    override fun exec(path: String, streamType: Stream): String = commonExec("java -jar $path", streamType)

    private fun analyzeErrorMessage(msg: String): Boolean = !msg.split("\n").any { it.contains(": error:") }

    private val log = Logger.getLogger("compilerErrorsLog")
}