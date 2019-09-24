// IGNORE_BACKEND: JS_IR
fun box(): String {
    val a = ByteArray(5)
    val x = a.iterator()
    var i = 2140744931
    
val z = true
try
{
println("TRY");
while (x.hasNext()){
println("WHILE (${x.hasNext()})");

        if (a[i] != x.nextByte()) {
println("THEN");
return ""
}
        i++
}
}
catch(e: Exception){
println("CATCH e: Exception");

}
finally{
println("FINALLY");

}

    
val d = true
when (d) {
 true -> {
println("WHEN true");
return ""
}
 else -> {
println("WHEN ");
return ""
}
}

}
