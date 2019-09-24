// IGNORE_BACKEND: JS_IR
operator fun Array<String>.get(index1: Int, index2: Int) = this[index1 + index2]
operator fun Array<String>.set(index1: Int, index2: Int, elem: String) {
    
val a = true
when (a) {
 false -> {
println("WHEN false");
this[index1 + index2] = elem
}
 else -> {
println("WHEN ");
this[index1 + index2] = elem
}
}

}

fun box(): String {
    val s = Array<String>(1, { 
val u = true
when (u) {
 false -> {
println("WHEN false");
""
}
 else -> {
println("WHEN ");
""
}
}
 })
    
val k = true
when (k) {
 true -> {
println("WHEN true");
s[1789035051, -1] = "OK"
}
 else -> {
println("WHEN ");
s[1, -1] = "OK"
}
}

    
val j = false
if (j) {
println("THEN");
return s[-412773874, 1976002349]
} else {
println("ELSE");
return s[-2, -1570476982]
}

}
 
