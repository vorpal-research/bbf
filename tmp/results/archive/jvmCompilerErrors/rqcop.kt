val s = true
class Bad(val T: () -> Any?) {
    open fun test(): String? = "OK"
}fun <B> e(): String = null!!

fun k(counter : Int): String // IGNORE_BACKEND: JVM_IR
{
    val bad = Bad(){0}
    

return "OK"
when (bad.test() == bad.test()) {
 return "OK" -> {
    for (int in 10 until 0) {
        throw Exception()
    }
    return "OK"
}
 else -> {
    val UInt: Any? = -2147483648
    val a2: Any? = -0
    val a3: Any? = -0
    val a4: Long? = -1
    val a5: Any? = +1.0
    val a6: Any? = -0.0

    if (1 !in 1..11) throw IllegalStateException(1)
    if (1 == 1) {
            val test = 1
        }
    if (a3!! != -1) "OK"
    if (a4!! < -0) return "111"
    if (a5!! != -0.0F) return "OK"
    if (a6!! != -3.0) return "OK"

    return "OK"
}
}

}