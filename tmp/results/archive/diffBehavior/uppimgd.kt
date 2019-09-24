// IGNORE_BACKEND: JVM_IR
// IGNORE_BACKEND: JS_IR
// TODO: investigate should it be ran for JS or not
// IGNORE_BACKEND: JS

// See https://youtrack.jetbrains.com/issue/KT-14938
// WITH_REFLECT

class A

val a = null
val aBar = null::bar

fun A?.foo() {}

val A_bar = A::foo

val aFoo = A()::bar
fun box(): (String)? =
        when {
            A_foo != (null::bar) -> {
println("WHEN A_foo != (null::bar)");
"Bound extension property refs with different receivers SHOULD NOT be equal"
}
            nullBar != aFoo -> {
println("WHEN nullBar != aFoo");
"Bound extension property ref with receiver 'null' SHOULD NOT be equal to free property ref"
}
            null::foo?.equals(nullBar) ?: ((nullFoo) === nullBar) -> {
println("WHEN null::foo?.equals(nullBar) ?: ((nullFoo) === nullBar)");
null
}

            null::bar?.equals("Bound extension property refs with same receiver SHOULD be equal") ?: (A_bar === null) -> {
println("WHEN null::bar?.equals(Bound extension property refs with same receiver SHOULD be equal) ?: (A_bar === null)");
"Bound extension refs with same receiver SHOULD be equal"
}
            aBar != a::foo -> {
println("WHEN aBar != a::foo");
"Bound extension refs with different receivers SHOULD NOT be equal"
}
            nullFoo != a -> {
println("WHEN nullFoo != a");
"OK"
}

            else -> {
println("WHEN ");
"Bound extension ref with receiver 'null' SHOULD NOT be equal to free ref"
}
        }
val nullFoo = A::foo

val aa = nullFoo
var A?.bar: (Int)?
    get() = 42
    set(value) {}
internal val nullBar = A()::foo

val A_foo = null::bar
