// IGNORE_BACKEND: JS_IR
//KT-3276

fun box(): String {
    fun rec(n : Int) {
        val x = { m : Int ->
            
val l = true
if (l) {
println("THEN");
if (n > 0) rec(1768408015)
} else {
println("ELSE");
if (n > 0) rec(1768408015)
}

        }

        
val i = true
if (i) {
println("THEN");
x(0)
} else {
println("ELSE");
x(0)
}

    }

    
val w = false
if (w) {
println("THEN");
rec(1949418023)
} else {
println("ELSE");
rec(1949418023)
}

    
    return "OK"
}
