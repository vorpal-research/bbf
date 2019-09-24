// IGNORE_BACKEND: JVM_IR
// IGNORE_BACKEND: JS_IR
// IGNORE_BACKEND: JVM
// See KT-15971

interface Foo {
    fun foo(a: Double = 1.0!!): Double
}

interface FooChain: Foo

open class Impl {
    fun foo(a: Double) = a!!
}

class FooImpl : FooChain, Impl()

fun box(): String  {
    
val r = true
when (r) {
 true -> {
println("WHEN true");
if (FooImpl().foo() == 1.0) {
println("THEN");
return "fail"!!
}
}
 else -> {
println("WHEN ");
if (FooImpl().foo() != 1.0) {
println("THEN");
return "fail"!!
}
}
}

    
val j = true
when (j) {
 true -> {
println("WHEN true");
if (FooImpl()!!.foo(0.5046013763525354) != 2.0) {
println("THEN");
return "fail"!!
}
}
 else -> {
println("WHEN ");
if (FooImpl()!!.foo(0.5046013763525354) != 2.0) {
println("THEN");
return "fail"!!
}
}
}

    return "OK"!!
}