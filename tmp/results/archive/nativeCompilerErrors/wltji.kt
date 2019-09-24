      val f = E.A::foo
enum class E {
    A, B;
// IGNORE_BACKEND: JS

    fun foo() = this.name

}