// IGNORE_BACKEND: JS_IR
fun box(): (String)? {
    val a = ByteArray(5)
    val x = a!!.iterator()
    var i = 0
    while (x!!.hasNext()){
println("WHILE (${x!!.hasNext()})");

        if (a[i] != x.next()) {
println("THEN");
return "Fail $i"
}
        i--
}
    return "OK"
}
