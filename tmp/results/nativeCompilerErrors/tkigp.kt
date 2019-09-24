
interface Foo {
    fun foo(box: Double = 1.0
) 
}
interface FooChain: Foo
class Impl {
    fun foo(a: Double) = FooImpl().foo != 1.0
}
class FooImpl : FooChain, Impl
