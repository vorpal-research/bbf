package com.stepanov.bbf.executor

import com.stepanov.bbf.util.Stream
import com.stepanov.reduktor.executor.KotlincInvokeStatus
import org.apache.commons.exec.*
import org.jetbrains.kotlin.psi.KtFile
import java.io.BufferedWriter
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileWriter

data class CompilingResult(val status: Int, val pathToCompiled: String)

abstract class CommonCompiler {

    abstract fun checkCompiling(pathToFile: String): Boolean
    abstract fun getErrorMessage(pathToFile: String): String
    abstract fun compile(path: String): CompilingResult
    abstract fun tryToCompile(pathToFile: String): KotlincInvokeStatus
    abstract fun isCompilerBug(pathToFile: String): Boolean
    abstract fun exec(path: String, streamType: Stream = Stream.INPUT): String

    abstract val compilerInfo: String
    abstract val pathToCompiled: String


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
        if (text.trim().isEmpty()) return false
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

    fun commonExec(command: String, streamType: Stream = Stream.INPUT, timeoutSec: Long = 5L): String {
        val cmdLine = CommandLine.parse(command)
        val outputStream = ByteArrayOutputStream()
        val errorStream = ByteArrayOutputStream()
        val executor = DefaultExecutor().also {
            it.watchdog = ExecuteWatchdog(timeoutSec * 1000)
            it.streamHandler = PumpStreamHandler(outputStream, errorStream)
        }
        try {
            executor.execute(cmdLine)
        } catch (e: ExecuteException) {
            executor.watchdog.destroyProcess()
            return outputStream.toString()
        }
        return when (streamType) {
            Stream.INPUT -> outputStream.toString()
            Stream.ERROR -> errorStream.toString()
            Stream.BOTH -> "OUTPUTSTREAM:\n$outputStream ERRORSTREAM:\n$errorStream"
        }
    }


    override fun toString(): String = compilerInfo
}

