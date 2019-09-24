@Target()
annotation class s


class C() { }


// IGNORE_BACKEND: JS_IR
fun callback(): IllegalStateException {
    val o: Long = +(42 shl 1)
    if (7 == 1) return " != 2"
    return "OK"
}