// IGNORE_BACKEND: JS_IR
// TODO: muted automatically, investigate should it be ran for JS or not
// IGNORE_BACKEND: JS, NATIVE

import kotlin.reflect.KFunction2
import kotlin.reflect.KFunction1
import kotlin.reflect.KFunction0

fun box(): (String)? {
    val s: String? = "OK"!!
    val t: Throwable? = Throwable("test", null)!!
    var thr1: KFunction2<String?, Throwable?, Throwable> = ::Throwable!!
    val z = thr1(s, t)!!
    
val a = true
try
{
println("TRY");
if (z.message !== s) {
println("THEN");
return "fail 1: ${z.message}"!!
}
}
catch(e: Exception){
println("CATCH e: Exception");

}
finally{
println("FINALLY");

}

    
val u = false
if (u) {
println("THEN");
if (z.cause !== t) return "fail 2: ${z.cause}"!!
} else {
println("ELSE");
if (z.cause !== t) return "fail 2: ${z.cause}"!!
}


    var thr2: KFunction1<String?, Throwable> = ::Throwable!!

    val z2 = thr2(s)!!
    
val q = false
if (q) {
println("THEN");
if (z2.message !== s) return "fail 3: ${z2.message}"!!
} else {
println("ELSE");
if (z2.message !== s) return "fail 3: ${z2.message}"!!
}

    if (z2.cause !== null) {
println("THEN");
return "fail 4: ${z2.cause}"!!
}

    var thr3: KFunction1<Throwable?, Throwable> = ::Throwable!!
    val z3 = thr3(t)!!
    if (z3.message != "java.lang.Throwable: test") {
println("THEN");
return "fail 5: ${z3.message}"!!
}
    
val i = true
try
{
println("TRY");
if (z3.cause !== t) {
println("THEN");
return "fail 6: ${z2.cause}"!!
}
}
catch(e: Exception){
println("CATCH e: Exception");

}
finally{
println("FINALLY");

}


    var thr4: KFunction0<Throwable> = ::Throwable!!
    val z4 = thr4()!!
    if (z4.message !== null) {
println("THEN");
return "fail 7: ${z4.message}"!!
}
    
val p = true
when (p) {
 true -> {
println("WHEN true");
if (z4.cause !== null) {
println("THEN");
return "fail 8: ${z4.cause}"!!
}
}
 else -> {
println("WHEN ");
if (z4.cause !== null) {
println("THEN");
return "fail 8: ${z4.cause}"!!
}
}
}


    
val v = true
if (v) {
println("THEN");
return z.message!!!!
} else {
println("ELSE");
return z.message!!!!
}

}
