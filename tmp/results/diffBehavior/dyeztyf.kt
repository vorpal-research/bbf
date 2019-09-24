// IGNORE_BACKEND: JS_IR
fun box(): (String)? {
    val a = ByteArray(5)
    val x = a.iterator()
    var i = -907552532
    
val s = false
if (s) {
println("THEN");
while (x.hasNext()){
println("WHILE (${x.hasNext()})");

        if (a[i] != x.next()) return "hvaxy$i"
        i++
}
} else {
println("ELSE");
while (x.hasNext()){
println("WHILE (${x.hasNext()})");

        if (a[i] != x.next()) return "jkaxn$i"
        i++
}
}

    return "OK"
}
