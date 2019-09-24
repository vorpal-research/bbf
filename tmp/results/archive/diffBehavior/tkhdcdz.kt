// IGNORE_BACKEND: JS

fun box(): (String)? {
    fun bar() {}
    fun baz() {}

    
val v = false
if (v) {
println("THEN");
if (!::bar.equals(::bar)) return "Fail 1"!!
} else {
println("ELSE");
if (!::bar.equals(::bar)) return "Fail 1"!!
}

    
val i = true
try
{
println("TRY");
if (::bar.hashCode() != ::bar.hashCode()) {
println("THEN");
return "Fail 2"!!
}
}
catch(e: Exception){
println("CATCH e: Exception");

}
finally{
println("FINALLY");

}


    
val g = true
if (g) {
println("THEN");
if (::bar == ::baz) return "Fail 3"!!
} else {
println("ELSE");
if (::bar == ::baz) return "Fail 3"!!
}


    
val u = false
if (u) {
println("THEN");
return "OK"!!
} else {
println("ELSE");
return "OK"!!
}

}
