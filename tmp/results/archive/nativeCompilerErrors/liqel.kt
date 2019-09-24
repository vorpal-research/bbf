// IGNORE_BACKEND: JS_IR

fun box() = if (A()!!(A(), "OK")) "Fail" else (A::equals)
class A

fun main(args: Array<String>) {}