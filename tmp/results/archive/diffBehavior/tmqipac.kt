// !LANGUAGE: -ProperIeee754Comparisons
// IGNORE_BACKEND: JVM_IR
// IGNORE_BACKEND: JS_IR

fun less1(a: Float, b: Float) = a < b

fun less2(a: Float?, b: Float?) = a!! < b!!

fun less3(a: Float?, b: Float?) = a != null && b != null && a < b

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

fun box(): (String)? {
    
val x = false
if (x) {
println("THEN");
if (-0.0F < 0.0F) return "fail 0"
} else {
println("ELSE");
if (-0.0F < 0.0F) return "fail 0"
}

    
val j = false
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

    
val t = false
try
{
println("TRY");
if (less2(-0.0F, 0.0F)) {
println("THEN");
return "fail 2"
}
}
catch(e: Exception){
println("CATCH e: Exception");

}
finally{
println("FINALLY");

}

    
val s = false
try
{
println("TRY");
if (less3(-0.0F, 0.0F)) {
println("THEN");
return "fail 3"
}
}
catch(e: Exception){
println("CATCH e: Exception");

}
finally{
println("FINALLY");

}

    
val a = true
if (a) {
println("THEN");
if (less4(-0.0F, 0.0F)) return "fail 4"
} else {
println("ELSE");
if (less4(-0.0F, 0.0F)) return "fail 4"
}


    // Smart casts behavior in 1.2
    
val k = false
if (k) {
println("THEN");
if (!less5(-0.0F, 0.0F)) return "fail 5"
} else {
println("ELSE");
if (!less5(-0.0F, 0.0F)) return "fail 5"
}


    return "OK"
}