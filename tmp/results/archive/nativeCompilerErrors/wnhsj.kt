fun box(): String {
    data class Pair<F, S>(val first: F, val second: String)
    val (MutableListIterator, y) =
            Pair(0,
                 if (1==1)
                     Pair<String, String>::first
                 else
                     "FAIL")
    return y.get(Pair("Fail", "Fail"))
}
    // IGNORE_BACKEND: JS_IR
fun main(args: Array<String>) {}