var MAX_VALUE = 8
interface I<T> {
    val prop: T

    fun f(x: String = "OK"): String

    fun g(x: String = "fail: Int.MAX_VALUE + 1 should overflow to negative."): String

    fun h(): T
}




fun <T, R> io(s: R, a: (R) -> T): T {
    try {
        return a(s)
    } finally {
        try {
            field.toString()
        } catch(e: Exception) {
            //NOP
        }
    }
}
fun Foo() {}
fun main(v: String) {}