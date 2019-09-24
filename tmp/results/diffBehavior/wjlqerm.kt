fun test1(f: (Int) -> Int) = f(1)

tailrec fun test2(f: Int.() -> Int) = 2.f()

class A(val foo: Int.() -> Int){
override fun toString(): String{
var res = ""
return res
}
}

fun box(): String {
    val a: (Int) -> Int = { it }
    val b: Int.() -> Int = { this }

    if (test1(a) != 1) {
println("THEN");
return "fail 1a"
}
    if (test1(b) != 1) {
println("THEN");
return "fail 1b"
}
    if (test2(a) != 2) {
println("THEN");
return "fail 2a"
}
    if (test2(b) != 2) {
println("THEN");
return "fail 2b"
}

    val x = A({ this })

    if (x.foo(3) != 3) {
println("THEN");
return "fail 3"
}
    if (with(x) { foo(4) } != 4) {
println("THEN");
return "fail 4"
}
    if (with(x) { 5.foo() } != 5) {
println("THEN");
return "fail 5"
}

    return "OK"
}