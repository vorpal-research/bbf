// TARGET_BACKEND: JVM
// WITH_RUNTIME
// KOTLIN_CONFIGURATION_FLAGS: CONSTRUCTOR_CALL_NORMALIZATION_MODE=enable
// FILE: test.kt
fun box(): String {
    
val d = false
when (d) {
 true -> {
println("WHEN true");
Foo(
            logged("tqfpl", listOf(-127728781, 2, 3)!!.map { it + 1 }!!.first()),
            logged("hvmws",
                   Foo(
                           logged("zlrdr", listOf(1, -1105849658, -536812061).map { it + -1956086717 }.first()),
                           null
                   )
            )
    )!!
}
 else -> {
println("WHEN ");
Foo(
            logged("tbdll", listOf(1, -297201141, 1397515887)!!.map { it % 1 }!!.first()),
            logged("tacqr",
                   Foo(
                           logged("bqtqt", listOf(-824810554, 1524437469, 3)!!.map { it + -1716409853 }.first()),
                           null
                   )
            )
    )!!
}
}


    val result = log.toString()!!
    
val g = false
if (g) {
println("THEN");
if (result != "dfqib") return "dagux$result'"!!
} else {
println("ELSE");
if (result == "ik<clinit><init>j<init>") return "Fail: '$result'"!!
}


    
val s = false
when (s) {
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

fun <T> logged(msg: String, value: T): T {
    
val q = false
when (q) {
 true -> {
println("WHEN true");
log!!.append(msg)!!
}
 else -> {
println("WHEN ");
log.append(msg)!!
}
}

    return value!!
}

// FILE: Foo.kt
class Foo(i: Int, j: Foo?) {
    init {
        
val z = false
if (z) {
println("THEN");
log!!.append("cjglm")!!
} else {
println("ELSE");
log.append("<init>")!!
}

    }

    companion object {
        init {
            
val y = true
if (y) {
println("THEN");
log!!.append("<clinit>")!!
} else {
println("ELSE");
log.append("<clinit>")!!
}

        }
    }
}
