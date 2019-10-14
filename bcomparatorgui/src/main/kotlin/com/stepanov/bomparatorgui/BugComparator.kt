package com.stepanov.bomparatorgui

import com.stepanov.bbf.executor.CommonCompiler
import com.stepanov.bbf.executor.CompilerArgs
import com.stepanov.bbf.util.FilterDuplcatesCompilerErrors
import com.stepanov.bbf.util.Stream
import org.bitbucket.cowwoc.diffmatchpatch.DiffMatchPatch
import java.io.BufferedWriter
import java.io.File
import java.io.FileWriter
import java.util.*

object BugComparator {

    fun compare(path1: String, path2: String, compiler: CommonCompiler): Pair<LinkedList<DiffMatchPatch.Diff>?, Pair<Double, Double>> {
        val text1 = compiler.getErrorMessage(path1)
        val text2 = compiler.getErrorMessage(path2)
        val patch = DiffMatchPatch()
        val res = patch.diffMain(text1, text2)
        return res to FilterDuplcatesCompilerErrors.getK(path1, path2, compiler)
    }


    fun compileAndExecute1(pathToFile: String, comp: CommonCompiler): String {
        val status = comp.compile(pathToFile)
        if (status.status == -1)
            return ""
        return comp.exec(status.pathToCompiled, Stream.BOTH)
    }


    fun compileAndExecute(text: String, compiler: CommonCompiler): String {
        var resText = text
        if (!text.contains("fun main(")) {
            resText += "fun main(args: Array<String>) {\n" +
                    "    println(box())\n" +
                    "}"
        }
        val writer = BufferedWriter(FileWriter(CompilerArgs.pathToTmpFile))
        writer.write(resText)
        writer.close()
        val res = compileAndExecute1(CompilerArgs.pathToTmpFile, compiler)
        File(CompilerArgs.pathToTmpFile).delete()
        return res
    }


    fun compareDiffBehavior(path: String, compiler1: CommonCompiler, compiler2: CommonCompiler):
            Pair<String, LinkedList<DiffMatchPatch.Diff>?> {
        println("EXECUTING = ${compiler1.compilerInfo} $path")
        val text1 = compileAndExecute(File(path).readText(), compiler1).trim()
        val output1 = BothStream(text1)
        val text2 = compileAndExecute(File(path).readText(), compiler2).trim()
        val output2 = BothStream(text2)
        println("OUTPUT1= $output1")
        println("OUTPUT2= $output2")
        return when {
            output1.inputStream.isEmpty() && output2.inputStream.isEmpty() ->
                "" to DiffMatchPatch().diffMain(output1.errorStream, output2.errorStream)
            output1.inputStream.isNotEmpty() && output2.inputStream.isEmpty() ->
                "${output1.inputStream}\nSECERROR:\n${output2.errorStream}" to null
            output1.inputStream.isEmpty() && output2.inputStream.isNotEmpty() ->
                "${output1.errorStream}\nSECOUTPUT:\n${output2.inputStream}" to null
            else ->
                "" to DiffMatchPatch().diffMain(output1.inputStream, output2.inputStream)
        }
    }

}

data class BothStream(val inputStream: String, val errorStream: String) {

    constructor(text: String) :
            this(text.substringAfter("OUTPUTSTREAM:").substringBefore("ERRORSTREAM:").trim(),
                    text.substringAfter("ERRORSTREAM:").trim())

}