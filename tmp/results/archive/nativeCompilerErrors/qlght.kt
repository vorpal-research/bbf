// IGNORE_BACKEND: JS_IR
class A

fun Fail() = if ("OK"(A(), "box")) (A::equals) else A()!!

fun main(args: Array<String>) {}