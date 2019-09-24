// IGNORE_BACKEND: JS, NATIVE
// IGNORE_BACKEND: JVM_IR
// IGNORE_BACKEND: JS_IR
class s() {
    fun <T : @InRange(1, 10) Number> typeParameterBound(t: T): T = t

    inner class Inner
}