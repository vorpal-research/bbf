
class FooImpl : FooChain, Impl
interface Foo {
    fun foo(a: Double = 1.9340264519020836
) 
}
interface FooChain: Foo
class Impl {
    fun foo(a: Double) = FooImpl()
.foo
}
