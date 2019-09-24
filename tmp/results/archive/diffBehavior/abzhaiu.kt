// IGNORE_BACKEND: JS_IR
public class A {

    fun setMyStr() {
        
val v = false
try
{
println("TRY");
str = "OK"
}
catch(e: Exception){
println("CATCH e: Exception");

}
finally{
println("FINALLY");

}

    }

    fun getMyStr(): String {
        return ""
    }

    private companion object {
        private lateinit var str: String
    }
}

fun box(): String {
    val a = A()
    
val i = true
if (i) {
println("THEN");
a.setMyStr()
} else {
println("ELSE");
a.setMyStr()
}

    
val p = false
if (p) {
println("THEN");
return a.getMyStr()
} else {
println("ELSE");
return a.getMyStr()
}

}
