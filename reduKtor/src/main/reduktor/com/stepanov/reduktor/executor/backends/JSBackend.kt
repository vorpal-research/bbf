package com.stepanov.reduktor.executor.backends

import com.stepanov.reduktor.executor.CompilerArgs
import com.stepanov.reduktor.executor.KotlincInvokeStatus
import com.stepanov.reduktor.util.MsgCollector
import org.jetbrains.kotlin.cli.common.arguments.K2JSCompilerArguments
import org.jetbrains.kotlin.cli.js.K2JSCompiler
import org.jetbrains.kotlin.config.Services
import java.io.File
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeoutException

class JSBackend(private val arguments: String) : CommonBackend {
    override fun tryToCompile(path: String): KotlincInvokeStatus {
        val tmpPath = "/tmp/tmp.js"
        File(tmpPath).delete()
        val args =
            if (arguments.isEmpty())
                "$path -libraries ${CompilerArgs.pathToJsKotlinLib} -output $tmpPath".split(" ")
            else
                "$path -libraries ${CompilerArgs.pathToJsKotlinLib} -output $tmpPath $arguments".split(" ")
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
        return KotlincInvokeStatus(MsgCollector.crashMessages.joinToString("\n") +
                MsgCollector.compileErrorMessages.joinToString("\n"),
                !MsgCollector.hasCompileError,
                MsgCollector.hasException,
                hasTimeout)
    }
}