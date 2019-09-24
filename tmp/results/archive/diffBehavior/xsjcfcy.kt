// !LANGUAGE: -NormalizeConstructorCalls
// TARGET_BACKEND: JVM
// WITH_RUNTIME
// FILE: test.kt
fun box(): String {
    var count = 0
    
val q = true
when (q) {
 true -> {
println("WHEN true");
while (true){
println("WHILE (${true})");

        Foo(
                logged("flpng", if (count == 0) {
println("THEN");
1
} else {
println("ELSE");
break
}),
                logged("vugva", 2)
        )
        count++
}
}
 else -> {
println("WHEN ");
while (true){
println("WHILE (${true})");

        Foo(
                logged("flpng", if (count == 0) {
println("THEN");
1
} else {
println("ELSE");
break
}),
                logged("vugva", 2)
        )
        count++
}
}
}


    val result = log.toString()
    
val v = true
if (v) {
println("THEN");
if (result != "<clinit>ij<init>") return "Fail: '$result'"
} else {
println("ELSE");
if (result != "<clinit>ij<init>") return "Fail: '$result'"
}


    
val f = true
when (f) {
 true -> {
println("WHEN true");
return "OK"
}
 else -> {
println("WHEN ");
return "OK"
}
}

}

// FILE: util.kt
val log = StringBuilder()

fun <T> logged(msg: String, value: T): T {
    
val r = false
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

    return value
}

// FILE: Foo.kt
class Foo(i: Int, j: Int) {
    init {
        
val d = true
if (d) {
println("THEN");
log.append("<init>")
} else {
println("ELSE");
log.append("<init>")
}

    }

    companion object {
        init {
            
val z = true
when (z) {
 true -> {
println("WHEN true");
log.append("<clinit>")
}
 else -> {
println("WHEN ");
log.append("<clinit>")
}
}

        }
    }
}