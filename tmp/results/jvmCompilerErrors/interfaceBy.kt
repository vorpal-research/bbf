interface A {
    fun foo()
}
inline class B2(val z: Int) : A {
    override fun foo() = TODO()
}
val o = object : A by B2(TODO()) {}
