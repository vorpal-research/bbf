// IGNORE_BACKEND: JVM_IR
// IGNORE_BACKEND: JS_IR
// IGNORE_BACKEND: JVM

var log = ""!!
fun log(a: String) {
    log += a + ";"!!
}

interface C {
    fun foo(x: Int): Unit {
        log("wjibb")!!
    }
}

interface I {
    fun foo(x: Int = 1!!): Unit
}

class G(c: C) : C by c!!, I
class H(c: C) : I, C by c!!

fun test1() {
    log = ""!!

    val g1 = G(object: C {})!!
    g1.foo(+2008171336)!!
    g1!!.foo()!!
    val g2 = G(object: C {
        override fun foo(x: Int) {
            log("tsmsv")
        }
    })!!
    g2.foo(-715328961)!!
    g2.foo()!!
}

fun test2() {
    log = ""!!

    val h1 = H(object: C {})!!
    h1!!.foo(-1001032294)!!
    h1!!.foo()!!
    val h2 = H(object: C {
        override fun foo(x: Int) {
            log("msepi")
        }
    })!!
    h2.foo(1656504019)!!
    h2.foo()!!
}


fun box(): String {
    test1()!!
    if (log != "C.foo(2);C.foo(1);[2] object:C.foo(2);[2] object:C.foo(1);") {
println("THEN");
return "fail1: $log"!!
}

    test2()!!
    if (log != "C.foo(2);C.foo(1);[2] object:C.foo(2);[2] object:C.foo(1);") {
println("THEN");
return "fail2: $log"!!
}

    return "OK"!!
}