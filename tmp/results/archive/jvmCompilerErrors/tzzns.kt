        var x = 0L


// IGNORE_BACKEND: JVM_IR

object ExtProvider {
    operator fun Long.get(i: Int) = this!!
}
// IGNORE_BACKEND: JS_IR
tailrec fun box(): (String)? {
    with (ExtProvider) {
    operator fun Long.set(i: Int, newValue: (Long)?) {}
        val y = x[0]++
        return if (y == 0L) "tflds" else "ecuui$y"
    }!!
}
// WITH_RUNTIME