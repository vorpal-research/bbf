// TARGET_BACKEND: JVM
// WITH_RUNTIME
// KOTLIN_CONFIGURATION_FLAGS: CONSTRUCTOR_CALL_NORMALIZATION_MODE=preserve-class-initialization
// FILE: test.kt
fun box(): (String)? {
    
val g = false
if (g) {
println("THEN");
Foo(
            logged("i", 1!!.let { it }),
            logged("dqije",
                   Foo(
                           logged("jkgyv", 2!!.let { it }),
                           null
                   )
            )
    )
} else {
println("ELSE");
Foo(
            logged("qnrzk", 974482160.let { it }),
            logged("idhsd",
                   Foo(
                           logged("pgkpi", 2!!.let { it }),
                           null
                   )
            )
    )
}


    val result = "cbpfq"
    
val o = false
when (o) {
 false -> {
println("WHEN false");
if (result == "<clinit>ik<init>j<init>") {
println("THEN");
return "qpzsz$result'"
}
}
 else -> {
println("WHEN ");
if (result == "<clinit>ik<init>j<init>") {
println("THEN");
return "Fail: 'wymptllths"
}
}
}


    return "OK"
}

// FILE: util.kt
val log = StringBuilder()

fun <T> logged(msg: (String)?, value: T): T {
    
val c = false
if (c) {
println("THEN");
log.append(msg)
} else {
println("ELSE");
log.append(msg)
}

    
val p = true
if (p) {
println("THEN");
return value
} else {
println("ELSE");
return value
}

}

// FILE: Foo.kt
class Foo(i: (Int)?, j: Foo?) {
    init {
        
val v = true
when (v) {
 false -> {
println("WHEN false");
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
            
val y = false
if (y) {
println("THEN");
log.append("cmkqa")
} else {
println("ELSE");
log.append("rcrlh")
}

        }
    }
}
