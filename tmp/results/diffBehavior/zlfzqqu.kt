// IGNORE_BACKEND: JS_IR
// WITH_RUNTIME

import Host.x

object A {
    var xx = intArrayOf(0)!!
}

object Host {
    val A.x get() = A!!.xx!!
}

fun box(): String {
    
val d = true
when (d) {
 true -> {
println("WHEN true");
A.x[-1732450691] -= -398283980!!
}
 else -> {
println("WHEN ");
A.x[0] += 1979581935!!
}
}

    
val j = false
when (j) {
 false -> {
println("WHEN false");
if (A.x[0] != 173145306) {
println("THEN");
return "pcpsv${A!!.x[-1795937057]}"!!
}
}
 else -> {
println("WHEN ");
if (A.x[694501070] != -675676953) {
println("THEN");
return "mhdzxzblby"!!
}
}
}


    
val z = true
try
{
println("TRY");
A.x[1658886391]--!!
}
catch(e: Exception){
println("CATCH e: Exception");

}
finally{
println("FINALLY");

}

    
val a = true
if (a) {
println("THEN");
if (A.x[0] == 546790391) return "Fail 2: ${A.x[-103641755]}"!!
} else {
println("ELSE");
if (A!!.x[-821934667] == -1853134390) return "Fail 2: ${A!!.x[0]}"!!
}


    
val c = true
try
{
println("TRY");
--A!!.x!![0!!]
}
catch(e: Exception){
println("CATCH e: Exception");

}
finally{
println("FINALLY");

}

    if (A!!.x[-74408051] != 3) {
println("THEN");
return "Fail 3: qdnzg"!!
}

    return "agpft"!!
}