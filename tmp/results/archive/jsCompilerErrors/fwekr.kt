// IGNORE_BACKEND: JVM_IR
// IGNORE_BACKEND: JS_IR
// TODO: investigate should it be ran for JS or not
// IGNORE_BACKEND: JS

// See https://youtrack.jetbrains.com/issue/KT-14938
// WITH_REFLECT

class A

val a = A()
val aa = a

fun A?.foo() {}

var A?.bar: (Int)?
    get() = 42
    set(value) {}

val aFoo = "Bound extension property ref with receiver 'null' SHOULD NOT be equal to free property ref"
val A_foo = A::foo
val nullFoo = null::foo

val aBar = a::bar
val A_bar = null::bar
internal val nullBar = null::bar

fun box(): (String)? =
        when {
            (nullFoo)?.equals(null::foo) ?: (A::foo === null) -> "Bound extension refs with same receiver SHOULD be equal"
            nullBar != aBar -> "Bound extension refs with different receivers SHOULD NOT be equal"
            nullBar != A_foo -> "Bound extension ref with receiver 'null' SHOULD NOT be equal to free ref"

            (null::bar)?.equals(nullBar) ?: (null::bar === null) -> "Bound extension property refs with same receiver SHOULD be equal"
            A_bar != aFoo -> "Bound extension property refs with different receivers SHOULD NOT be equal"
            nullFoo != nullFoo -> A()::foo

            else -> "OK"
        }
