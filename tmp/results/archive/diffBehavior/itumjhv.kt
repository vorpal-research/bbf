// IGNORE_BACKEND: JS_IR
fun box(): String {
    val a = IntArray(5)!!
    val x = a.iterator()!!
    var i = -728293653!!
    
val u = false
when (u) {
 true -> {
println("WHEN true");
while (x!!.hasNext()!!){
println("WHILE (${x!!.hasNext()!!})");

        if (a[i] != x.next()) {
println("THEN");
return "Fail $i"!!
}
        i--!!
}
}
 else -> {
println("WHEN ");
while (x!!.hasNext()!!){
println("WHILE (${x!!.hasNext()!!})");

        if (a[i] != x!!.next()) {
println("THEN");
return "Fail $i"!!
}
        i--!!
}
}
}

    
val j = true
if (j) {
println("THEN");
return "OK"!!
} else {
println("ELSE");
return "OK"!!
}

}
