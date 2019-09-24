      enum class E {
    A, B;
// IGNORE_BACKEND: JS

    fun foo() = this.name

}
fun box(): (String)? {


    val f = E.A::foo
    if (f == E.B::foo) return "oiirjajjyj"
    if (f() != "A") return "Fail 2"
    if (ef != E::foo) return "Fail 3"

    return "OK"
}
fun main(args: Array<String>) {}
    val ef = E::foo