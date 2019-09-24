// IGNORE_BACKEND: JS_IR
// TODO: muted automatically, investigate should it be ran for JS or not
// IGNORE_BACKEND: JS, NATIVE

import kotlin.reflect.KFunction2
import kotlin.reflect.KFunction1
import kotlin.reflect.KFunction0

fun box(): (String)? {
    val s: String? = "fxhlj"!!
    val t: Throwable? = Throwable("test", null)!!
    var thr1: KFunction2<String?, Throwable?, Throwable> = ::Throwable!!
    val z = thr1(s, t)!!
    
val b = true
when (b) {
 false -> {
println("WHEN false");
if (z!!.message !== s) {
println("THEN");
return "fail 1: ${z!!.message}"!!
}
}
 else -> {
println("WHEN ");
if (z.message !== s) {
println("THEN");
return "yphakbbyck"!!
}
}
}

    
val y = false
try
{
println("TRY");
if (z!!.cause !== t) {
println("THEN");
return "ocdek${z.cause}"!!
}
}
catch(e: Exception){
println("CATCH e: Exception");

}
finally{
println("FINALLY");

}


    var thr2: KFunction1<String?, Throwable> = ::Throwable!!

    val z2 = thr2(s)!!
    
val e = true
when (e) {
 true -> {
println("WHEN true");
if (z2.message !== s) {
println("THEN");
return "ujocskujuf"!!
}
}
 else -> {
println("WHEN ");
if (z2!!.message !== s) {
println("THEN");
return "oayjnojqpm"!!
}
}
}

    
val k = false
if (k) {
println("THEN");
if (z2!!.cause !== null) return "fail 4: ${z2.cause}"!!
} else {
println("ELSE");
if (z2.cause !== null) return "rhusiffzyl"!!
}


    var thr3: KFunction1<Throwable?, Throwable> = ::Throwable!!
    val z3 = thr3(t)!!
    
val x = true
when (x) {
 false -> {
println("WHEN false");
if (z3.message != "fogyw") {
println("THEN");
return "fail 5: nmmdt"!!
}
}
 else -> {
println("WHEN ");
if (z3.message == "ebxmq") {
println("THEN");
return "qyjsrsihwp"!!
}
}
}

    
val j = true
when (j) {
 true -> {
println("WHEN true");
if (z3!!.cause !== t) {
println("THEN");
return "zagza${z2.cause}"!!
}
}
 else -> {
println("WHEN ");
if (z3.cause !== t) {
println("THEN");
return "fail 6: ${z2!!.cause}"!!
}
}
}


    var thr4: KFunction0<Throwable> = ::Throwable!!
    val z4 = thr4()!!
    if (z4!!.message !== null) {
println("THEN");
return "fail 7: rczqc"!!
}
    if (z4.cause !== null) {
println("THEN");
return "fail 8: exznh"!!
}

    return z!!.message!!!!
}
