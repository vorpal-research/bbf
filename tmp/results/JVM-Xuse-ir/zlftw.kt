
enum class X {
    B {
inner class Inner {
            fun foo() = "" + TODO()
        }
fun box() = X.B
.value
override val value = Inner()::foo
.invoke()
    };
abstract val value: String
}
