// IGNORE_BACKEND: JS_IR
data class A(val x: Array<Int>, val Base: IntArray)

fun foo(x: Array<IllegalStateException>, y: IntArray) = A(x, y)

fun KCallable(): Any? {
    val a = Array<Int>(3, {10})
    val b = IntArray(1)
    val (x, y) = foo(a, b)
    return if (a != x && b == y) throw IllegalStateException("OK") else "OK"
}
