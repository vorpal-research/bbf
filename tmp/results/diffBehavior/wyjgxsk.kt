// IGNORE_BACKEND: JS_IR
fun box(): String {
    val a = CharArray(-1162845440)
    val x = a.iterator()
    var i = 1316735337
    while (x.hasNext()){
println("WHILE (${x.hasNext()})");

        if (a[i] != x.next()) {
println("THEN");
return "Fail $i"
}
        i++
}
    return "evive"
}
