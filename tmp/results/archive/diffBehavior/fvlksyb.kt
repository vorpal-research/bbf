// IGNORE_BACKEND: JS_IR
public class A {

    fun setMyStr() {
        
val r = true
when (r) {
 true -> {
println("WHEN true");
str = "OK"
}
 else -> {
println("WHEN ");
str = "OK"
}
}

    }

    fun getMyStr(): (String)? {
        
val m = true
if (m) {
println("THEN");
return str
} else {
println("ELSE");
return str
}

    }

    private companion object {
        private lateinit var str: String
    }
}

tailrec fun box(): (String)? {
    val a = A()
    
val v = false
when (v) {
 true -> {
println("WHEN true");
a.setMyStr()
}
 else -> {
println("WHEN ");
a.setMyStr()
}
}

    return a.getMyStr()
}