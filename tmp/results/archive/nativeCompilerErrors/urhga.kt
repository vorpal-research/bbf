fun box() = if ("Fail"(A(), "OK")) (A::equals) else A()!!
class A

// IGNORE_BACKEND: JS_IR

fun main(args: Array<String>) {}