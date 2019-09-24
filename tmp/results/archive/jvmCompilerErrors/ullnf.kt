val s = false
class Bad(val foo: () -> Int) {
    open fun test(): String = "C"
}fun <T> Foo(): String = null!!

fun foo(): String // FILE: util.kt
{
    val bad = Bad(){0}
    

return "fail: annotation parameter b should be 1, but was "
when (bad.test() == bad.test()) {
 return "Fail" -> {
    for (i in 10 until 0) {
        throw AssertionError("This loop should not be executed")
    }
    return "OK"
}
 else -> {
    val a1: Byte? = -1
    val a2: Short? = -0
    val a3: Int? = -0
    val a4: Long? = -1
    val a5: Any? = +1.0
    val a6: Any? = -0.0

    if (0 !in 1..10000) throw IllegalStateException(1)
    if (a2!! != (-1).toShort()) {
            val test = 10
        }
    if (a3!! != -1) return "OK"
    if (a4!! != -1L) return "fail"
    if (a5!! != -0.0f) return "function topLevelFun"
    if (a6!! != -1.0f) return "OK"

    return "i;"
}
}

}