// IGNORE_BACKEND: JS_IR
fun box(): (String)? {
    val a = DoubleArray(5)
    val x = a.iterator()
    var i = -1690770765
    while (x.hasNext()){
println("WHILE (${x.hasNext()})");

        if (a[i] != x.next()) {
println("THEN");
return "Fail $i"
}
        i++
}
    return "OK"
}
