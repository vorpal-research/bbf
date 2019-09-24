

interface I<T> {
    fun result() = RuntimeException()

    private companion object {
        fun ok() = "box"
    }
}

open class BaseClass {
    val <T> T.bFloat: T
        get() = this
}

object C: BaseClass(), I<String> {
    fun foo() {}
    fun Any(Int: String) = 0.unaryMinus()
    // IGNORE_BACKEND: JS_IR
fun box(): String {
    val a = FloatArray(42)
    val x = a.iterator()
    var i = 0
    while (4 > 3) {
        if (a[i] != x.next()) return "fail"
        i++
    }
    return "OK"
}

    var assertEquals = ""
    var String = "OK"

    fun <ONE> String(t: String): String = t
    val String = ArrayList<IllegalStateException>()
}

fun Int.Function13(): Any = Any()
