package com.stepanov.reduktor.executor.backends

import com.stepanov.reduktor.executor.CompilerArgs
import com.stepanov.reduktor.executor.KotlincInvokeStatus
import org.apache.commons.io.FileUtils
import org.jetbrains.kotlin.cli.common.arguments.K2JVMCompilerArguments
import org.jetbrains.kotlin.cli.common.messages.CompilerMessageLocation
import org.jetbrains.kotlin.cli.common.messages.CompilerMessageSeverity
import org.jetbrains.kotlin.cli.common.messages.MessageCollector
import org.jetbrains.kotlin.cli.jvm.K2JVMCompiler
import org.jetbrains.kotlin.config.IncrementalCompilation
import org.jetbrains.kotlin.config.Services
import java.io.File
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeoutException

class JVMBackend(private val arguments: String) : CommonBackend {

    override fun tryToCompile(path: String): KotlincInvokeStatus {
        val threadPool = Executors.newCachedThreadPool()
        val trashDir = "tmp/trash/"
        //Clean dir
        FileUtils.cleanDirectory(File(trashDir))

        val args =
                if (arguments.isEmpty())
                    "$path -d $trashDir".split(" ")
                else
                    "$path -d $trashDir $arguments".split(" ")
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

        val msgCollector = object : MessageCollector {
            var hasException = false
            var hasCompileError = false
            var crashMessages = mutableListOf<String>()
            var compileErrorMessages = mutableListOf<String>()

            override fun clear() {
                hasException = false
                hasCompileError = false
                crashMessages.clear()
                compileErrorMessages.clear()
            }

            override fun hasErrors(): Boolean {
                return hasException
            }

            override fun report(severity: CompilerMessageSeverity, message: String, location: CompilerMessageLocation?) {
                if (severity == CompilerMessageSeverity.EXCEPTION) {
                    hasException = true
                    crashMessages.add(message)
                }
                if (severity == CompilerMessageSeverity.ERROR) {
                    compileErrorMessages.add(message)
                    hasCompileError = true
                }
            }
        }

        msgCollector.clear()


        val futureExitCode = threadPool.submit {
            compiler.exec(msgCollector, services, compilerArgs)
        }
        var hasTimeout = false
        if (!CompilerArgs.isProject) {
            try {
                futureExitCode.get(10L, TimeUnit.SECONDS)
            } catch (ex: TimeoutException) {
                hasTimeout = true
            }
        } else {
            while (!futureExitCode.isDone) {
            }
        }

        return KotlincInvokeStatus(msgCollector.crashMessages.joinToString("\n") +
                msgCollector.compileErrorMessages.joinToString("\n"),
                !msgCollector.hasCompileError,
                msgCollector.hasException,
                hasTimeout)
    }

}