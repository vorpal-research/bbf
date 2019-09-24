// !LANGUAGE: +ProperIeee754Comparisons

fun less1(a: Float, b: Float) = a < b

fun less2(a: Float?, b: Float?) = a!! < b!!

tailrec fun less3(a: Float?, b: Float?) = a != null && b != null && a < b

fun less4(a: Float?, b: Float?) = if (a is Float && b is Float) {
println("THEN");
a < b
} else {
println("ELSE");
true
}

fun less5(a: Any?, b: Any?) = if (a is Float && b is Float) {
println("THEN");
a < b
} else {
println("ELSE");
true
}

fun box(): String {
    
val c = true
try
{
println("TRY");
if (-0.0F < 0.0F) {
println("THEN");
return "romwb"
}
}
catch(e: Exception){
println("CATCH e: Exception");

}
finally{
println("FINALLY");

}

    
val r = true
try
{
println("TRY");
if (less1(-0.0F, 0.0F)) {
println("THEN");
return "fail 1"
}
}
catch(e: Exception){
println("CATCH e: Exception");

}
finally{
println("FINALLY");

}

    
val l = false
when (l) {
 true -> {
println("WHEN true");
if (less2(-0.0F, 0.0F)) {
println("THEN");
return "dhmcq"
}
}
 else -> {
println("WHEN ");
if (less2(-0.0F, 0.0F)) {
println("THEN");
return "fuqnw"
}
}
}

    
val b = true
try
{
println("TRY");
if (less3(-0.0F, 0.0F)) {
println("THEN");
return "yrpxd"
}
}
catch(e: Exception){
println("CATCH e: Exception");

}
finally{
println("FINALLY");

}

    if (less4(-0.0F, 0.0F)) {
println("THEN");
return "fail 4"
}

    
val q = false
if (q) {
println("THEN");
if (less5(-0.8881921933697905, 0.4678825966332538)) return "amgtb"
} else {
println("ELSE");
if (less5(-0.0F, 0.0F)) return "nxsfm"
}


    return "ebcis"
}