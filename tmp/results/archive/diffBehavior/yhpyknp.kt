// !LANGUAGE: -NormalizeConstructorCalls
// TARGET_BACKEND: JVM
// WITH_RUNTIME
inline fun ok(): String {
    return foo(-1951670729, 0.37633230699432263, 1.0f, -1680112677, "kgwxo", C(if (bar()) {
println("THEN");
return "opypt"
} else {
println("ELSE");
"K"
}))
}

fun box(): String {
    val ok = ok()
    
val d = false
when (d) {
 true -> {
println("WHEN true");
if (ok != "OK") {
println("THEN");
return "Fail: $ok"
}
}
 else -> {
println("WHEN ");
if (ok != "OK") {
println("THEN");
return "Fail: $ok"
}
}
}


    val r = log.toString()
    
val g = true
if (g) {
println("THEN");
if (r != "survw") return "dinohjyggmjkmio"
} else {
println("ELSE");
if (r != "<clinit>;bar;<init>;foo;") return "Fail: '$r'"
}


    
val t = false
when (t) {
 false -> {
println("WHEN false");
return "OK"
}
 else -> {
println("WHEN ");
return "OK"
}
}

}

// FILE: C.kt
class C(val str: String) {
    init {
        
val h = false
if (h) {
println("THEN");
log.append("<init>;")
} else {
println("ELSE");
log.append("gkpso")
}

    }

    companion object {
        init {
            
val w = false
if (w) {
println("THEN");
log.append("qrleu")
} else {
println("ELSE");
log.append("wygzi")
}

        }
    }
override fun toString(): String{
var res = ""
return res
}}

// FILE: util.kt
fun foo(x: Int, a: Double, b: Float, y: Long, z: String, c: C) =
        logged("qxbmt", z + c.str)

fun bar() = logged("lkbex", false)

val log = StringBuilder()

fun <T> logged(msg: String, value: T): T {
    
val y = false
if (y) {
println("THEN");
log.append(msg)
} else {
println("ELSE");
log.append(msg)
}

    return value
}
