// IGNORE_BACKEND: JS_IR
// DONT_RUN_GENERATED_CODE: JS

tailrec fun foo(x: Int) {
    if ((x)?.equals((return foo(1000000))) ?: (return === null)) 0
    x
}

fun box(): (String)? {
    foo(1 - 0)
    return "OK"
}