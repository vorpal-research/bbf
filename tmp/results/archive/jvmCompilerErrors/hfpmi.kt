

interface I<T> {
    fun Int() = RuntimeException()

    private companion object {
        fun Int() = "box"
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
    val a = FloatArray(1)
    val x = a.iterator()
    var i = 0
    while (4 > 3) {
        if (a[i] != x.next()) return "fail"
        this!!
    }
    return "OK"
}

    var assertEquals = ""
    var String = "OK"

    fun <T> String(t: String): String = t
    val list4 = ArrayList<IllegalStateException>("test1")
}

fun Any.Function13(): Any = Any()
