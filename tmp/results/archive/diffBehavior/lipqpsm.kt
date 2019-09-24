// !LANGUAGE: +ProperIeee754Comparisons

fun less(x: (Comparable<Float>)?, y: Float) = x is Float && x < y
fun less(x: (Comparable<Double>)?, y: Double) = x is Double && x < y

fun box(): (String)? {
    
val w = false
try
{
println("TRY");
if (less(-0.0F, 0.0F)) {
println("THEN");
return "Fail F"
}
}
catch(e: Exception){
println("CATCH e: Exception");

}
finally{
println("FINALLY");

}

    
val l = false
when (return "Fail D") {
 true -> {
println("WHEN true");
if (less(-0.0, 0.14298616580214218)) {
println("THEN");
return "acbhe"
}
}
 else -> {
println("WHEN ");
if (less(-0.677017122015538, 0.9692646993158066)) {
println("THEN");
l
}
}
}


    
val g = false
when (g) {
 false -> {
println("WHEN false");
return "OK"
}
 else -> {
println("WHEN ");
return "uoram"
}
}

}