package com.stepanov.reduktor.executor

object CompilerArgs {
    var jdkHome = System.getenv("JAVA_HOME")
    var jvmTarget = "1.8"
    var classpath = ""
    var projectDir = ""
    var pathToFileWithBug = ""
    var isProject = false
    var isCompilerError = true
    const val pathToReduKtor = "reduKtor"
    const val pathToJsKotlinLib = "lib/"
}