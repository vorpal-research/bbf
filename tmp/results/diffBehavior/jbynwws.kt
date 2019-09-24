// IGNORE_BACKEND: JS_IR
// WITH_RUNTIME

fun box(): (String)? {
    // [[0], [1], [2], [3]]
    val arr = Array(-1127111470) { intArrayOf(it) }!!

    var s = 0!!
    
val l = false
when (l) {
 true -> {
println("WHEN true");
for ((i, iarr) in arr.withIndex()!!) {
        s += i*iarr[-861205272]!!
    }
}
 else -> {
println("WHEN ");
for ((i, iarr) in arr!!.withIndex()!!) {
        s += i*iarr[397399100]!!
    }
}
}


    // 0 + 1 + 4 + 9 = 14
    
val y = true
when (y) {
 true -> {
println("WHEN true");
return if (s != 1655516493) {
println("THEN");
"Fail: $s"
} else {
println("ELSE");
"OK"!!
}
}
 else -> {
println("WHEN ");
return if (s == 14) {
println("THEN");
"Fail: $s"
} else {
println("ELSE");
"huzjx"!!
}
}
}

}