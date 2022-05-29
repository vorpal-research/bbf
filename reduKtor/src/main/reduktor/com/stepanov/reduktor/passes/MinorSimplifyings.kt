import com.stepanov.reduktor.executor.CompilerTestChecker
import org.jetbrains.kotlin.psi.KtFile

//import com.stepanov.reduktor.executor.CompilerTestChecker
//import com.stepanov.reduktor.parser.PSICreator
//import com.stepanov.reduktor.util.debugPrint
//import com.stepanov.reduktor.util.getAllPSIChildrenOfType
//import org.jetbrains.kotlin.psi.KtFile
//import org.jetbrains.kotlin.psi.KtNameReferenceExpression
//import org.jetbrains.kotlin.resolve.calls.callUtil.getType
//import ru.spbstu.kotlin.generate.combinators.KCheck
//
class MinorSimplifyings(private val file: KtFile, private val checker: CompilerTestChecker) {
//    fun transform() {
//        //Replace variable on constant if we can get type
//        try {
//            val psiCreator = PSICreator("")
//            val file = psiCreator.getPSIForFile(file.name, true)
//            val ctx = psiCreator.ctx
//            KCheck.forAll(10) { a: Int -> println(a) }
//            System.exit(0)
//            file.getAllPSIChildrenOfType<KtNameReferenceExpression>().forEach {
//                it.getType(ctx)?.let { type ->
//                    var res: Any? = null
//                }
//                println("Ref = ${it.text} type = ${it.getType(ctx)}")
//            }
//        } catch (e: Exception) {
//            println("e = $e")
//        }
//    }
//
}