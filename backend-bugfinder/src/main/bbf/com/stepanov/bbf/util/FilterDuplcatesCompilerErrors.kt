package com.stepanov.bbf.util

import com.stepanov.bbf.executor.CommonCompiler
import org.apache.log4j.Logger
import org.bitbucket.cowwoc.diffmatchpatch.DiffMatchPatch
import java.io.File

//TODO need to be rewrited
object FilterDuplcatesCompilerErrors {

    fun filter(files: List<File>, comp: CommonCompiler) {
        val errorMessages = mutableMapOf<File, String>()
        for ((i, f) in files.withIndex()) {
            println("i = $i name = ${f.name}")
            errorMessages[f] = comp.getErrorMessage(f.absolutePath)
        }
        var index = 0
        while (index != errorMessages.size - 1) {
            println("ind = $index")
            val iterator = errorMessages.iterator()
            for (ind in 0..index)
                iterator.next()
            val curFile = iterator.next()
            while (iterator.hasNext()) {
                val anotherFile = iterator.next()
//                val errsMatchingKoef = checkErrsMatching(curFile.value, anotherFile.value)
                val stMatchingKoef = checkErrsMatching(getStacktrace2(curFile.value), getStacktrace2(anotherFile.value))
//                println("Errs Matching = $errsMatchingKoef ${curFile.key.name} ${anotherFile.key.name}")
                println("Stacks Matching = $stMatchingKoef ${curFile.key.name} ${anotherFile.key.name}\n\n")
                if (/*getStacktrace(curFile.value) == getStacktrace(anotherFile.value) || errsMatchingKoef < 0.5*/ stMatchingKoef < 0.2) {
                    println("removing ${anotherFile.key.name} - duplicate of ${curFile.key.name}")
                    iterator.remove()
                }

            }
            ++index
        }
        println("SIZE = ${errorMessages.size}")
        errorMessages.forEach { println("FILE = ${it.key.name}") }
//        errorMessages.forEach {
//            val oldName = it.key.absolutePath
//            val newName = oldName.dropLastWhile { it != '/' } + "/unique_" + oldName.split('/').last()
//            BufferedWriter(FileWriter(File(newName))).apply { write(File(oldName).readText()); close() }
//        }
    }

    fun isSameErrs(path1: String, path2: String, compiler: CommonCompiler): Boolean {
        val text = File(path1).readText()

        val errorMsg = compiler.getErrorMessageForText(text)
        val errorMsgForFile = compiler.getErrorMessage(path2)

        return checkErrsMatching(getStacktrace2(errorMsg), getStacktrace2(errorMsgForFile)) < 0.2
    }

    fun simpleIsSameErrs(path1: String, path2: String, compiler: CommonCompiler): Boolean {
        val text = File(path1).readText()
        val errorMsg = compiler.getErrorMessageForText(text)
        val errorMsgForFile = compiler.getErrorMessage(path2)
        val k = newCheckErrsMatching(errorMsg, errorMsgForFile)
        val kStacktraces = newCheckErrsMatching(getStacktrace2(errorMsg), getStacktrace2(errorMsgForFile))
        log.debug("Comparing $path1 $path2 $k stacks: $kStacktraces")
        if (k > 0.49 || kStacktraces == 0.5)
            log.debug("$path1 and $path2 are duplicates!!!")
        return k > 0.49 || kStacktraces == 0.5
    }

    fun simpleIsSameErrsWithStacktraces(path1: String, path2: String, compiler: CommonCompiler): Boolean {
        val text = File(path1).readText()

        val errorMsg = compiler.getErrorMessageForText(text)
        val errorMsgForFile = compiler.getErrorMessage(path2)

        val k = newCheckErrsMatching(getStacktrace2(errorMsg), getStacktrace2(errorMsgForFile))
        println("K = $k")
        log.debug("Comparing $path1 $path2 $k")
        return k > 0.49
    }

    fun getK(path1: String, path2: String, comp: CommonCompiler): Pair<Double, Double> {
        val text = File(path1).readText()

        val errorMsg = comp.getErrorMessageForText(text)
        val errorMsgForFile = comp.getErrorMessage(path2)

        return newCheckErrsMatching(errorMsg, errorMsgForFile) to
                newCheckErrsMatching(getStacktrace2(errorMsg), getStacktrace2(errorMsgForFile))
    }

    fun haveDuplicatesErrors(path: String, dir: String, compiler: CommonCompiler): Boolean =
            File(dir).listFiles().filter { it.path.endsWith(".kt") }.any { isSameErrs(path, it.absolutePath, compiler) }

    fun simpleHaveDuplicatesErrors(path: String, dir: String, compiler: CommonCompiler): Boolean =
            File(dir).listFiles().filter { it.path.endsWith(".kt") }.any { simpleIsSameErrs(path, it.absolutePath, compiler) }

    fun getListOfDuplicates(path: String, dir: String, compiler: CommonCompiler): List<String> =
            File(dir).listFiles().filter { isSameErrs(path, it.absolutePath, compiler) }.map { it.absolutePath }
//    {
//        val text = File(path).readText()
//        val comp = when (compiler) {
//            CompilerType.JVM -> JVMCompiler()
//            CompilerType.JS -> JSCompiler()
//            CompilerType.NATIVE -> NativeCompiler()
//        }
//
//        val errorMsg = comp.getErrorMessageForText(text)
//        for (f in File(dir).listFiles()) {
//            val errorMsgForFile = comp.getErrorMessage(f.path)
//
//            if (checkErrsMatching(getStacktrace2(errorMsg), getStacktrace2(errorMsgForFile)) < 0.2) {
//                return true
//            }
//        }
//
//        return false
//    }


    private fun getStacktrace(msg: String): String {
        val firstIndex = msg.indexOf("\nThe root cause was thrown at:")
        val lastIndex = msg.indexOf("Caused by:", firstIndex)
        if (firstIndex == -1 || lastIndex == -1) return ""
        val res = msg.substring(firstIndex, lastIndex)
        return res
    }

    private fun getStacktrace2(msg: String): String =
            msg
                    .split("Cause:")
                    .last()
                    .split("\n")
                    .map { it.trim() }
                    .filter { it.startsWith("at ") }
                    .joinToString("\n")

    private fun checkErrsMatching(a: String, b: String): Double {
        val diffs = patch.diffMain(a, b)
        var sameNum = 0
        var difNum = 0
        for (dif in diffs) {
            when (dif.operation.name) {
                "EQUAL" -> sameNum += dif.text.length
                else -> difNum += dif.text.length
            }
        }
        return if (sameNum == 0) Double.MAX_VALUE else difNum.toDouble() / sameNum.toDouble()
    }

    fun newCheckErrsMatching(a: String, b: String): Double {
        if (a.length + b.length == 0) return Double.MAX_VALUE
        val diffs = patch.diffMain(a, b)
        var sameNum = 0
        var difNum = 0
        for (dif in diffs) {
            when (dif.operation.name) {
                "EQUAL" -> sameNum += dif.text.length
                else -> difNum += dif.text.length
            }
        }
        return if (sameNum == 0) Double.MIN_VALUE else sameNum.toDouble() / (a.length + b.length)
    }

    private val patch = DiffMatchPatch()
    private val log = Logger.getLogger("mutatorLogger")
}
