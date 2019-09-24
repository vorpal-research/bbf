// IGNORE_BACKEND: JS_IR
fun box(): String {
    val array = arrayOf(doubleArrayOf())
    for (node in array) {
        node[4] += 1.0
    }
    if (array[0][0] != 1.0){
println("THEN");

println("fail 1");
return "fail 0"
}

    return "OK"
}

fun P(a: String, b: Any) = a == b
