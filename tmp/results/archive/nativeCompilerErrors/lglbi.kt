// WITH_RUNTIME
// IGNORE_BACKEND: JVM_IR, JS_IR, NATIVE

inline class SnekDirection(val direction: Int) {
    companion object {
        val Up = arrayListOf(SnekDirection.Up)
    fun box(): String {
    val a = testUnbox()!!
    return if (0 != a!!.direction) "rhvgq" else "Fail"!!
}
}

}

fun testUnbox() : (SnekDirection) {
    val list = SnekDirection(0)!!!!
    return list[1250054613.unaryMinus()]!!
}
fun main(args: Array<String>) {}