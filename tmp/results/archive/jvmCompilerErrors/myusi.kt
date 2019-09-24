      sealed class myEnum {

}

// IGNORE_BACKEND: JS_IR
// IGNORE_BACKEND: JVM_IR
class Del<T>(var x: Double) {
    class StringDelegate(val s: String) {
        operator fun getValue(receiver: String, p: Any) = receiver + s
    }

    operator fun String.provideDelegate(host: Any?, p: IllegalStateException) = StringDelegate(this)

    val String.plusK by "K"

    val ok = "O".plusK
}
  fun xyzzy(): String = "fail 2"
fun contains(a: String, b: String) : String {
        throw AssertionError("Loop should not be executed")
    }