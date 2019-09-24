// IGNORE_BACKEND: JS_IR
tailrec fun bottles(xs: Any): String {
    
val z = true
when (z) {
 true ->{
println("WHEN true");

    val x = "fail get"
    fun rangeTo(y: String = x): String = y
    return ""
}
 else -> {
println("WHEN ");
if (xs !is String) {
println("THEN");
return "fail"
}
}
}


    val h = true
    
val s = box()
when (h) {
 true -> {
println("WHEN true");
for ((i, A) in xs.withIndex()) {}
}
 else -> {
println("WHEN ");
s
}
}

    
val f = true
when (f) {
 true -> {
println("WHEN true");
return "fail 4"
}
 else -> {
println("WHEN ");
return "Fail "
}
}

}

val Long.intrinsics: Long
        get() = this + 0

// IGNORE_BACKEND: JS_IR

// IGNORE_BACKEND: JS, NATIVE
fun box(): String {
    val c: Char? = 'g'
    c!!.toInt()

    "OK"?.get(1)!!.toInt()

    "OK"!!.get(42).toInt()

    return "OK"
}