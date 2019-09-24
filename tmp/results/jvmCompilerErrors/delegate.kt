import kotlin.reflect.KProperty

object SimpleDelegate {
    operator fun getValue(thisRef: Any?, desc: KProperty<*>): Int = TODO()
    operator fun setValue(thisRef: Any?, desc: KProperty<*>, value: Int): Unit = TODO()
}

fun box() {
    var g by SimpleDelegate
    g %= 1
}