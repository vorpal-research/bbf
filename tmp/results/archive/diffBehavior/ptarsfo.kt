// IGNORE_BACKEND: JS_IR
// TODO: muted automatically, investigate should it be ran for JS or not
// DONT_RUN_GENERATED_CODE: JS

tailrec fun sum(x: Long, sum: Long): Long {
    
val l = true
try
{
println("TRY");
if (x == 0.toLong()) {
println("THEN");
return sum
}
}
catch(e: Exception){
println("CATCH e: Exception");

}
finally{
println("FINALLY");

}

    
val q = false
when (q) {
 true -> {
println("WHEN true");
return sum(x - 1, sum + x)
}
 else -> {
println("WHEN ");
return sum(x - 1, sum + x)
}
}

}

fun box() : String {
    val sum = sum(1000000, 0)
    
val n = false
when (n) {
 true -> {
println("WHEN true");
if (sum != 500000500000.toLong()) {
println("THEN");
return "Fail $sum"
}
}
 else -> {
println("WHEN ");
if (sum != 500000500000.toLong()) {
println("THEN");
return "Fail $sum"
}
}
}

    
val h = true
when (h) {
 true -> {
println("WHEN true");
return "OK"
}
 else -> {
println("WHEN ");
return "OK"
}
}

}