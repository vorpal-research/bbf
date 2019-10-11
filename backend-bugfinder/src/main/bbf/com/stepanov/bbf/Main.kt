package com.stepanov.bbf

import com.stepanov.bbf.executor.CompilerArgs
import kotlinx.coroutines.*
import org.apache.log4j.PropertyConfigurator
import java.io.File


//fun main(args: Array<String>) {
//    val parser = ArgumentParsers.newFor("bbf").build()
//    parser.addArgument("-r", "--reduce")
//            .required(false)
//            .help("Reduce mode")
//    parser.addArgument("-f", "--fuzz")
//            .required(false)
//            .help("Fuzzing mode")
//    val arguments = parser.parseArgs(args)
//    arguments.getString("reduce")?.let {
//        val backendStr = arguments.getString("backend")?.split("-")?.first()
//                ?: throw IllegalArgumentException("Specify backend")
//        val backArgs = arguments.getString("backend")?.split("-")?.drop(1)
//                ?: throw IllegalArgumentException("Wrong args")
//        val backendArgs =
//                if (backArgs.isEmpty())
//                    ""
//                else
//                    backArgs.joinToString(separator = " -", prefix = "-")
//        val backend = when (backendStr) {
//            "JVM" -> JVMCompiler(backendArgs)
//            "JS" -> JSCompiler(backendArgs)
//            else -> throw IllegalArgumentException("Wrong backend, it should be JVM or JS")
//        }
//        val res = Reducer.reduce(it, backend)
//        println("res = ${res.map { it.text }}")
//        exitProcess(0)
//    }
//    arguments.getString("fuzz")?.let {
//        BBFExecutor.execute(it)
//        exitProcess(0)
//    }
//}


fun main(args: Array<String>) {
    //Init log4j
    PropertyConfigurator.configure("backend-bugfinder/src/main/resources/log4j.properties")

    val isFromIdea = false
    val numOfThreads = 1

    BugFinder("/home/stepanov/Kotlin/testProjects/CompilerCrushingTests/test/test.kt").findBugsInFile()
    System.exit(0)

    if (isFromIdea) {
        if (numOfThreads == 1) {
            val listOfFiles = File(CompilerArgs.baseDir).listFiles().filter { it.name.endsWith(".kt") }
            listOfFiles.shuffled().forEach {
                BugFinder(it.absolutePath).findBugsInFile()
            }
        }
//        val listOfFiles = File(CompilerArgs.baseDir).listFiles().filter { it.name.endsWith(".kt") }
//        val file = File("lol.text")
//        file.writeText("Results: ")
//        listOfFiles.forEach {
//            println("f = ${it.absolutePath}")
//            val list = FilterDuplcatesCompilerErrors.getListOfDuplicates(it.absolutePath,
//                    "/home/stepanov/Kotlin/backend-bugfinder/tmp/results/archive/jvmCompilerErrors/",
//                    CompilerType.JVM)
//            file.appendText("Duplicates of ${it.absolutePath} are:")
//            list.forEach { file.appendText(it) }
//            file.appendText("\n")
//            println("Duplicates of ${it.absolutePath} are:")
//            list.forEach { println(it) }
//            println("\n")
//        }
//        System.exit(0)
//        while (true) {
//            val threadMap = mutableMapOf<Int, Pair<Thread, Long>>()
//            val step = 1000L
//            val limit = 60 * 60 * 1000
//            //Create n threads
//            for (i in 0 until numOfThreads) {
//                threadMap[i] = Thread(BugFinder(listOfFiles.random().absolutePath), "$i") to 0L
//            }
//            threadMap.forEach { it.value.first.start() }
//
//            while (true) {
//                Thread.sleep(step)
//                // Ask all threads
//                threadMap.forEach { ind, (thread, time) ->
//                    if (!thread.isAlive || thread.isInterrupted) {
//                        println("CREATING NEW THREAD")
//                        val newThread = Thread(BugFinder(listOfFiles.random().absolutePath), "$ind")
//                        threadMap[ind] =  newThread to 0L
//                        newThread.start()
//                    } else if (time > limit) {
//                        println("INTERRUPTING")
//                        thread.interrupt()
//                    } else {
//                        println("THREAD = ${thread.name} time = $time")
//                        threadMap[ind] = thread to time + step
//                    }
//                }
//            }
//
//        }
    } else {
        require(args.isNotEmpty())
        val fileName = args[0]
        BugFinder(fileName).findBugsInFile()
        System.exit(0)
//        val bugFinderThread = Thread(BugFinder(fileName))
//        bugFinderThread.start()
//        val step = 10 * 1000L
//        val limit = 60 * 60 * 1000
//        var curTime = 0L
//        while (true) {
//            println("$curTime THREAD = ${bugFinderThread.id} is alive ${bugFinderThread.isAlive}")
//            Thread.sleep(step)
//            curTime += step
//            if (curTime > limit) {
//                while (bugFinderThread.isAlive) {
//                    bugFinderThread.interrupt()
//                }
//                System.exit(0)
//            }
//            if (!bugFinderThread.isAlive) {
//                break
//            }
//        }
//        System.exit(0)
    }
}

