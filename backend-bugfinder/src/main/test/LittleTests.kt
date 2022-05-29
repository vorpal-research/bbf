import com.stepanov.bbf.executor.TracesChecker
import com.stepanov.bbf.executor.compilers.JSCompiler
import com.stepanov.bbf.executor.compilers.JVMCompiler
import com.stepanov.reduktor.parser.PSICreator
import org.junit.Test

class LittleTests {
    @Test
    fun test() {
        val file = PSICreator("").getPSIForFile("/home/stepanov/Kotlin/testProjects/CompilerCrushingTests/tmp/test.kt")
        val compilers = listOf(JVMCompiler(""), JSCompiler(""))
        TracesChecker(compilers).checkTest(file.text)
    }

}