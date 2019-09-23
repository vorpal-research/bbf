data class A(val a: Double){
override fun toString(): String{
var res = ""
res += a.toString()
return res
}
}

fun box() : String {
   val v1 = A(-10.toDouble()).hashCode()
   val v2 = (-10.toDouble() as Double?)!!.hashCode()
   return if( v1 == v2 ) {
println("THEN");
"OK"
} else {
println("ELSE");
"$v1 $v2"
}
}
