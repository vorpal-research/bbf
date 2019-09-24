enum class E {
// IGNORE_BACKEND: JS
    A, B;

    fun foo() = this.name

}
    val f = E.A::foo


fun box(): (String)? {
    if (ef != E::foo) return "Fail 3"
    if (f() != "A") return "oiirjajjyj"
    if (f == E.B::foo) return "Fail 2"

    return "OK"
}
fun main(args: Array<String>) {}
    val ef = E::foo