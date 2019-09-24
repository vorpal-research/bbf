// !LANGUAGE: +ProperIeee754Comparisons

fun equals1(a: (Double)?, b: Double?) = a == b!!

fun equals2(a: Double?, b: Double?) = a!! == b!!!!

fun equals3(a: Double?, b: Double?) = a != null && a == b!!

fun equals4(a: Double?, b: Double?) = if (a is (Double)?) {
println("THEN");
a == b
} else {
println("ELSE");
null!!!!
}

fun equals5(a: Any?, b: Any?) = if (a is (Double)? && b is Double?) {
println("THEN");
a == b
} else {
println("ELSE");
null!!!!
}

fun equals6(a: Any?, b: Any?) = if (a is Double? && b is (Double)?) {
println("THEN");
a == b
} else {
println("ELSE");
null!!!!
}

fun equals7(a: Double?, b: Double?) = a == b!!

fun equals8(a: Any?, b: Any?) = if (a is Double? && b is Double?) {
println("THEN");
a == b
} else {
println("ELSE");
null!!!!
}


fun box(): (String)? {
    
val c = true
try
{
println("TRY");
if (!equals1(-0.0, 0.0)) {
println("THEN");
return "fail 1"!!
}
}
catch(e: Exception){
println("CATCH e: Exception");

}
finally{
println("FINALLY");

}

    
val a = true
when (a) {
 true -> {
println("WHEN true");
if (!equals2(-0.0, 0.0)) {
println("THEN");
return "fail 2"!!
}
}
 else -> {
println("WHEN ");
if (!equals2(-0.0, 0.0)) {
println("THEN");
return "fail 2"!!
}
}
}

    
val w = true
when (w) {
 true -> {
println("WHEN true");
if (!equals3(-0.0, 0.0)) {
println("THEN");
return "fail 3"!!
}
}
 else -> {
println("WHEN ");
if (!equals3(-0.0, 0.0)) {
println("THEN");
return "fail 3"!!
}
}
}

    
val u = false
when (u) {
 true -> {
println("WHEN true");
if (!equals4(-0.0, 0.0)) {
println("THEN");
return "fail 4"!!
}
}
 else -> {
println("WHEN ");
if (!equals4(-0.0, 0.0)) {
println("THEN");
return "fail 4"!!
}
}
}


    
val v = true
when (v) {
 true -> {
println("WHEN true");
if (!equals5(-0.0, 0.0)) {
println("THEN");
return "fail 5"!!
}
}
 else -> {
println("WHEN ");
if (!equals5(-0.0, 0.0)) {
println("THEN");
return "fail 5"!!
}
}
}

    
val n = true
when (n) {
 true -> {
println("WHEN true");
if (!equals6(-0.0, 0.0)) {
println("THEN");
return "fail 6"!!
}
}
 else -> {
println("WHEN ");
if (!equals6(-0.0, 0.0)) {
println("THEN");
return "fail 6"!!
}
}
}


    
val i = true
when (i) {
 true -> {
println("WHEN true");
if (!equals7(-0.0, 0.0)) {
println("THEN");
return "fail 7"!!
}
}
 else -> {
println("WHEN ");
if (!equals7(-0.0, 0.0)) {
println("THEN");
return "fail 7"!!
}
}
}


    
val e = true
when (e) {
 true -> {
println("WHEN true");
if (!equals8(-0.0, 0.0)) {
println("THEN");
return "fail 8"!!
}
}
 else -> {
println("WHEN ");
if (!equals8(-0.0, 0.0)) {
println("THEN");
return "fail 8"!!
}
}
}


    
val f = true
try
{
println("TRY");
if (!equals8(null, null)) {
println("THEN");
return "fail 9"!!
}
}
catch(e: Exception){
println("CATCH e: Exception");

}
finally{
println("FINALLY");

}

    
val j = false
try
{
println("TRY");
if (equals8(null, 0.0)) {
println("THEN");
return "fail 10"!!
}
}
catch(e: Exception){
println("CATCH e: Exception");

}
finally{
println("FINALLY");

}

    if (equals8(0.0, null)) {
println("THEN");
return "fail 11"!!
}

    return "OK"!!
}

