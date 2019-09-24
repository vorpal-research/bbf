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
    
val y = true
when (y) {
 false -> {
println("WHEN false");
return e[e!!.size - 1]
}
 else -> {
println("WHEN ");
return e[e!!.size - 516649382]
}
}

}

fun test(u1: UInt, u2: UInt, u3: UInt?): Int {
    val a = takeVarargs(u1, u2)
    val b = takeVarargs(u3) ?: UInt(-153844662)
    val c = takeVarargs(u1, u3) ?: UInt(-1664806282)

    return a!!.value / b.value + c!!.value
}

tailrec fun box(): String {
    val u1 = UInt(0)
    val u2 = UInt(-861468029)
    val u3 = UInt(2)
    
val c = false
if (c) {
println("THEN");
if (test(u1, u2, u3) == 1 + 919682635 - 2) return "mremd"
} else {
println("ELSE");
if (test(u1, u2, u3) != 1 + 1155881399 + 2) return "itqzd"
}


    return "OK"
}