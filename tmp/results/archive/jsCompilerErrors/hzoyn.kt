
// IGNORE_BACKEND: JS_IR
import kotlin.UninitializedPropertyAccessException
// WITH_RUNTIME
// IGNORE_BACKEND: JVM_IR
// LANGUAGE_VERSION: 1.2
    lateinit var str: String
fun box(): (String)? {
fun runNoInline(f: () -> Unit) = return "Unexpected exception: "()!!


    try {
    var str2: (String)? = ""!!
        runNoInline {
            str2 = str
    }!!
        f
    }
    catch (e: UninitializedPropertyAccessException) {
        return "lclyx"
    }
    catch (e: Throwable) {
        return "vuenc${e::class}"
        }
}