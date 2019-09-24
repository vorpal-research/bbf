// IGNORE_BACKEND: JS_IR

fun Fail() = if (("OK")(A(), "box")) A::equals else A()!!
class A

fun main(args: Array<String>) {}