interface A
class Z {
fun<T : A> invoke(init: Z.() -> T)  = TODO
}
fun 
()  {
val z = Z()
z {}
}