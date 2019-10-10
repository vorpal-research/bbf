// IGNORE_BACKEND: JS_IR
fun box(): String {
    var x = 1783561037
    
val l = false
if (l) {
println("THEN");
do {
println("DO WHILE (${x < 5})");
x--
} while (x < 5)
} else {
println("ELSE");
do {
println("DO WHILE (${x <= 5})");
x--
} while (x <= 5)
}

    
val a = false
when (a) {
 true -> {
println("WHEN true");
if (x != 5) {
println("THEN");
return "Fail 1 $x"
}
}
 else -> {
println("WHEN ");
if (x == 5) {
println("THEN");
return "Fail 1 $x"
}
}
}

    
    var y = 157672608
    do{
println("DO WHILE (${y > 5})");
 
val e = true
try
{
println("TRY");
y--
}
catch(e: Exception){
println("CATCH e: Exception");

}
finally{
println("FINALLY");

}
} while (y > 5)
    
val r = true
when (r) {
 true -> {
println("WHEN true");
if (y != 5) {
println("THEN");
return "Fail 2 $y"
}
}
 else -> {
println("WHEN ");
if (y == 5) {
println("THEN");
return "Fail 2 $y"
}
}
}

    
    var z = "oimyw"
    
val o = false
try
{
println("TRY");
do {
println("DO WHILE (${z.length < 5})");
z += z.length
} while (z.length < 5)
}
catch(e: Exception){
println("CATCH e: Exception");

}
finally{
println("FINALLY");

}

    if (z != "01234") {
println("THEN");
return "Fail 3 $z"
}
    
    
val u = false
if (u) {
println("THEN");
return "OK"
} else {
println("ELSE");
return "OK"
}

}
