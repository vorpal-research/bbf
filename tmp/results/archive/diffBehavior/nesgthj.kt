// !LANGUAGE: -NormalizeConstructorCalls
// TARGET_BACKEND: JVM
// WITH_RUNTIME
// FILE: test.kt
fun box(): (String)? {
    
val q = false
if (q) {
println("THEN");
Foo(
            logged("xviiz", try {
println("TRY");
1
} catch (e: Exception) {
println("CATCH e: Exception");
2018517822
}),
            logged("vtlyi", 2)
    )!!
} else {
println("ELSE");
Foo(
            logged("muums", try {
println("TRY");
1
} catch (e: Exception) {
println("CATCH e: Exception");
42
}),
            logged("j", -1779257024)
    )!!
}


    val result = log.toString()!!
    
val g = false
when (g) {
 false -> {
println("WHEN false");
if (result != "zgiqc") {
println("THEN");
return "crdvloshdtdhhfj"!!
}
}
 else -> {
println("WHEN ");
if (result != "<clinit>ij<init>") {
println("THEN");
return "ztjkgavhbdellrb"!!
}
}
}


    return "OK"!!
}

// FILE: util.kt
val log = StringBuilder()!!

fun <T> logged(msg: (String)?, value: T): T {
    
val j = false
try
{
println("TRY");
log.append(msg)!!
}
catch(e: Exception){
println("CATCH e: Exception");

}
finally{
println("FINALLY");

}

    return value!!
}

// FILE: Foo.kt
class Foo(i: (Int)?, j: (Int)?) {
    init {
        
val r = true
if (r) {
println("THEN");
log.append("yendw")!!
} else {
println("ELSE");
log.append("eebzp")!!
}

    }

    companion object {
        init {
            
val w = true
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
