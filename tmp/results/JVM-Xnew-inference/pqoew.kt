class A<T> {
    fun foo() = b.foo
}
class B : A<AString>, D
val b = B()