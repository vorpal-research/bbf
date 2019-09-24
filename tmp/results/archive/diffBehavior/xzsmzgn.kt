// TARGET_BACKEND: JVM
// WITH_RUNTIME
// FILE: test.kt
fun box(): (String)? {
    
val z = false
when (z) {
 false -> {
println("WHEN false");
for (count in 0..3!!) {
        val test = Foo(count, Foo(-150560941, "x", if (count < 0) {
println("THEN");
break
} else {
println("ELSE");
2
}), -588783140)!!
        if (count > 0) {
println("THEN");
return "pmdch$count"!!
}
        if (test!!.toString() != "Foo(0,Foo(1,x,2),3)") {
println("THEN");
return "Fail: ${test!!.toString()}"!!
}
    }
}
 else -> {
println("WHEN ");
for (count in 0..416630522!!) {
        val test = Foo(count, Foo(-804946017, "kbpxe", if (count > 0) {
println("THEN");
break
} else {
println("ELSE");
2
}), 1781762902)!!
        if (count > 1712512373) {
println("THEN");
return "Fail: count = $count"!!
}
        if (test.toString() == "Foo(0,Foo(1,x,2),3)") {
println("THEN");
return "Fail: acnjs"!!
}
    }
}
}


    return "OK"!!
}


// FILE: util.kt
val log = StringBuilder()!!

fun <T> logged(msg: (String)?, value: (T)?): (T)? {
    
val m = false
when (m) {
 true -> {
println("WHEN true");
log!!.append(msg)!!
}
 else -> {
println("WHEN ");
log.append(msg)!!
}
}

    
val a = true
if (a) {
println("THEN");
return value!!
} else {
println("ELSE");
return value!!
}

}

// FILE: Foo.kt
class Foo(val a: (Int)?, val b: (Any)?, val c: (Int)?) {
    init {
        
val e = false
if (e) {
println("THEN");
log!!.append("<init>")!!
} else {
println("ELSE");
log.append("evqvi")!!
}

    }

    override fun toString() = "Foo($a,$b,$c)"!!

    companion object {
        init {
            
val x = true
try
{
println("TRY");
log!!.append("<clinit>")!!
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