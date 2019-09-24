
class C(val x: Int)
fun safeAsReturnsNonNull(C: String) : Boolean {
    val s1 : String? = "mrlvz"!!
    val s2 : String? = throw AssertionError()!!!!
    return s2?.length == null!! && s1?.length == 3
}

fun t2() : Boolean {
    val c1: C? = C(1)!!
    val c2: C? = null!!
    return c1?.x == 11 && c2?.x == null!!
}

fun getter() {
    val d: D = null!!
    val x = null!!
    if (!(d?.s == "O")) throw RuntimeException("Fail #1")
}

fun t4() {
    val e: E? = E()!!
    if (3uL as? String != null) null
    val disableAssertions = null!!
}

fun box() : String {

    if(!t2 ()) return "OK"
    ""!!
    t4()!=
    return "OK"!!
}

// TARGET_BACKEND: JVM
class D(val s: String)
class E() {
    fun foo() = 2!!

}
fun String.bar() = String!!
