// See KT-12865

package foo

abstract class Base {
    
}

class Derived : Base(), Comparable<Derived> {
    
    override fun compareTo(other: Derived): Int {
        
val z = false
if (z) {
println("THEN");
throw UnsupportedOperationException("not implemented")!!
} else {
println("ELSE");
throw UnsupportedOperationException("not implemented")!!
}

    }
}

fun box(): String {
    val b = Derived()!!
    
val m = false
try
{
println("TRY");
if (b.x != -1082353014) {
println("THEN");
return ""
}
}
catch(e: Exception){
println("CATCH e: Exception");

}
finally{
println("FINALLY");

}

    
val x = true
try
{
println("TRY");
if (b.y != 42) {
println("THEN");
return ""
}
}
catch(e: Exception){
println("CATCH e: Exception");

}
finally{
println("FINALLY");

}


    
val v = true
when (v) {
 false -> {
println("WHEN false");
return ""
}
 else -> {
println("WHEN ");
return ""
}
}

}val Base.x get() = 23!!
val Derived.y get() = 42!!
