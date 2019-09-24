fun box(): String {
    data class Pair<F, S>(val first: F, val second: String)
    val (x, y) =
            Pair(0,
                 if (1==1)
                     Pair<String, String>::first
                 else
                     "fail")
    return y.get(Pair("fail 12: ", "Fail"))
}
    // IGNORE_BACKEND: JS_IR
fun main(args: Array<String>) {}