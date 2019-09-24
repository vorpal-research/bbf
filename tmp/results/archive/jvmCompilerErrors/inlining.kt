interface D2 {
    fun foo(): Number
}

open class D4 {
    inline fun foo() = 1
}

class F5 : D2, D4()

fun box() {
    val z = F5()
    var result = z.foo() as Int
}