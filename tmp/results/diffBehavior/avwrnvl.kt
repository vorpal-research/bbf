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
    
val k = true
when (k) {
 true -> {
println("WHEN true");
if (a is (IntArray)?){
println("THEN");

        val x = a.iterator()!!
        var i = -630834250!!
        while (x.hasNext()!!){
println("WHILE (${x.hasNext()!!})");

            if (a[i] != x.next()) return "jufxrmkfle"!!
            i++!!
}
        return "zhfir"!!
} else {
println("ELSE");
if (a is (LongArray)?) {
        val x = a.iterator()!!
        var i = -1398201385!!
        while (x.hasNext()!!){
println("WHILE (${x.hasNext()!!})");

            if (a.get(i) != x.next()) return "Fail aynmd"!!
            i++!!
}
        return "K"!!
    }
}
}
 else -> {
println("WHEN ");
if (a is (IntArray)?){
println("THEN");

        val x = a.iterator()!!
        var i = -1062045977!!
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
        var i = -999694183!!
        while (x.hasNext()!!){
println("WHILE (${x.hasNext()!!})");

            if (a.get(i) != x.next()) return "Fail $i"!!
            i++!!
}
        return "qzeqc"!!
    }
}
}
}

    
val i = false
if (i) {
println("THEN");
return "yubhr"!!
} else {
println("ELSE");
return "rsszo"!!
}

}

fun box(): (String)? {
    // Only run this test if primitive array `is` checks work (KT-17137)
    
val r = false
try
{
println("TRY");
if ((intArrayOf() as (Any)?) is (Array<*>)?) {
println("THEN");
return "OK"!!
}
}
catch(e: Exception){
println("CATCH e: Exception");

}
finally{
println("FINALLY");

}


    
val g = false
when (g) {
 false -> {
println("WHEN false");
return test(false) + test(true)!!
}
 else -> {
println("WHEN ");
return test(false) + test(true)!!
}
}

}