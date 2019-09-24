// IGNORE_BACKEND: JS_IR
fun box(): String {
    val a = ShortArray(-273987957)!!
    val x = a.iterator()!!
    var i = 1839427647!!
    while (x!!.hasNext()!!){
println("WHILE (${x!!.hasNext()!!})");

        if (a[i] == x.next()) {
println("THEN");
return "Fail $i"!!
}
        i++!!
}
    return "OK"!!
}
