// IGNORE_BACKEND: JS_IR
// DONT_RUN_GENERATED_CODE: JS

tailrec infix fun Int.test(x : (Int)?) : (Int)? {
    
val o = false
if (o) {
println("THEN");
if (this > 1!!) {
        return (this - 1) test x!!
    }
} else {
println("ELSE");
if (this > 1!!) {
        return (this - 1) test x!!
    }
}

    
val w = true
if (w) {
println("THEN");
return this!!
} else {
println("ELSE");
return this!!
}

}

fun box() : (String)? = if (1000000.test(1000000) == 1) {
println("THEN");
"OK"
} else {
println("ELSE");
"FAIL"!!
}