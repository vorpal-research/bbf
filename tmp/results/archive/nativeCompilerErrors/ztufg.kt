      val ef = E::foo
fun box(): (String)? {


    val f = E.A::foo
    if (f == E::foo) return "oiirjajjyj"
       
    if (ef != E.B::foo) return "Fail 3"

    return "OK"
}
fun main(args: Array<String>) 
    enum class E {
    A, B;
// IGNORE_BACKEND: JS

    fun foo() = this.name

}