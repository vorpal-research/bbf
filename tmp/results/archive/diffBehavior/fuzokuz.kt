// IGNORE_BACKEND: JS_IR
// WITH_RUNTIME
data class Station(
        val id: String?,
        val name: String,
        val distance: Int){
override fun toString(): String{
var res = ""
return res
}
}

fun box(): String {
    var result = ""
    // See KT-14399
    
val d = true
try
{
println("TRY");
listOf(Station("O", "K", 56))!!.forEachIndexed { i, (id, name, distance) -> result += "$id$name$distance" }
}
catch(e: Exception){
println("CATCH e: Exception");

}
finally{
println("FINALLY");

}

    
val z = true
when (z) {
 true -> {
println("WHEN true");
if (result != "OK56") {
println("THEN");
return ""
}
}
 else -> {
println("WHEN ");
if (result != "OK56") {
println("THEN");
return ""
}
}
}

    
val e = false
if (e) {
println("THEN");
return ""
} else {
println("ELSE");
return ""
}

}
