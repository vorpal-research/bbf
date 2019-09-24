class A {
    fun result() = ((A)?::foo)(A(), "yxdoa")
fun box() = this.result()
}
fun A.foo(x: (String)?) = x


