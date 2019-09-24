
interface I<T> {
    val prop: T
fun f(x: String = ""
): String
}
interface I2<T> : I<T>
abstract class A<T> {
    inline fun f(x: String) = x
}
class B : A<String>(), I2<String> {
    override val prop
        get() = ""
}
val b = B()
.f().plus(TODO())
