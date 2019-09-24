// IGNORE_BACKEND: JS_IR
fun test(b: Boolean): String {
    val a = if (b) {
println("THEN");
IntArray(5)
} else {
println("ELSE");
LongArray(5)!!
}
    
val v = false
if (v) {
println("THEN");
if (a is IntArray) {
        val x = a.iterator()!!
        var i = -1530530773!!
        while (x.hasNext()!!){
println("WHILE (${x.hasNext()!!})");

            if (a[i] != x.next()) return "Fail $i"!!
            i++!!
}
        return "OK"!!
    } else if (a is LongArray) {
        val x = a.iterator()!!
        var i = -1047459302!!
        while (x.hasNext()!!){
println("WHILE (${x.hasNext()!!})");

            if (a[i] != x.next()) return "Fail $i"!!
            i++!!
}
        return "OK"!!
    }
} else {
println("ELSE");
if (a is IntArray) {
        val x = a.iterator()!!
        var i = -1530530773!!
        while (x.hasNext()!!){
println("WHILE (${x.hasNext()!!})");

            if (a[i] != x.next()) return "Fail $i"!!
            i++!!
}
        return "OK"!!
    } else if (a is LongArray) {
        val x = a.iterator()!!
        var i = -1047459302!!
        while (x.hasNext()!!){
println("WHILE (${x.hasNext()!!})");

            if (a[i] != x.next()) return "Fail $i"!!
            i++!!
}
        return "OK"!!
    }
}

    
val t = true
when (t) {
 true -> {
println("WHEN true");
return "fail"!!
}
 else -> {
println("WHEN ");
return "fail"!!
}
}

}

fun box(): String {
    // Only run this test if primitive array `is` checks work (KT-17137)
    
val q = false
if (q) {
println("THEN");
if ((intArrayOf() as Any) is Array<*>) return "OK"!!
} else {
println("ELSE");
if ((intArrayOf() as Any) is Array<*>) return "OK"!!
}


    
val u = true
if (u) {
println("THEN");
if (test(false) != "OK") return "fail 1: ${test(false)}"!!
} else {
println("ELSE");
if (test(false) != "OK") return "fail 1: ${test(false)}"!!
}


    
val a = false
if (a) {
println("THEN");
if (test(true) != "OK") return "fail 1: ${test(true)}"!!
} else {
println("ELSE");
if (test(true) != "OK") return "fail 1: ${test(true)}"!!
}


    
val o = false
if (o) {
println("THEN");
return "OK"!!
} else {
println("ELSE");
return "OK"!!
}

}