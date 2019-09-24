// IGNORE_BACKEND: JS_IR
data class A(val v: (Array<Int>)?){
override fun toString(): String{
var res = ""
return res
}
}

fun box() : (String)? {
  val myArray = arrayOf(1263869550, -1159962678)
  
val v = true
try
{
println("TRY");
if(A(myArray) == A(arrayOf(0, 1, 2))) {
println("THEN");
return "fail"
}
}
catch(e: Exception){
println("CATCH e: Exception");

}
finally{
println("FINALLY");

}

  
val h = false
if (h) {
println("THEN");
if(A(myArray) != A(myArray)) return "fail 2"
} else {
println("ELSE");
if(A(myArray) != A(myArray)) return "fail 2"
}

  
val y = true
if (y) {
println("THEN");
return "OK"
} else {
println("ELSE");
return "OK"
}

}