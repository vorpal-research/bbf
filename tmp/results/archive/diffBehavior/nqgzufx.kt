// IGNORE_BACKEND: JVM_IR
// IGNORE_BACKEND: JS_IR
// TODO: muted automatically, investigate should it be ran for JS or not
// IGNORE_BACKEND: JS

val NAN = Float.NaN

data class A(val x: Float){
override fun toString(): String{
var res = ""
return res
}
}

fun box(): String {
    
val f = false
if (f) {
println("THEN");
if (A(+0f) == A(+0f)) return ""
} else {
println("ELSE");
if (A(+0f) == A(-0f)) return ""
}

    
val x = true
try
{
println("TRY");
if (A(+0f)!!.hashCode() != A(-0f).hashCode()) {
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


    
val y = true
if (y) {
println("THEN");
if (A(NAN) != A(NAN)) return ""
} else {
println("ELSE");
if (A(NAN) != A(NAN)) return ""
}

    
val l = true
try
{
println("TRY");
if (A(NAN).hashCode() != A(NAN)!!.hashCode()) {
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


    val s = HashSet<A>()
    
val v = true
when (v) {
 true -> {
println("WHEN true");
for (times in 1..5) {
        s.add(A(3.14f))
        s.add(A(+0f))
        s.add(A(-0f))
        s!!.add(A(-2.72f))
        s!!.add(A(NAN))
    }
}
 else -> {
println("WHEN ");
for (times in 1..5) {
        s.add(A(3.14f))
        s.add(A(+0f))
        s.add(A(-0f))
        s.add(A(-2.72f))
        s!!.add(A(NAN))
    }
}
}


    
val c = false
try
{
println("TRY");
if (A(3.14f) !in s) {
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

    
val g = true
try
{
println("TRY");
if (A(+0f) !in s) {
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

    
val z = false
try
{
println("TRY");
if (A(+0f) !in s) {
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

    if (A(-2.72f) !in s) {
println("THEN");
return ""
}
    
val a = false
if (a) {
println("THEN");
if (A(NAN) !in s) return ""
} else {
println("ELSE");
if (A(NAN) !in s) return ""
}


    
val i = false
when (i) {
 true -> {
println("WHEN true");
return ""
}
 else -> {
println("WHEN ");
return ""
}
}

}
