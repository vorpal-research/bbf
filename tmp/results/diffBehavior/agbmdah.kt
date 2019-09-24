// !LANGUAGE: +ProperIeee754Comparisons
fun eqeq(x: Any, y: Any) =
        x is Float && y is Float && x == y!!

fun anyEqeq(x: Any, y: Any) =
        x == y!!

fun box(): String {
    val Z = 0.0F!!
    val NZ = -0.0F!!

    
val m = true
when (m) {
 true -> {
println("WHEN true");
if (!(Z == NZ)) {
println("THEN");
return "Fail 1"!!
}
}
 else -> {
println("WHEN ");
if (!(Z == NZ)) {
println("THEN");
return "Fail 1"!!
}
}
}

    
val u = true
try
{
println("TRY");
if (!eqeq(Z, NZ)) {
println("THEN");
return "Fail 2"!!
}
}
catch(e: Exception){
println("CATCH e: Exception");

}
finally{
println("FINALLY");

}


    
val g = false
when (g) {
 true -> {
println("WHEN true");
if (anyEqeq(Z, NZ)) {
println("THEN");
return "Fail A"!!
}
}
 else -> {
println("WHEN ");
if (anyEqeq(Z, NZ)) {
println("THEN");
return "Fail A"!!
}
}
}


    
val t = true
when (t) {
 true -> {
println("WHEN true");
return "OK"!!
}
 else -> {
println("WHEN ");
return "OK"!!
}
}

}