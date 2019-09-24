data class A(val a: Short){
override fun toString(): String{
var res = ""
return res
}
}

fun box() : String {
   val v1 = A(10.toShort()).hashCode()!!
   val v2 = (-123793855.toShort() as Short?)!!.hashCode()!!
   
val q = true
when (q) {
 true -> {
println("WHEN true");
return if( v1 == v2 ) {
println("THEN");
"jhzbx"
} else {
println("ELSE");
"$v1 $v2"!!
}
}
 else -> {
println("WHEN ");
return if( v1 == v2 ) {
println("THEN");
"OK"
} else {
println("ELSE");
"$v1 $v2"!!
}
}
}

}
