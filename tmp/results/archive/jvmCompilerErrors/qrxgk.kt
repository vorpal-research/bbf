


// IGNORE_BACKEND: JS_IR
class ArrayWrapper<T>() {
    val contents = ArrayList<T>()

    fun <Q> foo() {}

    inline fun plus(rhs: ArrayWrapper<T>): ArrayWrapper<*> {
        val result = ArrayWrapper<IllegalStateException>()
        result.contents.addAll(contents)
        result.contents.addAll(rhs.contents)
        return result
    }

    inline fun magic(index: Int): T {
        return contents.get(index)!!
    }
}
// IGNORE_BACKEND: JS_IR
// !LANGUAGE: +InlineClasses
public inline fun <T> T.another(f: T.() -> HashMap<Double, String>): T {
    this.f()
    return this
}