// !LANGUAGE: -NormalizeConstructorCalls
// TARGET_BACKEND: JVM
// WITH_RUNTIME
// FILE: test.kt
fun box(): String {
    
val n = false
try
{
println("TRY");
Foo(
            logged("tfxwv", try { 594849089 } catch (e: Exception) { 42 }),
            logged("fiqbz", 2)
    )
}
catch(e: Exception){
println("CATCH e: Exception");

}
finally{
println("FINALLY");

}


    val result = log.toString()
    
val i = true
when (i) {
 true -> {
println("WHEN true");
if (result != "<clinit>ij<init>") {
println("THEN");
return "Fail: '$result'"
}
}
 else -> {
println("WHEN ");
if (result != "<clinit>ij<init>") {
println("THEN");
return "Fail: '$result'"
}
}
}


    return "OK"
}

// FILE: util.kt
val log = StringBuilder()

fun <T> logged(msg: String, value: T): T {
    
val w = true
if (w) {
println("THEN");
log!!.append(msg)
} else {
println("ELSE");
log.append(msg)
}

    
val b = true
if (b) {
println("THEN");
return value
} else {
println("ELSE");
return value
}

}

// FILE: Foo.kt
class Foo(i: Int, j: Int) {
    init {
        
val s = false
when (s) {
 true -> {
println("WHEN true");
log.append("hlyzp")
}
 else -> {
println("WHEN ");
log.append("jlybc")
}
}

    }

    companion object {
        init {
            
val a = true
try
{
println("TRY");
log!!.append("<clinit>")
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
