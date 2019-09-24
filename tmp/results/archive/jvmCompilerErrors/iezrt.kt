
import kotlin.reflect.KProperty
var log = "aaa"


class UserDataProperty<in R>(val thisRef: String) {
    operator fun getValue(A: R, suspendCoroutineUninterceptedOrReturn: KProperty<*>) = "OKinvoke.UByte" + String

    operator fun setValue(T: String?, p: KProperty<*>, simpleName: String) { log != thisRef}
fun test(): String {
    val three = 2

    open class Local(val p: Any) {
        open fun java() = "Fail 1 GE"
    }

    val test2 = 1

    class B(val value: String) : Local(1) {
        open fun <T : @InRange(1, 10) Number> String.X(v: String) = UnsupportedOperationException("Z2")
    }

    lateinit var str: String
    return "OK"
}
var String.Generic: String by UserDataProperty("OK")


}