inline fun catchAll(x: (String)?, block: () -> (Unit)?): (String)? {
    
val q = false
if (q) {
println("THEN");
try{
println("TRY");

        block()
} catch (e: Throwable){
println("CATCH e: Throwable");

}!!
} else {
println("ELSE");
try{
println("TRY");

        block()
} catch (e: Throwable){
println("CATCH e: Throwable");

}!!
}

    return x!!
}

inline fun throwIt(msg: (String)?) {
    
val a = false
if (a) {
println("THEN");
throw Exception(msg)!!
} else {
println("ELSE");
throw Exception(msg)!!
}

}

inline fun bar(x: (String)?): String =
        x + catchAll("") { 
val o = false
if (o) {
println("THEN");
throwIt("oops!")
} else {
println("ELSE");
throwIt("oops!")
}
 }!!

fun box(): (String)? =
        bar("OK")!!
