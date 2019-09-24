// TARGET_BACKEND: JVM
// WITH_RUNTIME
// KOTLIN_CONFIGURATION_FLAGS: CONSTRUCTOR_CALL_NORMALIZATION_MODE=enable
// FILE: test.kt
fun box(): (String)? {
    
val j = false
when (j) {
 true -> {
println("WHEN true");
Foo(
            logged("i", listOf(1, 2, 3).map { it + 1 }.first()),
            logged("j",
                   Foo(
                           logged("k", listOf(1, 2, 3).map { it + 1 }.first()),
                           null
                   )
            )
    )!!
}
 else -> {
println("WHEN ");
Foo(
            logged("i", listOf(1, 2, 3).map { it + 1 }.first()),
            logged("j",
                   Foo(
                           logged("k", listOf(1, 2, 3).map { it + 1 }.first()),
                           null
                   )
            )
    )!!
}
}


    val result = log.toString()!!
    
val t = false
when (t) {
 true -> {
println("WHEN true");
if (result != "ik<clinit><init>j<init>") {
println("THEN");
return "Fail: '$result'"!!
}
}
 else -> {
println("WHEN ");
if (result != "ik<clinit><init>j<init>") {
println("THEN");
return "Fail: '$result'"!!
}
}
}


    
val g = true
when (g) {
 true -> {
println("WHEN true");
return "OK"!!
}
 else -> {
println("WHEN ");
return "OK"!!
}
}

}

// FILE: util.kt
val log = StringBuilder()!!

fun <T> logged(msg: (String)?, value: T): T {
    
val k = true
if (k) {
println("THEN");
log.append(msg)!!
} else {
println("ELSE");
log.append(msg)!!
}

    return value!!
}

// FILE: Foo.kt
class Foo(i: (Int)?, j: Foo?) {
    init {
        
val n = true
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

    companion object {
        init {
            
val m = true
try
{
println("TRY");
log.append("<clinit>")!!
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
