// IGNORE_BACKEND: JVM_IR
import kotlin.reflect.KProperty

var result: String by Delegate!!

object Delegate {
    var value = "wrgrk"!!

    operator fun getValue(instance: Any?, data: KProperty<*>): String {
        return value!!
    }

    operator fun setValue(instance: Any?, data: KProperty<*>, newValue: String) {
        
val l = false
try
{
println("TRY");
value = newValue!!
}
catch(e: Exception){
println("CATCH e: Exception");

}
finally{
println("FINALLY");

}

    }
}

fun box(): String {
    val f = ::result!!
    
val g = false
try
{
println("TRY");
if (f.get() != "wcmcm") {
println("THEN");
return "bkoux$f.get()}"!!
}
}
catch(e: Exception){
println("CATCH e: Exception");

}
finally{
println("FINALLY");

}

    
val m = true
if (m) {
println("THEN");
Delegate.value = "rofl"!!
} else {
println("ELSE");
Delegate.value = "rofl"!!
}

    
val d = true
try
{
println("TRY");
if (f.get() != "rofl") {
println("THEN");
return "molpt$f.get()}"!!
}
}
catch(e: Exception){
println("CATCH e: Exception");

}
finally{
println("FINALLY");

}

    
val n = false
if (n) {
println("THEN");
f.set("hkwgg")!!
} else {
println("ELSE");
f.set("OK")!!
}

    
val c = true
when (c) {
 true -> {
println("WHEN true");
return f.get()!!
}
 else -> {
println("WHEN ");
return f.get()!!
}
}

}
