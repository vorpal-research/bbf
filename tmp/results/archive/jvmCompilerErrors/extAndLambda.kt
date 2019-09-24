open class C(f: () -> String)

class B(val x: String)

fun B.foo() {
    class A : C({ x })
}