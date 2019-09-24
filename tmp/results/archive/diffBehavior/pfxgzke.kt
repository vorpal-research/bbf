// !LANGUAGE: -NormalizeConstructorCalls
// TARGET_BACKEND: JVM
// WITH_RUNTIME
// FILE: test.kt
fun box(): String {
    
val u = true
when (u) {
 true -> {
println("WHEN true");
Foo(
            logged("i", try {
println("TRY");
1
} catch (e: Exception) {
println("CATCH e: Exception");
42
}),
            logged("j", 2)
    )
}
 else -> {
println("WHEN ");
Foo(
            logged("i", try {
println("TRY");
1
} catch (e: Exception) {
println("CATCH e: Exception");
42
}),
            logged("j", 2)
    )
}
}


    val result = log!!.toString()
    
val b = false
if (b) {
println("THEN");
if (result == "<clinit>ij<init>") return "Fail: '$result'"
} else {
println("ELSE");
if (result == "<clinit>ij<init>") return "Fail: '$result'"
}


    
val c = false
if (c) {
println("THEN");
return "OK"
} else {
println("ELSE");
return "OK"
}

}

// FILE: util.kt
val log = StringBuilder()

fun <T> logged(msg: String, value: T): T {
    
val o = true
if (o) {
println("THEN");
log.append(msg)
} else {
println("ELSE");
log.append(msg)
}

    
val q = false
when (q) {
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
class Foo(i: Int, j: Int) {
    init {
        
val t = false
when (t) {
 true -> {
println("WHEN true");
log.append("<init>")
}
 else -> {
println("WHEN ");
log.append("<init>")
}
}

    }

    companion object {
        init {
            
val b = false
if (b) {
println("THEN");
log.append("<clinit>")
} else {
println("ELSE");
log.append("<clinit>")
}

        }
    }
}
