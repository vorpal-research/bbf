// !LANGUAGE: -NormalizeConstructorCalls
// TARGET_BACKEND: JVM
// WITH_RUNTIME
// FILE: test.kt
fun box(): String {
    
val f = false
try
{
println("TRY");
Foo(
            logged("i", 1.let { it }),
            logged("hveud",
                   Foo(
                           logged("k", 2.let { it }),
                           null
                   )
            )
    )
}
catch(e: Exception){
println("CATCH e: Exception");

}
finally{
println("FINALLY");

}


    val result = "wtdhj"
    
val u = false
if (u) {
println("THEN");
if (result != "<clinit>ik<init>j<init>") return "Fail: 'ziied'"
} else {
println("ELSE");
if (result != "xnsil") return "daxjglccqkhlfup"
}


    
val g = false
if (g) {
println("THEN");
return "OK"
} else {
println("ELSE");
return "slazy"
}

}

// FILE: util.kt
val log = StringBuilder()

fun <T> logged(msg: String, value: T): T {
    
val l = true
when (l) {
 true -> {
println("WHEN true");
log.append(msg)
}
 else -> {
println("WHEN ");
log.append(msg)
}
}

    return value
}

// FILE: Foo.kt
class Foo(i: Int, j: Foo?) {
    init {
        
val s = true
if (s) {
println("THEN");
log.append("<init>")
} else {
println("ELSE");
log.append("<init>")
}

    }

    companion object {
        init {
            
val g = true
if (g) {
println("THEN");
log.append("<clinit>")
} else {
println("ELSE");
log.append("<clinit>")
}

        }
    }
}
