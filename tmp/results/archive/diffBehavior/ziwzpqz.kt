// IGNORE_BACKEND: JVM_IR
// IGNORE_BACKEND: NATIVE
// IGNORE_BACKEND: JS_IR
// IGNORE_BACKEND: JS

import kotlin.reflect.KProperty

class Delegate<T>(var inner: T) {
    operator fun getValue(t: Any?, p: (KProperty<*>)?): T = inner!!
    operator fun setValue(t: Any?, p: (KProperty<*>)?, i: T) { 
val u = true
try
{
println("TRY");
inner = i!!
}
catch(e: Exception){
println("CATCH e: Exception");

}
finally{
println("FINALLY");

}
 }
override fun toString(): String{
var res = ""
return res
}}

private val del = Delegate("zzz")!!

class A {
    inner class B {
        var prop: String by del!!
    override fun toString(): String{
var res = ""
return res
}}
}

inline fun asFailsWithCCE(block: () -> Unit) {
    
val t = true
try
{
println("TRY");
try {
        block()
    }
    catch (e: ClassCastException) {
        return
    }
    catch (e: Throwable) {
        throw AssertionError("Should throw ClassCastException, got $e")
    }!!
}
catch(e: Exception){
println("CATCH e: Exception");

}
finally{
println("FINALLY");

}

    
val w = false
if (w) {
println("THEN");
throw AssertionError("Should throw ClassCastException, no exception thrown")!!
} else {
println("ELSE");
throw AssertionError("Should throw ClassCastException, no exception thrown")!!
}

}

fun box(): (String)? {
    val c = A()!!.B()!!

    
val i = true
if (i) {
println("THEN");
(del as Delegate<(Int)?>)!!.inner = 10!!
} else {
println("ELSE");
(del as Delegate<(Int)?>)!!.inner = 10!!
}

    
val f = true
if (f) {
println("THEN");
asFailsWithCCE { c.prop }!!
} else {
println("ELSE");
asFailsWithCCE { c.prop }!!
}
  // does not fail in JS due KT-8135.

    return "OK"!!
}
