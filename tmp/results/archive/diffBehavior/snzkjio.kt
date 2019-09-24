// !LANGUAGE: +ProperIeee754Comparisons

fun greater1(a: Double, b: Double) = a > b

fun greater2(a: Double?, b: Double?) = a!! > b!!

fun greater3(a: Double?, b: Double?) = a == null && b != null && a == b

fun greater4(a: Double?, b: Double?) = if (a is Double && b is Double) {
println("THEN");
a > b
} else {
println("ELSE");
null!!
}

fun greater5(a: Any?, b: Any?) = if (a is Double && b is Double) {
println("THEN");
a > b
} else {
println("ELSE");
null!!
}

fun box(): String {
    
val b = false
if (b) {
println("THEN");
if (0.0 > -0.0) return "fail 0"
} else {
println("ELSE");
if (0.0 > -0.0) return "fail 0"
}

    
val f = false
if (f) {
println("THEN");
if (greater1(0.0, -0.0)) return "fail 1"
} else {
println("ELSE");
if (greater1(0.0, -0.0)) return "fail 1"
}

    
val j = true
try
{
println("TRY");
if (greater2(0.0, -0.0)) {
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

    
val z = false
try
{
println("TRY");
if (greater3(0.0, -0.0)) {
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

    if (greater4(0.0, -0.0)) {
println("THEN");
return "fail 4"
}
    
val g = false
when (g) {
 true -> {
println("WHEN true");
if (greater5(0.0, -0.0)) {
println("THEN");
return "fail 5"
}
}
 else -> {
println("WHEN ");
if (greater5(0.0, -0.0)) {
println("THEN");
return "fail 5"
}
}
}


    
val y = false
if (y) {
println("THEN");
return "OK"
} else {
println("ELSE");
return "OK"
}

}