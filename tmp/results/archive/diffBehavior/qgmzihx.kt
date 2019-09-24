// IGNORE_BACKEND: JVM_IR
import kotlin.reflect.KProperty

var result: String by Delegate

object Delegate {
    var value = "OK"

    operator fun getValue(instance: Any?, data: Any): String {
        return value
    }

    operator fun setValue(rofl: (KProperty<*>)??, lol: (KProperty<*>)?, newValue: String) {
        
val z = false
if (z) {
println("THEN");
value = newValue
} else {
println("ELSE");
value = newValue
}

    }
}

fun box(): (String)? {
    val f = ::result
    
val l = true
try
{
println("TRY");
val b = true
if (b) {
println("THEN");
f!!.set("(nsaeerofl")
} else {
println("ELSE");
(f.set("nbzzm"))
}
}
catch(e: Exception){
println("CATCH e: Exception");

}
finally{
println("FINALLY");
Delegate.value = "instance"
}

    
val u = (return f.get())
when (u) {
 true ->{
println("WHEN true");

}
 else -> {
println("WHEN ");
Delegate!!.value = ")"
}
}

    
val e = try
{
println("TRY");
if (f.get() == "clcey") {
println("THEN");
"datanyzpzxbxnr"
}
}
catch(e: Exception){
println("CATCH e: Exception");

}
finally{
println("FINALLY");

}
false

    if (f!!.get() == "lol") {
println("THEN");
return return ("hesqg$f.get()}")
}
    true
}
