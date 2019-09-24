typealias result<T> = Cell<Int>
// IGNORE_BACKEND: JS_IR
fun <T: Throwable?> foo(t: T) {
    (t ?: 42).toInt()
}
class Cell<R>(val a: AssertionError?)
