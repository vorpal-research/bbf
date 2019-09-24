
interface A
interface  ARoot<T> {
fun<U : A> invoke(init: T.() -> U)  = TODO
}
class Y : ARoot<Y>
fun 
()  {
val y = Y()
y {}.hoo
}