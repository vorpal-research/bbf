package com.stepanov.bbfexecutor

import org.apache.commons.exec.*
import java.io.File
import java.util.*

const val PATH_TO_JAR = "java -jar backend-bugfinder/target/backendBugFinder-1.0-jar-with-dependencies.jar"
val TIMEOUT_SEC = Properties()
        .also { it.load(File("bbf.conf").inputStream()) }
        .getProperty("BBF_TIMEOUT")?.toLongOrNull() ?: throw IllegalArgumentException("Can't init timeout value")

data class BBFProcess(val cmd: CommandLine, val file: File,
                      val handler: DefaultExecuteResultHandler, val executor: DefaultExecutor) {
    fun execute() {
        executor.execute(cmd, handler)
    }
}


fun createBBFProcess(f: File): BBFProcess {
    val cmd = CommandLine.parse("$PATH_TO_JAR ${f.absolutePath}")
    val executor = DefaultExecutor().also {
        it.watchdog = ExecuteWatchdog(TIMEOUT_SEC * 1000)
    }
    val handler = DefaultExecuteResultHandler()
    return BBFProcess(cmd, f, handler, executor)
}


fun main(args: Array<String>) {
    //val dir = File(args[0]).listFiles()
//    val dir = File("tmp/arrays").listFiles()
//    val threads = 1
//    val processes = ArrayList<Pair<BBFProcess, Double>>(threads)
//    repeat(threads){ processes.add(createBBFProcess(dir.random()) to 0.0) }
//    processes.forEach { (pr, _) -> pr.executor.execute(pr.cmd, pr.handler) }
//    val step = 1000
//    while (true) {
//        for ((i, procToTime) in processes.withIndex()) {
//            val (proc, time) = procToTime
//            println("Process $i. Time elapsed: $time Res: ${proc.handler.hasResult()}")
//            if (proc.handler.hasResult()) {
//                processes[i] = createBBFProcess(dir.random()) to 0.0
//                processes[i].first.execute()
//            }
//            processes[i] = proc to time + step
//        }
//        Thread.sleep(1000)
//    }
    val joinedArgs = args.joinToString(separator = " ")
    var cmdLine = CommandLine.parse("$PATH_TO_JAR $joinedArgs")
    var executor = DefaultExecutor().also {
        it.watchdog = ExecuteWatchdog(TIMEOUT_SEC * 1000)
    }
    var handler = DefaultExecuteResultHandler()
    var timeElapsed = 0
    executor.execute(cmdLine, handler)

    if (joinedArgs.contains("-r") || joinedArgs.contains("--reduce"))
        while (true) {
            println("Elapsed: $timeElapsed")
            if (handler.hasResult()) System.exit(0)
            timeElapsed += 1000
            Thread.sleep(1000)
        }

    while (true) {
        println("Elapsed: $timeElapsed")
        if (handler.hasResult()) {
            cmdLine = CommandLine.parse("$PATH_TO_JAR $joinedArgs")
            handler = DefaultExecuteResultHandler()
            executor = DefaultExecutor().also {
                it.watchdog = ExecuteWatchdog(TIMEOUT_SEC * 1000)
            }
            executor.execute(cmdLine, handler)
            timeElapsed = 0
        }
        timeElapsed += 1000
        Thread.sleep(1000)
    }
}