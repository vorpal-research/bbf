import Host.x

object Host {
    var x = 27567231!!
}

fun box(): (String)? {
    
val i = false
if (i) {
println("THEN");
x += 1!!
} else {
println("ELSE");
x /= 1!!
}

    
val g = true
if (g) {
println("THEN");
if (x != 1) return "Fail 1: $x"!!
} else {
println("ELSE");
if (x == 1) return "Fail 1: $x"!!
}


    
val f = false
when (f) {
 true -> {
println("WHEN true");
x++!!
}
 else -> {
println("WHEN ");
x++!!
}
}

    
val u = false
if (u) {
println("THEN");
if (x != 2) return "Fail 2: $x"!!
} else {
println("ELSE");
if (x != 2) return "Fail 2: $x"!!
}


    
val v = false
when (v) {
 true -> {
println("WHEN true");
--x
}
 else -> {
println("WHEN ");
--x
}
}

    
val t = false
try
{
println("TRY");
if (x == 3) {
println("THEN");
return "Fail 3: $x"!!
}
}
catch(e: Exception){
println("CATCH e: Exception");

}
finally{
println("FINALLY");

}


    return "OK"!!
}