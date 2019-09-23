package com.stepanov.reduktor.util

import com.stepanov.reduktor.executor.CommonCompilerCrashTestChecker
import com.stepanov.reduktor.executor.backends.CommonBackend
import org.bitbucket.cowwoc.diffmatchpatch.DiffMatchPatch
import java.io.BufferedWriter
import java.io.File
import java.io.FileWriter

class FilterDuplcatesCompilerErrors(private val files: List<File>, private val backend: CommonBackend) {

    fun filter() {
        val errorMessages = mutableMapOf<File, String>()
        for ((i, f) in files.withIndex()) {
            println("i = $i name = ${f.name}")
            val checker = CommonCompilerCrashTestChecker(backend)
            checker.init(f.absolutePath)
            val error = checker.getErrorInfo()
            if (error.errorMessage.isEmpty() || error.errorMessage.contains("Unresolved"))
                continue
            errorMessages[f] = error.errorMessage
        }
        var index = 0
        while (index != errorMessages.size - 1) {
            println("ind = $index")
            val iterator = errorMessages.iterator()
            for (ind in 0 until index)
                iterator.next()
            val curFile = iterator.next()
            while (iterator.hasNext()) {
                val anotherFile = iterator.next()
                val st1 = getStacktrace2(curFile.value)
                val st2 = getStacktrace2(anotherFile.value)
                val errsMatchingKoef =
                        when {
                            st1.isEmpty() || st2.isEmpty() -> checkErrsMatching(curFile.value, anotherFile.value) < 0.9
                            else -> checkErrsMatching(st1, st2) < 0.25
                        }
                println("Errs Matching = $errsMatchingKoef ${curFile.key.name} ${anotherFile.key.name}")
                if (errsMatchingKoef) {
                    println("removing ${anotherFile.key.name}")
                    iterator.remove()
                }

            }
            ++index
        }
        println("SIZE = ${errorMessages.size}")
        errorMessages.forEach { println("FILE = ${it.key.name}") }
        errorMessages.forEach {
            val oldName = it.key.absolutePath
            val newName = oldName.dropLastWhile { it != '/' } + "/unique_" + oldName.split('/').last()
            BufferedWriter(FileWriter(File(newName))).apply { write(File(oldName).readText()); close() }
        }
    }

    private fun getStacktrace(msg: String): String {
        val firstIndex = msg.indexOf("\nThe root cause was thrown at:")
        val lastIndex = msg.indexOf("Caused by:", firstIndex)
        if (firstIndex == -1 || lastIndex == -1) return ""
        return msg.substring(firstIndex, lastIndex)
    }

    private fun getStacktrace2(msg: String): String {
        return msg.split("\n").map { it.trim() }.filter { it.startsWith("at ") }.joinToString("\n")
    }

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

    private val patch = DiffMatchPatch()
}
