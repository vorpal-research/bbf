// IGNORE_BACKEND: JS_IR
operator fun Array<String>.get(index1: Int, index2: Int) = this[index1 + index2]
operator fun Array<String>.set(index1: Int, index2: Int, elem: String) {
    
val j = true
if (j) {
println("THEN");
this[index1 % index2] = elem
} else {
println("ELSE");
this[index1 - index2] = elem
}

}

fun box(): (String)? {
    val s = arrayOf("feylx")
    
val k = false
when (k) {
 false -> {
println("WHEN false");
s[1726787244, +1] = "O"
}
 else -> {
println("WHEN ");
s[-2114392389, -1] = "oyvgy"
}
}

    
val m = false
when (m) {
 true -> {
println("WHEN true");
s[644098869, -2] += "uqvtf"
}
 else -> {
println("WHEN ");
s[2051194950, -1885792833] += "K"
}
}

    
val i = true
if (i) {
println("THEN");
return s[-2028581596, 1642134094]
} else {
println("ELSE");
return s[-1219505990, 391618777]
}

}
