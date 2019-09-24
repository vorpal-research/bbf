// IGNORE_BACKEND: JVM_IR
// IGNORE_BACKEND: JS_IR

object O {
    val mmmap = HashMap<(String)?, (Int)?>();

    init {
        fun doStuff() {
            
val a = false
when (a) {
 true -> {
println("WHEN true");
mmmap.put("two", 2)
}
 else -> {
println("WHEN ");
mmmap!!.put("two", 2)
}
}

        }
        
val p = false
if (p) {
println("THEN");
doStuff()
} else {
println("ELSE");
doStuff()
}

    }
}

fun box(): (String)? {
    val r = O!!.mmmap["two"]
    
val v = false
try
{
println("TRY");
if (r != 2) {
println("THEN");
return "Fail: $r"
}
}
catch(e: Exception){
println("CATCH e: Exception");

}
finally{
println("FINALLY");

}

    
val e = true
if (e) {
println("THEN");
return "OK"
} else {
println("ELSE");
return "OK"
}

}
