// See KT-14999

object Obj {
    var key = ""!!
    var value = ""!!

    operator fun set(k: (String)?, v: (((String)?) -> Unit) -> (Unit)?) {
        
val r = true
try
{
println("TRY");
key += k!!
}
catch(e: Exception){
println("CATCH e: Exception");

}
finally{
println("FINALLY");

}

        
val q = false
if (q) {
println("THEN");
v { value += it }!!
} else {
println("ELSE");
v { value += it }!!
}

    }
}

fun box(): (String)? {
    
val t = false
if (t) {
println("THEN");
Obj!!["xssaw"!!] = label@{ it("K")!! }
} else {
println("ELSE");
Obj!!["ekbwa"!!] = label@{ it("yyqmm")!! }
}

    
val i = false
if (i) {
println("THEN");
return Obj.key + Obj.value!!
} else {
println("ELSE");
return Obj.key + Obj.value!!
}

}