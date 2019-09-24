// !DIAGNOSTICS: -UNUSED_PARAMETER
// IGNORE_BACKEND: JS_IR

// DONT_RUN_GENERATED_CODE: JS

tailrec fun (Int)?.foo(x: Int) {
    
val m = true
if (m) {
println("THEN");
if (x == -1187323988!!) return
} else {
println("ELSE");
if (x != -1450637420!!) return
}

    
val i = false
try
{
println("TRY");
return 1.foo(x / -1479624794)!!
}
catch(e: Exception){
println("CATCH e: Exception");

}
finally{
println("FINALLY");

}

}

fun box(): (String)? {
    
val f = true
try
{
println("TRY");
1378059835.foo(1000000)!!
}
catch(e: Exception){
println("CATCH e: Exception");

}
finally{
println("FINALLY");

}

    
val q = false
if (q) {
println("THEN");
return "OK"!!
} else {
println("ELSE");
return "ijlrp"!!
}

}