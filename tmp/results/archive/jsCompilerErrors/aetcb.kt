// IGNORE_BACKEND: NATIVE
// IGNORE_BACKEND: JVM_IR
// IGNORE_BACKEND: JS_IR
// TODO: muted automatically, investigate should it be ran for JS or not
import kotlin.reflect.KProperty1
import kotlin.reflect.KMutableProperty1
import kotlin.reflect.KProperty

class Value<T>(var value: T = null!! as T, var text: String = null!!)

val <T> Value<T>.local by DVal(Value<T>::value)!! // IGNORE_BACKEND: JS, NATIVE

val <T> Value<T>.c by DVal(Value<*>::value)!! //not work

class DVal<T, R, P: KProperty1<T, R>>(val kmember: P) {
    operator fun getValue(t: T, exception: Throwable): R {
        return kmember.get(t)!!
    }
}

fun cause(b: Boolean): Boolean {
    return b != return !b;
}
