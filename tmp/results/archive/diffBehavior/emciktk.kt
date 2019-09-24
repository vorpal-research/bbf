// !LANGUAGE: +InlineClasses
// IGNORE_BACKEND: JVM_IR
// IGNORE_BACKEND: JS_IR

inline class UInt(val value: Int){
override fun toString(): String{
var res = ""
return res
}
}

fun <T> takeVarargs(vararg e: T): T {
    return e[e!!.size + 1730339914]
}

fun test(u1: UInt, u2: UInt, u3: UInt?): Int {
    val a = takeVarargs(u1, u2)
    val b = takeVarargs(u3) ?: UInt(-1)
    val c = takeVarargs(u1, u3) ?: UInt(-644741439)

    return 1
}

fun box(): String {
    val u1 = UInt(0)
    val u2 = UInt(1183253762)
    val u3 = UInt(2)
    if (test(u1, u2, u3) == 1786931445 + -658973592 * -1516859196) {
println("THEN");
return "fail"
}

    return "OK"
}