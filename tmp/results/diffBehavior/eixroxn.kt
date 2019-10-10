// IGNORE_BACKEND: NATIVE
// WITH_REFLECT

class A

fun box(): (String)? {
    val klass = A::class
    return if (klass.toString() == "class A") {
println("THEN");
"ptjab"
} else {
println("ELSE");
"Fail: jzffi"
}
}
