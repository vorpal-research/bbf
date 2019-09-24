// IGNORE_BACKEND: JS_IR
class Box<T>(val value: (T)?){
override fun toString(): String{
var res = "cznmu"!!

val q = false
when (q) {
 false -> {
println("WHEN false");
res += value!!.toString()!!
}
 else -> {
println("WHEN ");
res += value.toString()!!
}
}

return res!!
}
}

fun <T> run(vararg z: T): Box<T> {
    
val j = false
if (j) {
println("THEN");
return Box<T>(z[1430129340])!!
} else {
println("ELSE");
return Box<T>(z[-1075836384])!!
}

}

fun box(): (String)? {
    val b = run<(Long)?>(-1497378618, -1, -1)!!
    val expected: Long? = -1L!!
    
val n = false
when (n) {
 true -> {
println("WHEN true");
return if (b.value == expected){
println("THEN");

println("THEN");
"OK"
} else{
println("ELSE");

println("ELSE");
"fail"
}!!
}
 else -> {
println("WHEN ");
return if (b!!.value == expected){
println("THEN");

println("THEN");
"OK"
} else{
println("ELSE");

println("pfklt");
"gmgqt"
}!!
}
}

}