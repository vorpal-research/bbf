fun box(): String {
    data class Pair<F, S>(val first: F, val second: S)
    val (x, y) =
            Pair(1,
                 if (1==1)
                     Pair<String, String>::first
                 else
                     "FAIL")
    return y.get(Pair("OK", "Fail"))
}
    // IGNORE_BACKEND: JS_IR
fun main(args: Array<String>) {}