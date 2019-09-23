package com.stepanov.reduktor

import com.stepanov.reduktor.executor.CommonCompilerCrashTestChecker
import com.stepanov.reduktor.executor.CompilerArgs
import com.stepanov.reduktor.executor.backends.IR2JVMBackend
import com.stepanov.reduktor.executor.backends.JSBackend
import com.stepanov.reduktor.executor.backends.JVMBackend
import com.stepanov.reduktor.parser.PSICreator
import com.stepanov.reduktor.manager.TransformationManager
import com.stepanov.reduktor.util.ReduKtorProperties
import net.sourceforge.argparse4j.ArgumentParsers
import org.apache.log4j.PropertyConfigurator
import org.jetbrains.kotlin.cli.jvm.K2JVMCompiler
import java.io.File


fun main(args: Array<String>) {
    //Log4j configuration
    PropertyConfigurator.configure("reduKtor/src/main/resources/log4j.properties")
    //Arg parsing
    val parser = ArgumentParsers.newFor("reduKtor").build()
    parser.addArgument("-p", "--path")
            .required(true)
            .help("Path to directory with source files")
            .default = ""
//    parser.addArgument("-t", "--type")
//            .required(true)
//            .choices("project", "file").setDefault("file")
//            .help("Is project?")
//    parser.addArgument("-s", "--save")
//            .required(false)
//            .help("Path to save")
//    parser.addArgument("-cp", "--classpath")
//            .required(false)
//            .help("Path to jar with dependencies")
//    parser.addArgument("-jvm")
//            .required(false)
//            .help("JVM target")
//    parser.addArgument("-jdk")
//            .required(false)
//            .help("JDKHome")
//    parser.addArgument("-а")
//            .required(false)
//            .help("Path to file with bug")
//    val arguments = parser.parseArgs(args)
//    val targetProjectDir = arguments.getString("p")


    //TEMPORARY
//    val debugProjectDir = "/home/stepanov/Kotlin/testProjects/github/kotoed/kotoed-server/src/main"
//    val isProject = true

    val debugProjectDir = "reduKtor/compilerTests"
    val isProject = false
    val classpath = ""
    val pathToFileWithBug = ""


//    val pathToSave = "/home/stepanov/Kotlin/testProjects/trash/src"
//    var classpath = "/home/stepanov/Kotlin/testProjects/github/kotoed/kotoed-server-0.1.0-SNAPSHOT-fat-without-sources.jar"

    val jdkHome = "/usr/lib/jvm/java-8-openjdk"
    val jvmTarget = "1.8"
//    val pathToFileWithBug = "/home/stepanov/Kotlin/testProjects/github/kotoed/kotoed-server/src/main/kotlin/org/jetbrains/research/kotoed/db/processors/ProcessorVerticle.kt"


    //TO FILTER DUPLICATES
//    val files = File("/home/stepanov/Kotlin/testProjects/CompilerCrushingTests/test/").listFiles()
//    FilterDuplcatesCompilerErrors(files.toList().filter { it.absolutePath.endsWith(".kt") }).filter()
//    System.exit(0)

    CompilerArgs.projectDir = debugProjectDir
    CompilerArgs.isProject = isProject
    if (jdkHome.isNotEmpty()) {
        CompilerArgs.jdkHome = jdkHome
    }
    if (jvmTarget.isNotEmpty()) {
        CompilerArgs.jvmTarget = jvmTarget
    }
    if (pathToFileWithBug.isNotEmpty()) {
        CompilerArgs.pathToFileWithBug = pathToFileWithBug
    }

    //Create PSI
    val creator = PSICreator(debugProjectDir)
    val targetFiles = creator.getPSI()
    if (targetFiles.isEmpty())
        return

    //Check classpath and delete all sources from jar
    if (classpath.isNotEmpty()) {
        //CompilerArgs.classpath = RemoveSourcesFromJar.transform(targetFiles, classpath).name
        CompilerArgs.classpath = classpath
    }
    val manager = TransformationManager(targetFiles)
    val backendProperty = ReduKtorProperties.getStringGroup("BACKEND").entries.first()
    val backend = when (backendProperty.key) {
        "JVM" -> JVMBackend(backendProperty.value)
        "JS" -> JSBackend(backendProperty.value)
        else -> throw IllegalArgumentException("Illegal backend")
    }
    if (isProject) {
        manager.doProjectTransformations(targetFiles, creator, backend)
    } else {
        manager.doTransformations(CommonCompilerCrashTestChecker(backend))
    }
    System.exit(0)
}
