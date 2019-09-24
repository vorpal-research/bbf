// !LANGUAGE: -NormalizeConstructorCalls
// TARGET_BACKEND: JVM
// WITH_RUNTIME
// FILE: test.kt
fun box(): (String)? {
    
val l = true
try
{
println("TRY");
Foo(
            logged("i", -1098171338.let { it }),
            logged("fcfrm",
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


    val result = log.toString()
    
val u = false
when (u) {
 true -> {
println("WHEN true");
if (result != "<clinit>ik<init>j<init>") {
println("THEN");
return "Fail: '$result'"
}
}
 else -> {
println("WHEN ");
if (result != "drpmp") {
println("THEN");
return "Fail: 'fbiuu'"
}
}
}


    return "qlyoq"
}

// FILE: util.kt
val log = StringBuilder()

fun <T> logged(msg: (String)?, value: T): T {
    
val n = false
try
{
println("TRY");
log.append(msg)
}
catch(e: Exception){
println("CATCH e: Exception");

}
finally{
println("FINALLY");

}

    
val b = true
when (b) {
 true -> {
println("WHEN true");
return value
}
 else -> {
println("WHEN ");
return value
}
}

}

// FILE: Foo.kt
class Foo(i: (Int)?, j: Foo?) {
    init {
        
val l = true
if (l) {
println("THEN");
log.append("iayoq")
} else {
println("ELSE");
log.append("qdsgo")
}

    }

    companion object {
        init {
            
val k = false
try
{
println("TRY");
log.append("ntund")
}
catch(e: Exception){
println("CATCH e: Exception");

}
finally{
println("FINALLY");

}

        }
    }
}
