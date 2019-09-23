package com.stepanov.bbf.executor

import org.jetbrains.kotlin.cli.common.messages.CompilerMessageLocation
import org.jetbrains.kotlin.cli.common.messages.CompilerMessageSeverity
import org.jetbrains.kotlin.cli.common.messages.MessageCollector
import org.jetbrains.kotlin.psi.KtFile
import com.stepanov.bbf.util.Stream
import com.stepanov.bbf.util.readStream
import com.stepanov.reduktor.executor.KotlincInvokeStatus
import java.io.BufferedWriter
import java.io.File
import java.io.FileWriter
import java.util.concurrent.TimeUnit

enum class CompilerType {
    JVM, JS, NATIVE
}

data class CompilingResult(val status: Int, val pathToCompiled: String)

abstract class CommonCompiler {

    abstract fun checkCompiling(pathToFile: String): Boolean
    abstract fun getErrorMessage(pathToFile: String): String
    abstract fun compile(path: String): CompilingResult
    abstract fun tryToCompile(pathToFile: String): KotlincInvokeStatus
    abstract fun isCompilerBug(pathToFile: String): Boolean
    abstract val compilerInfo: String
    abstract fun exec(path: String): String


    fun compile(file: KtFile): CompilingResult = compile(file.name)
    fun compileText(text: String): CompilingResult {
        val writer = BufferedWriter(FileWriter(CompilerArgs.pathToTmpFile))
        writer.write(text)
        writer.close()
        val res = compile(CompilerArgs.pathToTmpFile)
        File(CompilerArgs.pathToTmpFile).delete()
        return res
    }

    fun getErrorMessageForText(text: String): String {
        val writer = BufferedWriter(FileWriter(CompilerArgs.pathToTmpFile))
        writer.write(text)
        writer.close()
        return getErrorMessage(CompilerArgs.pathToTmpFile)
    }

    fun checkCompilingText(text: String): Boolean {
        return if (!text.contains("fun main(")) {
            val writer = BufferedWriter(FileWriter(CompilerArgs.pathToTmpFile))
            writer.write(text)
            writer.write("\nfun main(args: Array<String>) {}")
            writer.close()
            val res = checkCompiling(CompilerArgs.pathToTmpFile)
            //Save old text back
            val oldTextWriter = BufferedWriter(FileWriter(CompilerArgs.pathToTmpFile))
            oldTextWriter.write(text)
            oldTextWriter.close()
            res
        } else {
            val writer = BufferedWriter(FileWriter(CompilerArgs.pathToTmpFile))
            writer.write(text)
            writer.close()
            checkCompiling(CompilerArgs.pathToTmpFile)
        }
    }

//    fun exec(path: String, type: CompilerType, streamType: Stream = Stream.INPUT): String {
//        val proc = when (type) {
//            CompilerType.JVM -> ProcessBuilder("/bin/bash", "-c", "java -jar $path").start()
//            CompilerType.JS -> ProcessBuilder("/bin/bash", "-c", "node $path").start()
//            CompilerType.NATIVE -> ProcessBuilder("/bin/bash", "-c", path).start()
//        }
//        try {
//
//            val a = proc.waitFor(5L, TimeUnit.SECONDS)
//            if (!a) {
//                while (proc.isAlive) proc.destroyForcibly()
//                return ""
//            }
//        } catch (e: IllegalThreadStateException) {
//            println("exit value = ${proc.exitValue()}")
//        }
//        val result = proc.readStream(streamType)
////        val error = proc.readStream(Stream.ERROR)
////        println(error)
//        while (proc.isAlive) proc.destroyForcibly()
//        return result
//    }

    override fun toString(): String = compilerInfo
}

