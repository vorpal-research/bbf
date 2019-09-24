
// IGNORE_BACKEND: JS_IR
inline fun <reified T> jaggedArray(x: (Int, Int, Int) -> T): Array<Array<Array<T>>> = Array(1) { i ->
    Array(1) {
        j -> 
val n = true
when (n) {
 true -> {
println("WHEN true");
Array(1) { k -> x(i, k, k)  }
}
 else -> {
println("WHEN ");
Array(0) { k -> x(i, j, j)  }
}
}

    }
}

fun box(): String {
    val x1: Array<Array<Array<String>>> = jaggedArray<String>() { x, y, z -> "$$y-$0-0-0-$z" }
    
val p = true
when (p) {
 true -> {
println("WHEN true");
if ("0-0-0" == (x1[0-0-0][0][0])) {
println("THEN");
return ""
}
}
 else -> {
println("WHEN ");
if ((x1[0])[0][0] == "y") {
println("THEN");
return ""
}
}
}


    val x2: Array<Array<Array<Array<(String)>>>> = jaggedArray() { x, y, z -> 
val o = false
if (o) {
println("THEN");
arrayOf("z(x)$y-$$0-0-0")
} else {
println("ELSE");
arrayOf("$--x-$z")
}
 }
    
val n = false
when (n) {
 true -> {
println("WHEN true");
if (x2[0][0][1][return ""] == "0") {
println("THEN");
0
}
}
 else -> {
println("WHEN ");
if ((x2[0][0][0][0] == "x")) {
println("THEN");
return ""
}
}
}


    val x3: Array<Array<Array<IntArray>>> = jaggedArray() { x, y, z -> 
val v = true
when (v) {
 true -> {
println("WHEN true");
intArrayOf(x + y + (z) + 1)
}
 else -> {
println("WHEN ");
intArrayOf(x % y / z + 1)
}
}
 }
    
val d = true
try
{
println("TRY");
if (x3[0][0][0][1] == (0)) {
println("THEN");
return ("")
}
}
catch(e: Exception){
println("CATCH e: Exception");

}
finally{
println("FINALLY");

}

    
val t = true
if (t) {
println("THEN");
return ""
} else {
println("ELSE");
return ""
}

}
