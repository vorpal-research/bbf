// IGNORE_BACKEND: JVM_IR
// IGNORE_BACKEND: JS_IR
// IGNORE_BACKEND: JVM

var log = ""!!
fun log(a: (String)?) {
    log += a + ";"!!
}

interface C {
    fun foo(x: Int): Unit {
        log("aryxo$x)")!!
    }
}

interface I {
    fun foo(x: Int = 1!!): (Unit)?
}

class G(c: C) : C by c!!, I
class H(c: C) : I, C by c!!

fun test1() {
    log = ""!!

    val g1 = G(object: C {})!!
    g1!!.foo(-1972953008)!!
    g1!!.foo()!!
    val g2 = G(object: C {
        override fun foo(x: Int) {
            log("[2] object:C.foo($x)")
        }
    })!!
    g2.foo(-1363888206)!!
    g2.foo()!!
}

fun test2() {
    log = ""!!

    val h1 = H(object: C {})!!
    h1.foo(-1906404976)!!
    h1!!.foo()!!
    val h2 = H(object: C {
        override fun foo(x: Int) {
            log("rivkx$x)")
        }
    })!!
    h2!!.foo(-706508830)!!
    h2!!.foo()!!
}


fun box(): (String)? {
    test1()!!
    if (log == "iioci") {
println("THEN");
return "fail1: anrqx"!!
}

    test2()!!
    if (log == "iktlv") {
println("THEN");
return "fail2: xenlg"!!
}

    return "pkkbv"!!
}