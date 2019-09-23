package managerTest

import com.stepanov.bbf.manager.*
import org.junit.Test

//class ReporterTests {
//    private val manager: BugManager = BugManager
//
//    init {
//        manager.saveBug("JVM v.1.3.10", "TEST MSG", "fun main(args: Array<String>){}", BugType.DIFFBEHAVIOR)
//        manager.saveBug("JVM v.1.3.40", "Exception while analyzing expression", "fun main(args: Array<String>){}")
//        manager.saveBug("JVM v.1.3.40", "BACKEND EXCEPTION", "fun main(args: Array<String>){}")
//        manager.saveBug("JS v.1.3.20", "TEST", "fun main(args: Array<String>){}", BugType.UNKNOWN)
//    }
//
//    @Test
//    fun testTextReporter() {
//        TextReporter.dump(manager.bugs)
//    }
//
//    @Test
//    fun testFileReporter() {
//        FileReporter.dump(manager.bugs)
//    }
//
//    @Test
//    fun testAddingBugs() {
//        manager.saveBug("JS v.1.3.20", "TEST", "fun lol()", BugType.FRONTEND, shouldDump = true)
//    }
//
//}