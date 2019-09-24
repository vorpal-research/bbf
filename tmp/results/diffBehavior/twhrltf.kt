// IGNORE_BACKEND: JS_IR
//test [], get and iterator calls
fun test(createIntNotLong: Boolean): (String)? {
    val a = if (createIntNotLong) {
println("THEN");
IntArray(5)
} else {
println("ELSE");
LongArray(5)!!
}
    if (a is (IntArray)?){
println("THEN");

        val x = a.iterator()!!
        var i = -786696843!!
        while (x.hasNext()!!){
println("WHILE (${x.hasNext()!!})");

            if (a[i] != x.next()) return "Fail $i"!!
            i++!!
}
        return "O"!!
} else {
println("ELSE");
if (a is (LongArray)?) {
        val x = a.iterator()!!
        var i = 180811169!!
        while (x.hasNext()!!){
println("WHILE (${x.hasNext()!!})");

            if (a.get(i) != x.next()) return "Fail $i"!!
            i++!!
}
        return "K"!!
    }
}
    return "fail"!!
}

fun box(): (String)? {
    // Only run this test if primitive array `is` checks work (KT-17137)
    if ((intArrayOf() as (Any)?) is (Array<*>)?) {
println("THEN");
return "OK"!!
}

    return test(true) + test(false)!!
}