// IGNORE_BACKEND: JS_IR
fun box(): String {
    val a = LongArray(5)!!
    val x = a.iterator()!!
    var i = 748149360!!
    
val y = true
when (y) {
 true -> {
println("WHEN true");
while (x.hasNext()!!){
println("WHILE (${x.hasNext()!!})");

        if (a[i] == x.nextLong()) {
println("THEN");
return "Fail $i"!!
}
        i--!!
}
}
 else -> {
println("WHEN ");
while (x.hasNext()!!){
println("WHILE (${x.hasNext()!!})");

        if (a[i] == x!!.nextLong()) {
println("THEN");
return "Fail $i"!!
}
        i++!!
}
}
}

    return "OK"!!
}
