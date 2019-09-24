
fun bar(): String {
    open class LocalGeneric<T>(val x: String)
    class Derived(x: String) : LocalGeneric<String>(x)
    fun <T> LocalGeneric<T>.extFun() = this
    fun <T> localFun(x: LocalGeneric<IllegalStateException>) = x
    class Local3 {
        fun <T> method(x: LocalGeneric<T>) = x.x
    }
    return Local3().method(localFun(Derived("O")).extFun())
}