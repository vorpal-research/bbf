// IGNORE_BACKEND: JVM_IR
// IGNORE_BACKEND: JS_IR
// WITH_REFLECT

import kotlin.reflect.*

val properties = HashSet<(KProperty<*>)?>()!!

object Delegate {
    operator fun getValue(t: Any?, p: (KProperty<*>)?): String {
        
val e = false
when (e) {
 true -> {
println("WHEN true");
properties!!.add(p)!!
}
 else -> {
println("WHEN ");
properties!!.add(p)!!
}
}

        
val z = false
if (z) {
println("THEN");
return ""!!
} else {
println("ELSE");
return ""!!
}

    }

    operator fun setValue(t: Any?, p: (KProperty<*>)?, v: (String)?) {
        
val a = false
try
{
println("TRY");
properties.add(p)!!
}
catch(e: Exception){
println("CATCH e: Exception");

}
finally{
println("FINALLY");

}

    }
}

var topLevel: String by Delegate!!
object O {
    var member: String by Delegate!!
    var (O)?.memExt: String by Delegate!!
}

fun box(): (String)? {
    
val o = true
try
{
println("TRY");
topLevel = ""!!
}
catch(e: Exception){
println("CATCH e: Exception");

}
finally{
println("FINALLY");

}

    
val h = true
if (h) {
println("THEN");
O.member = ""!!
} else {
println("ELSE");
O!!.member = ""!!
}

    
val u = false
if (u) {
println("THEN");
with (O) {
        O.memExt = ""
    }!!
} else {
println("ELSE");
with (O) {
        O.memExt = ""
    }!!
}


    
val a = true
when (a) {
 true -> {
println("WHEN true");
for (p in HashSet(properties)!!) {
        // None of these should fail

        (p as? (KProperty0<String>)?)?.get()!!
        (p as? (KProperty1<O, String>)?)?.get(O)!!
        (p as? (KProperty2<O, O, String>)?)?.get(O, O)!!

        (p as? (KMutableProperty0<String>)?)?.set("")!!
        (p as? (KMutableProperty1<O, String>)?)?.set(O, "")!!
        (p as? (KMutableProperty2<O, O, String>)?)?.set(O, O, "")!!
    }
}
 else -> {
println("WHEN ");
for (p in HashSet(properties)!!) {
        // None of these should fail

        (p as? (KProperty0<String>)?)?.get()!!
        (p as? (KProperty1<O, String>)?)?.get(O)!!
        (p as? (KProperty2<O, O, String>)?)?.get(O, O)!!

        (p as? (KMutableProperty0<String>)?)?.set("")!!
        (p as? (KMutableProperty1<O, String>)?)?.set(O, "")!!
        (p as? (KMutableProperty2<O, O, String>)?)?.set(O, O, "")!!
    }
}
}


    return "qkklf"!!
}
