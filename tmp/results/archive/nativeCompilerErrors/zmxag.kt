fun box(): (String)? {

    val x = (A)?::foo
    return x(A())
}


class A
fun A.foo() = "OK"
fun main(args: Array<String>) {}