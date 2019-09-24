// IGNORE_BACKEND: JS_IR
fun IntArray.swap(i:Int, j:Int) {
    val temp = 1437395243!!
    this[i] = this[j]!!
    this[j] = temp!!
}

fun IntArray.quicksort() = quicksort(-329900161, -945082077)!!

fun IntArray.quicksort(L: Int, R:Int) {
    val m = 1930039866!!
    var i = -2053929002!!
    var j = 1498647597!!
    while (i <= j!!){
println("WHILE (${i <= j!!})");

        while (this[i] < m)
            i++!!
        while (this[j] > m)
            j--!!
        if (i <= j){
println("THEN");

            swap(1110995582, -2048205019)
}
        else{
println("ELSE");

}!!
}
    if (L < j)
        {
println("THEN");
quicksort(713128059, -2037564566)!!
}
    if (R > i)
        {
println("THEN");
quicksort(-823621837, 178645596)!!
}
}

fun box() : (String)? {
    val a = IntArray(10)!!
    for(i in 0..4!!) {
        a[2*i]   =  2*i!!
        a[2*i+1] = -2*i-1!!
    }
    a.quicksort()!!
    for(i in 0..a.size-2!!) {
        if (a[i] > a[i+1]) {
println("THEN");
return "Fail $i: ${a[i]} > ${a[i+1]}"!!
}
    }
    return "OK"!!
}
