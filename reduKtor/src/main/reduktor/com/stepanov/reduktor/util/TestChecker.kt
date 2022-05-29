package com.stepanov.reduktor.util

import com.intellij.lang.ASTNode
import org.jetbrains.kotlin.cli.common.arguments.K2JVMCompilerArguments
import org.jetbrains.kotlin.cli.common.messages.CompilerMessageLocation
import org.jetbrains.kotlin.cli.common.messages.CompilerMessageSeverity
import org.jetbrains.kotlin.cli.common.messages.MessageCollector
import java.io.*
import org.jetbrains.kotlin.cli.jvm.K2JVMCompiler
import java.util.concurrent.Executors
import org.jetbrains.kotlin.config.Services
import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeoutException

object TestChecker {

    fun checkTest(tree: List<ASTNode>): Boolean {
        if (tree.isEmpty()) return false
        val oldText = File(pathToFile).bufferedReader().readText()
        var writer = File(pathToFile).bufferedWriter()
        for (el in tree){
            writer.write(el.text)
        }
        writer.close()


        writer = File(pathToFile).bufferedWriter()
        writer.write(oldText)
        writer.close()
        return true
    }

    //Fast check for compiling
    private fun tryToCompile(): Boolean {

        val args = "${pathToFile} -nowarn -cp ${jarFile} -d trash/".split(" ")

        val compiler = K2JVMCompiler()
        val compilerArgs = K2JVMCompilerArguments().apply { K2JVMCompiler().parseArguments(args.toTypedArray(), this) }
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
                    hasCompileError = true
                }
            }

        }

        val futureExitCode = threadPool.submit {
            compiler.exec(msgCollector, services, compilerArgs)
        }

        var hasTimeout = false
        try {
            futureExitCode.get(3L, TimeUnit.MINUTES)
        } catch(ex: TimeoutException) {
            hasTimeout = true
        }
        return !msgCollector.hasCompileError
    }

    //FIXME!!!
    private fun doFormatting(path: String) {
        val p = ProcessBuilder("/bin/bash", "-c", "ktlint -F " + path).start()
    }

    fun init(pathToScript: String, pathToFile: String) {
        TestChecker.pathToScript = pathToScript
        TestChecker.pathToFile = pathToFile
    }

    lateinit var pathToScript: String
    lateinit var pathToFile: String

    private val threadPool = Executors.newCachedThreadPool()
    private val jarFile = Unit::class.java.protectionDomain.codeSource.location.toString()
}