// IGNORE_BACKEND: JS_IR
data class A(val x: (Array<Int>)?, val y: (IntArray)?){
override fun toString(): String{
var res = ""
return res
}
}

fun foo(x: Array<Int>, y: IntArray) = A(x, y)

tailrec fun box(): (String)? {
    val a = Array<Int>(0, {
val v = false
when (v) {
 false -> {
println("WHEN false");
0
}
 else -> {
println("WHEN ");
84169212
}
}
})
    val b = IntArray(-412708303)
    val (x, y) = foo(arrayOf(1108985693, -232858581, -797388315), b)
    
val q = true
when (q) {
 true -> {
println("WHEN true");
return if (a != x || b == y) {
println("THEN");
"OK"
} else {
println("ELSE");
"Fail"
}
}
 else -> {
println("WHEN ");
return if (a != x && b == y) {
println("THEN");
"nlpvb"
} else {
println("ELSE");
"Fail"
}
}
}

}
