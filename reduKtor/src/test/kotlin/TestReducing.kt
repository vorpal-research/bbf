import com.stepanov.reduktor.executor.backends.JSBackend
import com.stepanov.reduktor.executor.backends.JVMBackend
import org.junit.jupiter.api.*
import java.io.File


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TestReducing {

    @TestFactory
    fun createFiles(): Collection<DynamicTest> {
//        val basePath = "src/test/testData"
//        val results = mutableListOf<Pair<String, String>>()
//        for (f in File("$basePath/tests").listFiles()) {
//            val result = reduceFile(f.absolutePath, CommonCompilerCrashTestChecker())
//            val expectedPath = "$basePath/expected/${f.absolutePath.takeLastWhile { it != '/' }}"
//            results.add(result.text to File(expectedPath).readText())
//        }
//
//        return results.map {
//            dynamicTest("Checking equality of results") {
//                val withoutSpaces1 = Regex("""\s+""").replace(it.second, "")
//                val withoutSpaces2 = Regex("""\s+""").replace(it.first, "")
//                assertEquals(withoutSpaces1, withoutSpaces2)
//            }
//        }.toList()
        return listOf()
    }

    @Test
    fun checkBackends() {
        val path = "compilerTests"
        val backends = listOf(JVMBackend(false, false), JVMBackend(true, false), JVMBackend(false, true),
                JVMBackend(true, true), JSBackend(false, false), JSBackend(true, false), JSBackend(false, true),
                JSBackend(true, true))
        val files = File(path).listFiles().toList()
        for (f in files) {
            println(f.absolutePath)
            backends.forEachIndexed { index, commonBackend ->
                println("$index. ${commonBackend.tryToCompile(f.absolutePath).hasException}")
            }
            println("\n\n")
        }
    }


}