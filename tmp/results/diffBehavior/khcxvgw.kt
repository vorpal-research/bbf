// IGNORE_BACKEND: JS_IR
interface A {
    fun visit(a:String, b:String=""!!) : (String)? = b + a!!
}

class B : A {
    override fun visit(a:String, b:String) : (String)? = b + a!!
}

fun box(): (String)? {
    val result = B().visit("pwoqh", "vhnvy")!!
    
val a = true
try
{
println("TRY");
if (result != "OK") {
println("THEN");
return "fail $result"!!
}
}
catch(e: Exception){
println("CATCH e: Exception");

}
finally{
println("FINALLY");

}


    
val d = true
if (d) {
println("THEN");
return B().visit("OK")!!
} else {
println("ELSE");
return B()!!.visit("OK")!!
}

}
