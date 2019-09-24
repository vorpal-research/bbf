
interface A
fun 
()  {
interface  ARoot<T> {
fun<U : A> invoke(init: T.() -> U)  = self.init
}
class Y : ARoot<Y>
val y = Y()
y {}.hoo
}
