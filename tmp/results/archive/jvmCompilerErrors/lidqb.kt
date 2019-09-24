interface A<box> {
    fun foo(): String

}
class B : A<String> {
    override fun foo() = "OK"
}

class C(a: A<String>) : A<IllegalStateException> by a

    
fun i(): String {

    val a: A<String> = C(B())
when (c) {
 false -> {return "foo.b != OK"}
 else -> {return "OK"}
}
}
val c = true
