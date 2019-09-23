//package com.stepanov.bbf.executor.compilers
//
//import com.stepanov.bbf.executor.*
//import com.stepanov.bbf.util.Stream
//import org.jetbrains.kotlin.cli.bc.K2Native
//import org.jetbrains.kotlin.cli.bc.K2NativeCompilerArguments
//import org.jetbrains.kotlin.cli.common.ExitCode
//import org.jetbrains.kotlin.config.Services
//import com.stepanov.bbf.util.readInputAndErrorStreams
//import com.stepanov.bbf.util.readStream
//import com.stepanov.reduktor.executor.KotlincInvokeStatus
//import com.stepanov.reduktor.util.MsgCollector
//import java.io.*
//import java.util.concurrent.Executors
//import java.util.concurrent.TimeUnit
//import java.util.concurrent.TimeoutException
//
//
//class NativeCompiler(private val args: String = "") : CommonCompiler() {
//
//    override val compilerInfo: String
//        get() = "Native v.1.3.20 $args"
//
//    override fun getErrorMessage(pathToFile: String): String {
//        val textBackup = File(pathToFile).readText()
//        val writer = BufferedWriter(FileWriter(pathToFile))
//        writer.write(textBackup)
//
//        //Add main if we need (without main Native cant compile file)
//        if (!textBackup.contains("fun main")) {
//            writer.write("\nfun main(args: Array<String>) {}")
//        }
//        writer.close()
//        val newPath = "tmp/tmp.kexe"
//        val proc = Runtime.getRuntime().exec("${CompilerArgs.pathToNative}/kotlin-native/dist/bin/kotlinc-native $pathToFile -o $newPath\n")
//        var status = ""
//        while (proc.waitFor() != 0) {
//            status += proc.readInputAndErrorStreams()
//            if (status != "") break
//        }
//
//        while (proc.isAlive) {
//            proc.destroyForcibly()
//        }
//        File(pathToFile).writeText(textBackup)
//        return status
//    }
//
//    override fun checkCompiling(pathToFile: String): Boolean = tryToCompile1(pathToFile).second
//
//    override fun isCompilerBug(pathToFile: String): Boolean {
//        val st = tryToCompile1(pathToFile)
//        return st.first.combinedOutput.isEmpty() && !st.second
//    }
//
//
//    override fun compile(path: String): CompilingResult {
//        val newPath = "tmp/tmp.kexe"
//        val proc = Runtime.getRuntime().exec("${CompilerArgs.pathToNative}/kotlin-native/dist/bin/kotlinc-native $path -o $newPath\n")
//        var status = ""
//        try {
//            while (proc.waitFor() != 0) {
//                status += proc.readInputAndErrorStreams()
//                if (status != "") break
//            }
//        } catch (e: IllegalThreadStateException) {
//            return CompilingResult(-1, "")
//        }
//        while (proc.isAlive) {
//            proc.destroyForcibly()
//        }
//        return if (analyzeErrorMessage(status))
//            CompilingResult(0, newPath)
//        else
//            CompilingResult(-1, "")
//    }
//
//    override fun tryToCompile(pathToFile: String): KotlincInvokeStatus = tryToCompile1(pathToFile).first
//
//
//    private fun tryToCompile1(pathToFile: String): Pair<KotlincInvokeStatus, Boolean> {
//        val text = File(pathToFile).readText()
//        val writer = BufferedWriter(FileWriter(CompilerArgs.pathToTmpFile))
//        writer.write(text)
//
//        //Add main if we need (without main Native cant compile file)
//        if (!text.contains("fun main")) {
//            writer.write("\nfun main(args: Array<String>) {}")
//        }
//        writer.close()
//
//        val threadPool = Executors.newCachedThreadPool()
//        val args = "${CompilerArgs.pathToTmpFile} -o /tmp/tmp.kexe".split(" ")
//        val compiler = K2Native()
//        val compilerArgs = K2NativeCompilerArguments().apply { K2Native().parseArguments(args.toTypedArray(), this) }
//        MsgCollector.clear()
//
//        val services = Services.EMPTY
//
//        var exitCode: ExitCode = ExitCode.INTERNAL_ERROR
//        val futureExitCode = threadPool.submit {
//            exitCode = compiler.execImpl(MsgCollector, services, compilerArgs)
//        }
//        var hasTimeout = false
//        try {
//            futureExitCode.get(10L, TimeUnit.SECONDS)
//        } catch (ex: TimeoutException) {
//            hasTimeout = true
//            while (!futureExitCode.isCancelled)
//                futureExitCode.cancel(true)
//        }
//        val isSuccess = exitCode == ExitCode.OK
//
//        val status = KotlincInvokeStatus(MsgCollector.crashMessages.joinToString("\n") +
//                MsgCollector.compileErrorMessages.joinToString("\n"),
//                !MsgCollector.hasCompileError,
//                MsgCollector.hasException,
//                hasTimeout)
//
//        return status to isSuccess
//    }
//
//    //super.exec(path, CompilerType.NATIVE, Stream.INPUT)
//    override fun exec(path: String): String {
//        val proc = ProcessBuilder("/bin/bash", "-c", path).start()
//        try {
//            val a = proc.waitFor(5L, TimeUnit.SECONDS)
//            if (!a) {
//                while (proc.isAlive) proc.destroyForcibly()
//                return ""
//            }
//        } catch (e: IllegalThreadStateException) {
//            println("exit value = ${proc.exitValue()}")
//        }
//        var result = proc.readStream(Stream.INPUT)
//        while (proc.isAlive) proc.destroyForcibly()
//        //Native backend displays exception in input stream (we need fo filter it)
//        val excIndex = result.indexOf("Uncaught ")
//        if (excIndex != -1) {
//            result = result.substring(0, excIndex)
//        }
//        return result
//    }
//
//
//
//
//    private fun analyzeErrorMessage(msg: String): Boolean = !msg.split("\n").any { it.contains("error:") }
//}