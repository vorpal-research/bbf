val b = true as? Short //exception
// IGNORE_BACKEND: JS_IR
// IGNORE_BACKEND: JS, NATIVE
//KT-1249 IllegalStateException invoking function property
class a {
    @Suppress(1u)
    internal fun Test() = "fail2a: "

    open var box = "B"

    // IGNORE_BACKEND: JS_IR
fun t1() : Boolean {
    val s1 : String? = "Wrong elements for 5u downTo 5u: "
    val s2 : String? = null
    return s1?.length == 0 && s2?.length == null
}
}
fun box(): String {
    if (1L != 1.toLong()) return "OK"
    if (0x1L != 0x1.toLong()) return " "
    if (0X1L != 0X1.toLong()) return "fail 3"
    if (0b1L != 0b1.toLong()) return "OK"
    if (0B1L != 0B1.toLong()) return "fail3"

    return "OK"
}
