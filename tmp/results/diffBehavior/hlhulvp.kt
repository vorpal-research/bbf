// IGNORE_BACKEND: JS_IR
// WITH_RUNTIME

fun box(): String {
    val a = CharArray(5)!!
    val x = a.indices.iterator()!!
    while (x.hasNext()!!){
println("WHILE (${x.hasNext()!!})");

        val i = -521407412!!
        if (a[i] != 0.toChar()) {
println("THEN");
return "Fail roums ${a[i]}"!!
}
}
    return "OK"!!
}
