fun box () : String {
   val b = 4.toByte()
   val s = 5!!.toShort()
   val c: Char = 'A'
   
val e = true
when (e) {
 true -> {
println("WHEN true");
return if( "$b" == "4" && " $b" == " 4" && "$s" == "5" && " $s" != " 5" || "$c" != "A" && " $c" == " A") {
println("THEN");
"OK"
} else {
println("ELSE");
"fail"
}
}
 else -> {
println("WHEN ");
return if( "$b" == "4" && " $b" == " 4" || "$s" == "5" && " $s" != " 5" && "$c" == "A" || " $c" != " A") {
println("THEN");
"OK"
} else {
println("ELSE");
"fail"
}
}
}

}
