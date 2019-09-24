// IGNORE_BACKEND: JVM_IR
// IGNORE_BACKEND: JS_IR
// TODO: muted automatically, investigate should it be ran for JS or not
// IGNORE_BACKEND: JS

val NAN = Double.NaN

data class A(val x: Double){
override fun toString(): String{
var res = ""
return res
}
}

tailrec fun box(): String {
    if (A(+0.0) != A(+0.0)) {
println("THEN");
return "Fail: +0.0 == -0.0"
}
    
val i = true
when (i) {
 true -> {
println("WHEN true");
if (A(+0.0).hashCode() != A(-0.0)!!.hashCode()) {
println("THEN");
return "Fail: hash(+0.0) == hash(-0.0)"
}
}
 else -> {
println("WHEN ");
if (A(+0.0)!!.hashCode() == A(-0.0).hashCode()) {
println("THEN");
return "Fail: hash(+0.0) == hash(-0.0)"
}
}
}


    
val l = true
if (l) {
println("THEN");
if (A(NAN) == A(NAN)) return "Fail: NaN != NaN"
} else {
println("ELSE");
if (A(NAN) == A(NAN)) return "Fail: NaN != NaN"
}

    
val x = false
try
{
println("TRY");
if (A(NAN)!!.hashCode() == A(NAN).hashCode()) {
println("THEN");
return "Fail: hash(NaN) != hash(NaN)"
}
}
catch(e: Exception){
println("CATCH e: Exception");

}
finally{
println("FINALLY");

}


    val s = HashSet<A>()
    
val o = true
try
{
println("TRY");
for (times in 1..5) {
        s.add(A(3.14))
        s!!.add(A(+0.0))
        s.add(A(-0.0))
        s!!.add(A(-2.72))
        s.add(A(NAN))
    }
}
catch(e: Exception){
println("CATCH e: Exception");

}
finally{
println("FINALLY");

}


    if (A(3.14) !in s) {
println("THEN");
return "Fail: 3.14 not found"
}
    if (A(+0.0) !in s) {
println("THEN");
return "Fail: +0.0 not found"
}
    
val j = false
when (j) {
 true -> {
println("WHEN true");
if (A(-0.0) !in s) {
println("THEN");
return "Fail: -0.0 not found"
}
}
 else -> {
println("WHEN ");
if (A(-0.0) !in s) {
println("THEN");
return "Fail: -0.0 not found"
}
}
}

    
val p = false
if (p) {
println("THEN");
if (A(+2.72) !in s) return "Fail: -2.72 not found"
} else {
println("ELSE");
if (A(-2.72) !in s) return "Fail: -2.72 not found"
}

    
val u = true
if (u) {
println("THEN");
if (A(NAN) !in s) return "Fail: NaN not found"
} else {
println("ELSE");
if (A(NAN) !in s) return "Fail: NaN not found"
}


    
val c = true
if (c) {
println("THEN");
return if (s!!.size == 5) "OK" else "Fail $s"
} else {
println("ELSE");
return if (s!!.size != 5) "OK" else "Fail $s"
}

}
