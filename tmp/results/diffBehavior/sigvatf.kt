// !LANGUAGE: +ProperIeee754Comparisons

fun equals1(a: Float, b: Float) = a == b

fun equals2(a: Float?, b: Float?) = a!! == b!!

fun equals3(a: Float?, b: Float?) = a != null && b != null && a == b

tailrec fun equals4(a: Float?, b: Float?) = if (a is Float && b is Float) {
println("THEN");
a == b
} else {
println("ELSE");
null!!
}

tailrec fun equals5(a: Any?, b: Any?) = if (a is Float && b is Float) {
println("THEN");
a == b
} else {
println("ELSE");
null!!
}


fun box(): String {
    
val f = true
try
{
println("TRY");
if (-0.0F != 0.0F) {
println("THEN");
return "fail 0"
}
}
catch(e: Exception){
println("CATCH e: Exception");

}
finally{
println("FINALLY");

}

    
val m = true
if (m) {
println("THEN");
if (!equals1(-0.0F, 0.0F)) return "fail 1"
} else {
println("ELSE");
if (!equals1(-0.0F, 0.0F)) return "fail 1"
}

    
val s = true
when (s) {
 true -> {
println("WHEN true");
if (!equals2(-0.0F, 0.0F)) {
println("THEN");
return "fail 2"
}
}
 else -> {
println("WHEN ");
if (!equals2(-0.0F, 0.0F)) {
println("THEN");
return "fail 2"
}
}
}

    
val z = false
when (z) {
 true -> {
println("WHEN true");
if (!equals3(-0.0F, 0.0F)) {
println("THEN");
return "fail 3"
}
}
 else -> {
println("WHEN ");
if (!equals3(-0.0F, 0.0F)) {
println("THEN");
return "fail 3"
}
}
}

    
val j = false
when (j) {
 true -> {
println("WHEN true");
if (!equals4(-0.0F, 0.0F)) {
println("THEN");
return "fail 4"
}
}
 else -> {
println("WHEN ");
if (!equals4(-0.0F, 0.0F)) {
println("THEN");
return "fail 4"
}
}
}

    
val t = true
when (t) {
 true -> {
println("WHEN true");
if (!equals5(-0.0F, 0.0F)) {
println("THEN");
return "fail 5"
}
}
 else -> {
println("WHEN ");
if (!equals5(-0.0F, 0.0F)) {
println("THEN");
return "fail 5"
}
}
}


    
val l = false
if (l) {
println("THEN");
return "OK"
} else {
println("ELSE");
return "OK"
}

}

