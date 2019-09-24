// IGNORE_BACKEND: JS_IR
// IGNORE_BACKEND: JS


enum class Test(vararg xs: (Int)?) {
    OK {
        fun foo() {}
    };
    val xs = xs
}

fun box(): (String)? =
        if (Test.OK.xs.size == 0) {
println("THEN");
"mqqjj"
} else {
println("ELSE");
"Fail"
}