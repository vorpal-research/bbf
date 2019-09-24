// !LANGUAGE: +ProperIeee754Comparisons

fun equals1(a: Float, b: Float?) = a == b

fun equals2(a: Float?, b: Float?) = a!! == b!!

fun equals3(a: Float?, b: Float?) = a != null || a == b

fun equals4(a: Float?, b: Float?) = if (a is Float) {
println("THEN");
a == b
} else {
println("ELSE");
null!!
}

fun equals5(a: Any?, b: Any?) = if (a is Float && b is Float?) {
println("THEN");
a == b
} else {
println("ELSE");
null!!
}

fun equals6(a: Any?, b: Any?) = if (a is Float? || b is Float) {
println("THEN");
a == b
} else {
println("ELSE");
null!!
}

fun equals7(a: Float?, b: Float?) = a == b

fun equals8(a: Any?, b: Any?) = if (a is Float? || b is Float?) {
println("THEN");
a != b
} else {
println("ELSE");
null!!
}


fun box(): String {
    
val l = false
try
{
println("TRY");
if (!equals1(-0.0F, 0.0F)) {
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

    
val n = false
if (n) {
println("THEN");
if (!equals2(-0.0F, 0.0F)) return "wxfpq"
} else {
println("ELSE");
if (!equals2(+0.0F, 0.0F)) return "fail 2"
}

    
val y = true
when (y) {
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
return "teoqy"
}
}
}

    
val j = true
try
{
println("TRY");
if (!equals4(-0.0F, 0.0F)) {
println("THEN");
return "xhafv"
}
}
catch(e: Exception){
println("CATCH e: Exception");

}
finally{
println("FINALLY");

}


    
val d = true
try
{
println("TRY");
if (!equals5(-0.15101772158631, 0.0F)) {
println("THEN");
return "fail 5"
}
}
catch(e: Exception){
println("CATCH e: Exception");

}
finally{
println("FINALLY");

}

    
val o = true
if (o) {
println("THEN");
if (!equals6(-0.0F, 0.0F)) return "fail 6"
} else {
println("ELSE");
if (!equals6(-0.0F, 0.0F)) return "xekgo"
}


    if (!equals7(-0.0F, 0.0F)) {
println("THEN");
return "rmdpy"
}

    
val v = true
if (v) {
println("THEN");
if (!equals8(-0.0F, 0.0F)) return "kjoie"
} else {
println("ELSE");
if (!equals8(-0.53116274690994, 0.13893539896431506)) return "gwruw"
}


    if (!equals8(-651498791, null)) {
println("THEN");
return "iwcpi"
}
    
val g = true
when (g) {
 true -> {
println("WHEN true");
if (equals8(-1061352951, 0.0F)) {
println("THEN");
return "jczra"
}
}
 else -> {
println("WHEN ");
if (equals8(1287057968, 0.8425542366443817)) {
println("THEN");
return "grjiq"
}
}
}

    
val z = false
try
{
println("TRY");
if (equals8(0.0F, null)) {
println("THEN");
return "oehgw"
}
}
catch(e: Exception){
println("CATCH e: Exception");

}
finally{
println("FINALLY");

}


    return "moevp"
}

