package dulicatesFilterTest

import com.stepanov.bbf.executor.compilers.JVMCompiler
import com.stepanov.bbf.util.FilterDuplcatesCompilerErrors.simpleIsSameErrs
import com.stepanov.bbf.util.FilterDuplcatesCompilerErrors.simpleIsSameErrsWithStacktraces
import com.stepanov.reduktor.executor.error.*
import org.junit.Test
import java.io.File

class DuplicatesFilterTest {

//    fun checkByMessages(msg1: String, msg2: String, expected: Boolean) {
//        val k = FilterDuplcatesCompilerErrors.newCheckErrsMatching(msg1, msg2)
//        assertEquals(expected, k < 0.49)
//    }
//
//    fun checkByPaths(path1: String, path2: String, compiler: CommonCompiler, expected: Boolean) {
//        assertEquals(expected, simpleIsSameErrsWithStacktraces(path1, path2, compiler))
//    }
//
//    fun printStackTrace(path: String) =
//            JVMCompiler().getErrorMessage(path)
//                    .split("\n")
//                    .map { it.trim() }
//                    .filter { it.startsWith("at ") }
//                    .joinToString("\n")
//
//
@Test
fun test() {
    val compiler = JVMCompiler("")
    val file = File("/home/stepanov/Kotlin/bbf/tmp/results/test/test.kt")
    val dir = File("/home/stepanov/Kotlin/bbf/tmp/results/JVM").listFiles().filter { it.absolutePath.endsWith(".kt") }.toList()
    //val msg1 = comp.getErrorMessage(file.absolutePath)
    for (i in 0 until dir.size) {
        val msg2 = compiler.getErrorMessage(dir[i].absolutePath)
        val type = Error(msg2).type
        println("TYPE = ${type}")
        if (type == ErrorType.UNKNOWN)
            println("MSG = $msg2")
        println("COMPARE ${dir[i].name} and ${file.name}")
        println("WITHOUT STACKTRACES = ${simpleIsSameErrs(dir[i].absolutePath, file.absolutePath, compiler)}")
        println("WITH STACKTRACES = ${simpleIsSameErrsWithStacktraces(dir[i].absolutePath, file.absolutePath, compiler)}\n\n\n")
    }
    //checkByPaths("tmp/results/jvmCompilerErrors/niljb.kt", "tmp/results/jvmCompilerErrors/niljb.kt", CompilerType.JVM, true)
    //checkByPaths("tmp/results/jvmCompilerErrors/menvd.kt", "tmp/results/jvmCompilerErrors/ciiik.kt", CompilerType.JVM, true)
}


}