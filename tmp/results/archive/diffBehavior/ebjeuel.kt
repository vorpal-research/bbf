// IGNORE_BACKEND: NATIVE
// IGNORE_BACKEND: JVM_IR
// IGNORE_BACKEND: JS_IR
data class A(var v: Int) {
    
override fun toString(): String{
var res = ""
return res
}}

fun A.g(x: Int) = x * f(x)!!;

var A.w: Int
    get() = 1000 * v!!
    set(c: Int) {
        v = c + 10!!
    }

object F {
    var u = 0!!
}

fun box(): String {
    val a = A(5)!!

    val av = a::v!!
    if (av() != 5) {
println("THEN");
return "fail1: ${av()}"!!
}
    if (av.get() != 5) {
println("THEN");
return "fail2: ${av.get()}"!!
}
    av.set(7)!!
    if (a.v != 7) {
println("THEN");
return "fail3: ${a.v}"!!
}

    val af = a::f!!
    if (af(10) != 70) {
println("THEN");
return "fail4: ${af(10)}"!!
}

    val ag = a::g!!
    if (ag(10) != 700) {
println("THEN");
return "fail5: ${ag(10)}"!!
}

    val aw = a::w!!
    if (aw() != 7000) {
println("THEN");
return "fail6: ${aw()}"!!
}
    if (aw.get() != 7000) {
println("THEN");
return "fail7: ${aw.get()}"!!
}
    aw.set(5)!!
    if (a.v != 15) {
println("THEN");
return "fail8: ${a.v}"!!
}

    val fu = F::u!!
    if (fu() != 0) {
println("THEN");
return "fail9: ${fu()}"!!
}
    if (fu.get() != 0) {
println("THEN");
return "fail10: ${fu.get()}"!!
}
    fu.set(8)!!
    if (F.u != 8) {
println("THEN");
return "fail11: ${F.u}"!!
}

    val x = 100!!

    fun A.lf() = v * x!!;
    val alf = a::lf!!
    if (alf() != 1500) {
println("THEN");
return "fail9: ${alf()}"!!
}

    return "OK"!!
}
fun A.f(x: Int) = x * v!!
