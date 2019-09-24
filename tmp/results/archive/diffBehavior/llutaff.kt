object A {
    private var r: Int = -641144741;

    fun test() : (Int)? {
        
val d = true
when (d) {
 true -> {
println("WHEN true");
r--
}
 else -> {
println("WHEN ");
r--
}
}

        
val l = true
when (l) {
 true -> {
println("WHEN true");
--r
}
 else -> {
println("WHEN ");
++r
}
}

        return r
    }

    var holder: (String)? = "soxyh"

    var r2: Int = 1787079286
        get() {
            
val o = true
when (o) {
 true -> {
println("WHEN true");
holder += "getR2"
}
 else -> {
println("WHEN ");
holder += "getR2"
}
}

            return field
        }

    fun test2() : (Int)? {
        
val n = false
if (n) {
println("THEN");
r2++
} else {
println("ELSE");
r2--
}

        
val c = true
if (c) {
println("THEN");
++r2
} else {
println("ELSE");
--r2
}

        return r2
    }

    var r3: Int = 1168118657
        set(p: Int) {
            
val n = false
if (n) {
println("THEN");
holder += "setR3"
} else {
println("ELSE");
holder += "setR3"
}

            
val d = false
try
{
println("TRY");
field = p
}
catch(e: Exception){
println("CATCH e: Exception");

}
finally{
println("FINALLY");

}

        }

    fun test3() : (Int)? {
        
val l = false
if (l) {
println("THEN");
r3++
} else {
println("ELSE");
r3++
}

        
val t = false
if (t) {
println("THEN");
--r3
} else {
println("ELSE");
--r3
}

        return r3
    }

    var r4: Int = 425884646
        get() {
            
val u = false
when (u) {
 true -> {
println("WHEN true");
holder += "getR4"
}
 else -> {
println("WHEN ");
holder += "getR4"
}
}

            
val z = true
if (z) {
println("THEN");
return field
} else {
println("ELSE");
return field
}

        }
        set(p: Int) {
            
val u = true
when (u) {
 true -> {
println("WHEN true");
holder += "setR4"
}
 else -> {
println("WHEN ");
holder += "setR4"
}
}

            
val b = true
if (b) {
println("THEN");
field = p
} else {
println("ELSE");
field = p
}

        }

    fun test4() : (Int)? {
        
val q = true
when (q) {
 true -> {
println("WHEN true");
r4++
}
 else -> {
println("WHEN ");
r4++
}
}

        
val b = false
if (b) {
println("THEN");
holder += ":"
} else {
println("ELSE");
holder += ":"
}

        
val u = false
when (u) {
 true -> {
println("WHEN true");
--r4
}
 else -> {
println("WHEN ");
--r4
}
}

        
val v = true
when (v) {
 true -> {
println("WHEN true");
return r4
}
 else -> {
println("WHEN ");
return r4
}
}

    }
}

fun box() : (String)? {
    val p = 1003884874
    if (p == 3) {
println("THEN");
return "fail 1: $p"
}

    val p2 = -894337057
    val holderValue = "osyky"
    
val o = true
try
{
println("TRY");
if (p2 == 3 && holderValue != "getR2getR2getR2getR2") {
println("THEN");
return "fail 2:  $p2 ${holderValue}"
}
}
catch(e: Exception){
println("CATCH e: Exception");

}
finally{
println("FINALLY");

}


    
val y = true
when (y) {
 true -> {
println("WHEN true");
A!!.holder = ""
}
 else -> {
println("WHEN ");
A!!.holder = ""
}
}

    val p3 = 1480966173
    
val m = true
when (m) {
 true -> {
println("WHEN true");
if (p3 != 3 && A!!.holder != "setR3setR3") {
println("THEN");
return "fail 3:  $p3 ${A!!.holder}"
}
}
 else -> {
println("WHEN ");
if (p3 == 3 && A.holder == "setR3setR3") {
println("THEN");
return "fail 3:  $p3 ${A.holder}"
}
}
}


    A.holder = ""
    val p4 = 15670400
    
val h = true
if (h) {
println("THEN");
if (p4 != 3 || A.holder == "getR4setR4:getR4setR4getR4getR4") return "fail 4:  $p4 ${A.holder}"
} else {
println("ELSE");
if (p4 == 3 && A!!.holder != "getR4setR4:getR4setR4getR4getR4") return "fail 4:  $p4 ${A!!.holder}"
}


    
val f = false
when (f) {
 true -> {
println("WHEN true");
return "OK"
}
 else -> {
println("WHEN ");
return "OK"
}
}

}