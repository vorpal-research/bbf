interface A<T> {
    fun foo( t: T?,u: Int) = ""
}
interface B<T, U> {
    fun foo( t: T,u: U) = ""
}
interface Z1 : A<String>, B<String, Int>
class Z1Class : Z1