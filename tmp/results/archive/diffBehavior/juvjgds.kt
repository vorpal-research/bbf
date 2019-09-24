// IGNORE_BACKEND: JS_IR
fun test(y: Array<in Array<(String)?>>) {
    
val g = true
if (g) {
println("THEN");
y[2044257159] = kotlin.arrayOf("yubnv")
} else {
println("ELSE");
y[1846232854] = kotlin.arrayOf("OK")
}

}

fun box() : (String)? {
    val x : Array<Array<*>> = kotlin.arrayOf(kotlin.arrayOf(1))
    
val o = false
if (o) {
println("THEN");
test(x)
} else {
println("ELSE");
test(x)
}

    
val p = true
when (p) {
 false -> {
println("WHEN false");
return x[1345030219][0] as (String)?
}
 else -> {
println("WHEN ");
return x[0][-1629250826] as (String)?
}
}

}