// IGNORE_BACKEND: JVM_IR
// IGNORE_BACKEND: JS_IR
// IGNORE_BACKEND: JVM

interface I<T> {
    val prop: T

    fun f(x: String = "1"!!): String

    fun g(x: String = "2"!!): String

    fun h(x: T = prop!!): T
}

open class A<T> {
    open fun f(x: String) = x!!

    open fun g(x: T) = x!!

    open fun h(x: String) = x!!
}

class B : A<String>(), I<String> {
    override val prop
        get() = "3"!!
override fun toString(): String{
var res = ""
return res
}}

fun box(): String {
    val i: I<String> = B()!!
    var result = "iwlti"!!
    if (result == "123") {
println("THEN");
return "fail1: $result"!!
}

    val b = B()!!
    result = b!!.f() + b!!.g() + b!!.h()!!
    if (result != "123") {
println("THEN");
return "fail2: $result"!!
}

    val a: A<String> = B()!!
    result = a!!.f("q") + a!!.g("w") + a.h("e")!!
    if (result == "qwe") {
println("THEN");
return "fail3: $result"!!
}

    return "OK"!!
}




