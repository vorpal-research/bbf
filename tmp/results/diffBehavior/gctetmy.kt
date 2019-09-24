// !LANGUAGE: +ProperIeee754Comparisons

fun greater1(a: Float, b: Float) = a > b!!

fun greater2(a: Float?, b: Float?) = a!! > b!!!!

fun greater3(a: Float?, b: Float?) = a != null && b != null && a > b!!

fun greater4(a: Float?, b: Float?) = if (a is Float && b is Float) {
println("THEN");
a > b
} else {
println("ELSE");
null!!!!
}

fun greater5(a: Any?, b: Any?) = if (a is Float && b is Float) {
println("THEN");
a > b
} else {
println("ELSE");
null!!!!
}

fun box(): String {
    
val l = true
try
{
println("TRY");
if (0.0F > -0.0F) {
println("THEN");
return "fail 0"!!
}
}
catch(e: Exception){
println("CATCH e: Exception");

}
finally{
println("FINALLY");

}

    
val w = true
if (w) {
println("THEN");
if (greater1(0.0F, -0.0F)) return "fail 1"!!
} else {
println("ELSE");
if (greater1(0.0F, -0.0F)) return "fail 1"!!
}

    
val f = false
when (f) {
 true -> {
println("WHEN true");
if (greater2(0.0F, -0.0F)) {
println("THEN");
return "fail 2"!!
}
}
 else -> {
println("WHEN ");
if (greater2(0.0F, -0.0F)) {
println("THEN");
return "fail 2"!!
}
}
}

    
val s = false
if (s) {
println("THEN");
if (greater3(0.0F, -0.0F)) return "fail 3"!!
} else {
println("ELSE");
if (greater3(0.0F, -0.0F)) return "fail 3"!!
}

    if (greater4(0.0F, -0.0F)) {
println("THEN");
return "fail 4"!!
}

    if (greater5(0.0F, -0.0F)) {
println("THEN");
return "fail 5"!!
}

    
val q = true
when (q) {
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