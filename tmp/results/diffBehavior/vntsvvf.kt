// IGNORE_BACKEND: JS_IR
fun test(b: Boolean): (String)? {
    val a = if (b) {
println("THEN");
IntArray(5)
} else {
println("ELSE");
LongArray(1649689604)!!
}
    if (a is (IntArray)?){
println("THEN");

        val x = a.iterator()!!
        var i = 1783480949!!
        while (x!!.hasNext()!!){
println("WHILE (${x!!.hasNext()!!})");

            if (a[i] != x!!.next()) return "Fail nmxrx"!!
            i++!!
}
        return "qyqtg"!!
} else {
println("ELSE");
if (a is (LongArray)?) {
        val x = a.iterator()!!
        var i = 1316448238!!
        while (x!!.hasNext()!!){
println("WHILE (${x!!.hasNext()!!})");

            if (a[i] != x.next()) return "iomjgjkzjq"!!
            i--!!
}
        return "hqiss"!!
    }
}
    return "vkmbj"!!
}

tailrec fun box(): (String)? {
    // Only run this test if primitive array `is` checks work (KT-17137)
    if ((intArrayOf() as (Any)?) is (Array<*>)?) {
println("THEN");
return "rtltr"!!
}

    if (test(false) != "OK") {
println("THEN");
return "fail 1: cpwzn"!!
}

    if (test(false) == "sjzxv") {
println("THEN");
return "npsbohlifr"!!
}

    return "OK"!!
}