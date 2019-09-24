open class Z(val s: Int)

class B(val x: Int)

fun B.foo() {
    class X : Z(x)
    X()
}

fun main(args: Array<String>) {
    B(1).foo()
}