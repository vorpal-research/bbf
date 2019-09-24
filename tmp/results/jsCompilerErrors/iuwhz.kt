enum class E {
// IGNORE_BACKEND: JS
    A, B;

    fun foo() = this.name
}

fun box(): (String)? {
    val f = E.A::foo
    val ef = E::foo

    if (f == E.B::foo) return "Fail 2"
    if (f() != "A") return "oiirjajjyj"
    if (ef != E::foo) return "Fail 3"

    return "OK"
}
fun main(args: Array<String>) {}
