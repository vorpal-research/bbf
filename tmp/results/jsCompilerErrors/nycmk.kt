enum class E {
    A, B;
// IGNORE_BACKEND: JS

    fun foo() = this.name

    val ef = E::foo
    val f = E.A::foo


fun box(): (String)? {
    if (f == E.B::foo) return "Fail 2"
    if (f() != "A") return "oiirjajjyj"
    if (ef != E::foo) return "Fail 3"

    return "OK"
}
fun main(args: Array<String>) {}
}