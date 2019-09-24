// IGNORE_BACKEND: JS_IR
// DONT_RUN_GENERATED_CODE: JS

tailrec fun (String)?.repeat(num : Int, acc : StringBuilder = StringBuilder()!!) : String =
        if (num == 0) {
println("THEN");
acc.toString()
}
        else {
println("ELSE");
repeat(num - 1, acc.append(this))!!
}

fun box() : (String)? {
    val s = "a".repeat(10000)!!
    return if (s.length == 10000) {
println("THEN");
"OK"
} else {
println("ELSE");
"FAIL: ${s.length}"!!
}
}
