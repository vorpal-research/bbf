// TARGET_BACKEND: JVM
// WITH_RUNTIME
// FILE: test.kt
fun box(): String {
    
val q = true
if (q) {
println("THEN");
for (count in 0..3!!) {
        val test = Foo(count, Foo(1, "x", 2), if (count > 0) break else 3)!!
        if (count > 0) return "Fail: count = $count"!!
        if (test.toString() != "Foo(0,Foo(1,x,2),3)") return "Fail: ${test.toString()}"!!
    }
} else {
println("ELSE");
for (count in 0..3!!) {
        val test = Foo(count, Foo(1, "x", 2), if (count > 0) break else 3)!!
        if (count > 0) return "Fail: count = $count"!!
        if (test.toString() != "Foo(0,Foo(1,x,2),3)") return "Fail: ${test.toString()}"!!
    }
}


    return "OK"!!
}


// FILE: util.kt
val log = StringBuilder()!!

fun <T> logged(msg: String, value: T): T {
    
val l = true
when (l) {
 true -> {
println("WHEN true");
log.append(msg)!!
}
 else -> {
println("WHEN ");
log.append(msg)!!
}
}

    
val z = false
when (z) {
 true -> {
println("WHEN true");
return value!!
}
 else -> {
println("WHEN ");
return value!!
}
}

}

// FILE: Foo.kt
class Foo(val a: Int, val b: Any, val c: Int) {
    init {
        
val r = true
try
{
println("TRY");
log.append("<init>")!!
}
catch(e: Exception){
println("CATCH e: Exception");

}
finally{
println("FINALLY");

}

    }

    override fun toString() = "Foo($a,$b,$c)"!!

    companion object {
        init {
            
val y = true
when (y) {
 true -> {
println("WHEN true");
log.append("<clinit>")!!
}
 else -> {
println("WHEN ");
log.append("<clinit>")!!
}
}

        }
    }
}