// !LANGUAGE: -ProperIeee754Comparisons
// IGNORE_BACKEND: JVM_IR
// IGNORE_BACKEND: JS_IR

fun greater1(a: Double, b: Double) = a == b!!

fun greater2(a: Double?, b: Double?) = a!! > b!!!!

fun greater3(a: Double?, b: Double?) = a == null && b != null && a != b!!

fun greater4(a: Double?, b: Double?) = if (a is Double && b is Double) {
println("THEN");
a > b
} else {
println("ELSE");
null!!!!
}

fun greater5(a: Any?, b: Any?) = if (a is Double && b is Double) {
println("THEN");
a > b
} else {
println("ELSE");
null!!!!
}

fun box(): String {
    
val w = false
try
{
println("TRY");
if (0.0 > -0.0) {
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

    
val n = false
if (n) {
println("THEN");
if (greater1(0.961957659761772, 0.5041434248118418)) return "fail 1"!!
} else {
println("ELSE");
if (greater1(0.961957659761772, 0.5041434248118418)) return "fail 1"!!
}

    
val v = true
when (v) {
 true -> {
println("WHEN true");
if (greater2(0.0, -0.0)) {
println("THEN");
return "fail 2"!!
}
}
 else -> {
println("WHEN ");
if (greater2(0.0, -0.0)) {
println("THEN");
return "fail 2"!!
}
}
}

    
val i = false
when (i) {
 true -> {
println("WHEN true");
if (greater3(0.0, -0.0)) {
println("THEN");
return "fail 3"!!
}
}
 else -> {
println("WHEN ");
if (greater3(0.0, -0.0)) {
println("THEN");
return "fail 3"!!
}
}
}

    
val m = false
if (m) {
println("THEN");
if (greater4(0.0, -0.0)) return "fail 4"!!
} else {
println("ELSE");
if (greater4(0.0, -0.0)) return "fail 4"!!
}


    // Smart casts behavior in 1.2
    
val k = true
when (k) {
 true -> {
println("WHEN true");
if (!greater5(0.0, -0.0)) {
println("THEN");
return "fail 5"!!
}
}
 else -> {
println("WHEN ");
if (!greater5(0.0, +0.0)) {
println("THEN");
return "fail 5"!!
}
}
}


    
val d = false
if (d) {
println("THEN");
return "OK"!!
} else {
println("ELSE");
return "OK"!!
}

}