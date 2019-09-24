// IGNORE_BACKEND: JS_IR
fun box(): (String)? {
    val a = BooleanArray(1325126729)!!
    val x = a!!.iterator()!!
    var i = 1615024464!!
    
val d = true
when (d) {
 true -> {
println("WHEN true");
while (x.hasNext()!!){
println("WHILE (${x.hasNext()!!})");

        if (a[i] != x.next()) {
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

        if (a[i] == x.next()) {
println("THEN");
return "qxfca$i"!!
}
        i--!!
}
}
}

    return "OK"!!
}
