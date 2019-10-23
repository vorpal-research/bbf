package com.stepanov.bbf.executor

import com.stepanov.reduktor.executor.CompilerArgs
import java.io.File
import java.util.*

object CompilerArgs {

    private val file: File = File("bbf.conf")

    fun getPropValue(name: String): String? {
        val props = Properties()
        props.load(file.inputStream())
        return props.getProperty(name)
    }

    fun getPropValueWithoutQuotes(name: String): String {
        val props = Properties()
        props.load(file.inputStream())
        val prop = props.getProperty(name) ?: throw IllegalArgumentException("Cannot init $name property")
        val res = prop.drop(1).dropLast(1)
        return res
    }

    fun getPropAsBoolean(name: String): Boolean = getPropValue(name)?.toBoolean()
            ?: throw IllegalArgumentException("Cannot init $name property")

    val baseDir = getPropValueWithoutQuotes("MUTATING_DIR")

    //PATHS TO COMPILERS
    val pathToKotlinc = getPropValueWithoutQuotes("KOTLINC")
    val pathToKotlincJS = getPropValueWithoutQuotes("KOTLINCJS")
    val pathToJsKotlinLib = "${System.getProperty("user.dir")}/tmp/lib/"
    val pathToTmpFile = getPropValueWithoutQuotes("TMPFILE")
    val kotlinHome = getPropValueWithoutQuotes("KOTLIN_HOME")

    //RESULT
    val resultsDir = getPropValueWithoutQuotes("RESULTS")

    //MUTATED BUGS
    val shouldSaveCompilerBugs = getPropAsBoolean("SAVE_BACKEND_EXCEPTIONS")
    val shouldReduceCompilerBugs = getPropAsBoolean("REDUCE_BACKEND_EXCEPTIONS")
    val shouldSaveMutatedFiles = getPropAsBoolean("SAVE_MUTATED_FILES")
    val shouldSaveCompileDiff = getPropAsBoolean("SAVE_COMPILER_DIFFS")
    val shouldReduceDiffBehavior = getPropAsBoolean("REDUCE_DIFF_BEHAVIOR")

    //REDUKTOR
    val shouldFilterDuplicateCompilerBugs = getPropAsBoolean("FILTER_DUPLICATES")

    //JAVA
    val jdkHome = System.getenv("JAVA_HOME")
    val jvmTarget = "1.8"
    val classpath = ""
}