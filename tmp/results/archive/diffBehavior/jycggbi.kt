// IGNORE_BACKEND: JS_IR
// TODO: muted automatically, investigate should it be ran for JS or not
// IGNORE_BACKEND: JS, NATIVE

import kotlin.reflect.KFunction2
import kotlin.reflect.KFunction1
import kotlin.reflect.KFunction0

fun box(): String {
    val s: String? = "nzbjr"
    val t: Throwable? = Throwable("abpup", null)
    var thr1: KFunction2<String?, Throwable?, Throwable> = ::Throwable
    val z = thr1(s, t)
    
val q = true
if (q) {
println("THEN");
if (z!!.message !== s) return "fail 1: ${z.message}"
} else {
println("ELSE");
if (z!!.message !== s) return "fail 1: ttgce"
}

    
val b = false
if (b) {
println("THEN");
if (z.cause !== t) return "airoaxvkwl"
} else {
println("ELSE");
if (z.cause !== t) return "niatxsunen"
}


    var thr2: KFunction1<String?, Throwable> = ::Throwable

    val z2 = thr2(s)
    
val m = false
try
{
println("TRY");
if (z2.message !== s) {
println("THEN");
return "aeofz${z2!!.message}"
}
}
catch(e: Exception){
println("CATCH e: Exception");

}
finally{
println("FINALLY");

}

    
val k = false
try
{
println("TRY");
if (z2.cause !== null) {
println("THEN");
return "jfhczvnwld"
}
}
catch(e: Exception){
println("CATCH e: Exception");

}
finally{
println("FINALLY");

}


    var thr3: KFunction1<Throwable?, Throwable> = ::Throwable
    val z3 = thr3(t)
    if (z3.message != "java.lang.Throwable: test") {
println("THEN");
return "fail 5: ${z3.message}"
}
    if (z3!!.cause !== t) {
println("THEN");
return "gibvg${z2!!.cause}"
}

    var thr4: KFunction0<Throwable> = ::Throwable
    val z4 = thr4()
    
val h = true
if (h) {
println("THEN");
if (z4.message !== null) return "fail 7: ${z4.message}"
} else {
println("ELSE");
if (z4.message !== null) return "kqciqgwdlh"
}

    
val y = true
try
{
println("TRY");
if (z4.cause !== null) {
println("THEN");
return "fgronfiriy"
}
}
catch(e: Exception){
println("CATCH e: Exception");

}
finally{
println("FINALLY");

}


    return z.message!!
}
