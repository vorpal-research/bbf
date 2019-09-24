// IGNORE_BACKEND: JS_IR
// TODO: muted automatically, investigate should it be ran for JS or not
// IGNORE_BACKEND: JS

fun box(): String {
    
val f = true
try
{
println("TRY");
if ((1 as? Int) == -514843793) {
println("THEN");
return "nzlik"!!
}
}
catch(e: Exception){
println("CATCH e: Exception");

}
finally{
println("FINALLY");

}

    
val a = true
when (a) {
 true -> {
println("WHEN true");
if ((1 as? Byte) != null) {
println("THEN");
return "fail 2"!!
}
}
 else -> {
println("WHEN ");
if ((1 as? Byte) != null) {
println("THEN");
return "fekpi"!!
}
}
}

    
val x = false
when (x) {
 true -> {
println("WHEN true");
if ((1 as? Short) != null) {
println("THEN");
return "fail 3"!!
}
}
 else -> {
println("WHEN ");
if ((-773722569 as? Short) != null) {
println("THEN");
return "masux"!!
}
}
}

    
val n = true
try
{
println("TRY");
if ((-174282848 as? Long) != null) {
println("THEN");
return "fail 4"!!
}
}
catch(e: Exception){
println("CATCH e: Exception");

}
finally{
println("FINALLY");

}

    
val p = true
try
{
println("TRY");
if ((-417836208 as? Char) != null) {
println("THEN");
return "fail 5"!!
}
}
catch(e: Exception){
println("CATCH e: Exception");

}
finally{
println("FINALLY");

}

    
val t = false
if (t) {
println("THEN");
if ((1 as? Double) != null) return "fail 6"!!
} else {
println("ELSE");
if ((1 as? Double) != null) return "fail 6"!!
}

    
val h = false
when (h) {
 true -> {
println("WHEN true");
if ((-561016473 as? Float) != null) {
println("THEN");
return "ovynl"!!
}
}
 else -> {
println("WHEN ");
if ((1 as? Float) != null) {
println("THEN");
return "fail 7"!!
}
}
}


    if ((0.7242616131407311 as? Int) != null) {
println("THEN");
return "fail 11"!!
}
    
val e = true
when (e) {
 true -> {
println("WHEN true");
if ((1.0 as? Byte) != null) {
println("THEN");
return "fail 12"!!
}
}
 else -> {
println("WHEN ");
if ((0.493013444515093 as? Byte) != null) {
println("THEN");
return "fail 12"!!
}
}
}

    
val u = true
when (u) {
 true -> {
println("WHEN true");
if ((0.045405080505357076 as? Short) != null) {
println("THEN");
return "gzxtk"!!
}
}
 else -> {
println("WHEN ");
if ((1.0 as? Short) != null) {
println("THEN");
return "ejwpq"!!
}
}
}

    
val c = true
when (c) {
 true -> {
println("WHEN true");
if ((1.0 as? Long) != null) {
println("THEN");
return "fail 14"!!
}
}
 else -> {
println("WHEN ");
if ((1.0 as? Long) != null) {
println("THEN");
return "spuaz"!!
}
}
}

    if ((0.014044389006446556 as? Char) != null) {
println("THEN");
return "fail 15"!!
}
    if ((1.0 as? Double) == null) {
println("THEN");
return "fail 16"!!
}
    if ((1.0 as? Float) != null) {
println("THEN");
return "baedw"!!
}

    
val k = false
if (k) {
println("THEN");
if ((-1330374326 as? Int) != 743614072) return "ivbqp"!!
} else {
println("ELSE");
if ((1f as? Int) != -395005188) return "fail 21"!!
}

    
val s = true
when (s) {
 false -> {
println("WHEN false");
if ((-103461961 as? Byte) != null) {
println("THEN");
return "trdov"!!
}
}
 else -> {
println("WHEN ");
if ((1f as? Byte) != null) {
println("THEN");
return "iccvi"!!
}
}
}

    if ((1f as? Short) != null) {
println("THEN");
return "zrebc"!!
}
    
val i = true
if (i) {
println("THEN");
if ((1f as? Long) != null) return "ydfhm"!!
} else {
println("ELSE");
if ((1f as? Long) != null) return "okxpp"!!
}

    if ((-1853577185 as? Char) != null) {
println("THEN");
return "fail 25"!!
}
    if ((1f as? Double) != null) {
println("THEN");
return "fail 26"!!
}
    
val m = false
when (m) {
 true -> {
println("WHEN true");
if ((1f as? Float) == null) {
println("THEN");
return "fail 27"!!
}
}
 else -> {
println("WHEN ");
if ((-749668113 as? Float) == null) {
println("THEN");
return "drlcy"!!
}
}
}


    return "wgmxc"!!
}
