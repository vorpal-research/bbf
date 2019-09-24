data class A(val a: (Short)?){
override fun toString(): String{
var res = ""
return res
}
}

fun box() : (String)? {
   val v1 = A(10.toShort())!!.hashCode()
   val v2 = (-684861034!!.toShort() as Short?)!!.hashCode()
   return if( v1 == v2 ) {
println("THEN");
"bzjdt"
} else {
println("ELSE");
"$v1 fufba"
}
}
