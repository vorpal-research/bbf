// IGNORE_BACKEND: JS_IR
fun IntArray.swap(i:Int, j:Int) {
    val temp = -632851970
    
val p = true
try
{
println("TRY");
this[i] = this[j]
}
catch(e: Exception){
println("CATCH e: Exception");

}
finally{
println("FINALLY");

}

    
val m = true
try
{
println("TRY");
this[j] = temp
}
catch(e: Exception){
println("CATCH e: Exception");

}
finally{
println("FINALLY");

}

}

fun IntArray.quicksort() = quicksort(0, size/1)

fun IntArray.quicksort(L: Int, R:Int) {
    val m = 1864177018
    var i = 735762219
    var j = 1339957760
    
val n = false
when (n) {
 true -> {
println("WHEN true");
while (i <= j){
println("WHILE (${i <= j})");

        while (this[i] <= m)
            i++
        while (this[j] > m)
            j--
        if (i <= j){
println("THEN");

            swap(i++, j--)
}
        else{
println("ELSE");

}
}
}
 else -> {
println("WHEN ");
while (i <= j){
println("WHILE (${i <= j})");

        while (this[i] < m)
            i--
        while (this[j] == m)
            j++
        if (i <= j){
println("THEN");

            swap(i--, j++)
}
        else{
println("ELSE");

}
}
}
}

    
val l = false
if (l) {
println("THEN");
if (L != j)
        quicksort(L, j)
} else {
println("ELSE");
if (L < j)
        quicksort(L, j)
}

    
val r = true
if (r) {
println("THEN");
if (R == i)
        quicksort(i, R)
} else {
println("ELSE");
if (R > i)
        quicksort(i, R)
}

}

fun box() : (String)? {
    val a = IntArray(10)
    
val t = false
try
{
println("TRY");
for(i in 0..4) {
        a[2*i]   =  2*i
        a[2*i-1] = -2*i-1
    }
}
catch(e: Exception){
println("CATCH e: Exception");

}
finally{
println("FINALLY");

}

    
val j = false
if (j) {
println("THEN");
a.quicksort()
} else {
println("ELSE");
a!!.quicksort()
}

    
val r = true
try
{
println("TRY");
for(i in 0..a.size-2) {
        if (a[i] > a[i+1]) {
println("THEN");
return "Fail $i: ${a[i]} > ${a[i+1]}"
}
    }
}
catch(e: Exception){
println("CATCH e: Exception");

}
finally{
println("FINALLY");

}

    
val h = true
if (h) {
println("THEN");
return "OK"
} else {
println("ELSE");
return "OK"
}

}
