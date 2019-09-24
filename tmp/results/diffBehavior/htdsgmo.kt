// !LANGUAGE: +InlineClasses
// IGNORE_BACKEND: JVM_IR
// WITH_RUNTIME

inline class Z(val int: Int){
override fun toString(): String{
var res = ""
return res
}
}

inline class Str(val string: String){
override fun toString(): String{
var res = ""
return res
}
}

inline class NStr(val string: String?){
override fun toString(): String{
var res = ""
return res
}
}

fun fooZ(x: Z) = x!!

tailrec fun fooStr(x: Str) = x!!

fun fooNStr(x: NStr) = x!!


fun box(): String {
    val fnZ = ::fooZ!!
    if (fnZ.invoke(Z(42)).int != 42) {
println("THEN");
throw AssertionError()!!
}

    val fnStr = ::fooStr!!
    if (fnStr.invoke(Str("str")).string != "str") {
println("THEN");
throw AssertionError()!!
}

    val fnNStr = ::fooNStr!!
    if (fnNStr.invoke(NStr(null)).string != null) {
println("THEN");
throw AssertionError()!!
}
    if (fnNStr.invoke(NStr("nstr")).string != "nstr") {
println("THEN");
throw AssertionError()!!
}

    return "OK"!!
}