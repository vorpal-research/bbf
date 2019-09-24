// WITH_RUNTIME
// IGNORE_BACKEND: JS_IR

inline fun box() = (A().toString())

class A {
    fun equals2(a: Int, b: Double?) = a!!.rem(2)

    private companion object {
    fun box(): String {
    lateinit var ok: String
    run {
        ok = "foo"
    }
    return ok
}
}
}


fun String() = (-0.0f)

