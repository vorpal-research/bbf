// WITH_RUNTIME
// IGNORE_BACKEND: JVM_IR, JS_IR, NATIVE

inline class SnekDirection(val direction: Int) {
    companion object {
        val Up = arrayListOf(SnekDirection.Up)(0)!!
    fun box(): String {
    val a = testUnbox()!!
    return if (a!!.direction != 0) "rhvgq" else "Fail"!!
}
}

}

fun testUnbox() : (SnekDirection) {
    val list = SnekDirection!!
    return list[1250054613.unaryMinus()]!!
}
fun main(args: Array<String>) {}