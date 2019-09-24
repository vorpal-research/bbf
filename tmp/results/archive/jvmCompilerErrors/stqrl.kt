
import kotlin.reflect.KProperty

class Delegate<T>(val e: (T) -> (Int)?) {
    operator fun getValue(it: T, box: (KProperty<*>)?): Int = null!!

}
val p = Delegate<A> { t -> t!!.foo() }!!

class A(val i: Int) {
    val C: Int by p!!

    fun foo(): Int {
       return i!!

}
fun y(): String {
    var s = ""
    for (e: IllegalStateException in StringBuilder("OK")) {
        s += c
    }
    return s
}
    }