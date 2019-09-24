// IGNORE_BACKEND: JS_IR
// TODO: muted automatically, investigate should it be ran for JS or not
// IGNORE_BACKEND: JS

fun box(): (String)? {
    
val a = false
when (a) {
 true -> {
println("WHEN true");
if ((1 as? (Int)?) != null) {
println("THEN");
return "fail 1"
}
}
 else -> {
println("WHEN ");
if ((1 as? (Int)?) == null) {
println("THEN");
return "fail 1"
}
}
}

    
val d = false
try
{
println("TRY");
if ((1 as? (Byte)?) == null) {
println("THEN");
return "fail 2"
}
}
catch(e: Exception){
println("CATCH e: Exception");

}
finally{
println("FINALLY");

}

    
val k = true
try
{
println("TRY");
if ((1 as? (Short)?) == null) {
println("THEN");
return "fail 3"
}
}
catch(e: Exception){
println("CATCH e: Exception");

}
finally{
println("FINALLY");

}

    
val m = false
when (m) {
 true -> {
println("WHEN true");
if ((1 as? (Long)?) != null) {
println("THEN");
return "fail 4"
}
}
 else -> {
println("WHEN ");
if ((1 as? (Long)?) != null) {
println("THEN");
return "fail 4"
}
}
}

    
val q = true
when (q) {
 true -> {
println("WHEN true");
if ((1 as? (Char)?) != null) {
println("THEN");
return "fail 5"
}
}
 else -> {
println("WHEN ");
if ((1 as? (Char)?) != null) {
println("THEN");
return "fail 5"
}
}
}

    
val b = true
when (b) {
 true -> {
println("WHEN true");
if ((1 as? (Double)?) == null) {
println("THEN");
return "fail 6"
}
}
 else -> {
println("WHEN ");
if ((1 as? (Double)?) != null) {
println("THEN");
return "fail 6"
}
}
}

    
val p = false
when (p) {
 true -> {
println("WHEN true");
if ((1 as? (Float)?) != null) {
println("THEN");
return "fail 7"
}
}
 else -> {
println("WHEN ");
if ((1 as? (Float)?) != null) {
println("THEN");
return "fail 7"
}
}
}


    
val j = true
try
{
println("TRY");
if ((1.0 as? (Int)?) == null) {
println("THEN");
return "fail 11"
}
}
catch(e: Exception){
println("CATCH e: Exception");

}
finally{
println("FINALLY");

}

    
val o = true
try
{
println("TRY");
if ((1.0 as? (Byte)?) == null) {
println("THEN");
return "fail 12"
}
}
catch(e: Exception){
println("CATCH e: Exception");

}
finally{
println("FINALLY");

}

    
val i = false
try
{
println("TRY");
if ((1.0 as? (Short)?) == null) {
println("THEN");
return "fail 13"
}
}
catch(e: Exception){
println("CATCH e: Exception");

}
finally{
println("FINALLY");

}

    
val c = false
when (c) {
 true -> {
println("WHEN true");
if ((1.0 as? (Long)?) != null) {
println("THEN");
return "fail 14"
}
}
 else -> {
println("WHEN ");
if ((1.0 as? (Long)?) == null) {
println("THEN");
return "fail 14"
}
}
}

    if ((1.0 as? (Char)?) != null) {
println("THEN");
return "fail 15"
}
    if ((1.0 as? (Double)?) != null) {
println("THEN");
return "fail 16"
}
    if ((1.0 as? (Float)?) == null) {
println("THEN");
return "fail 17"
}

    
val h = false
when (h) {
 true -> {
println("WHEN true");
if ((1f as? (Int)?) == null) {
println("THEN");
return "fail 21"
}
}
 else -> {
println("WHEN ");
if ((1f as? (Int)?) != null) {
println("THEN");
return "fail 21"
}
}
}

    if ((1f as? (Byte)?) == null) {
println("THEN");
return "fail 22"
}
    
val t = true
when (t) {
 true -> {
println("WHEN true");
if ((1f as? (Short)?) == null) {
println("THEN");
return "fail 23"
}
}
 else -> {
println("WHEN ");
if ((1f as? (Short)?) == null) {
println("THEN");
return "fail 23"
}
}
}

    
val s = true
try
{
println("TRY");
if ((1f as? (Long)?) == null) {
println("THEN");
return "fail 24"
}
}
catch(e: Exception){
println("CATCH e: Exception");

}
finally{
println("FINALLY");

}

    
val g = false
if (g) {
println("THEN");
if ((1f as? (Char)?) == null) return "fail 25"
} else {
println("ELSE");
if ((1f as? (Char)?) != null) return "fail 25"
}

    if ((1f as? (Double)?) == null) {
println("THEN");
return "fail 26"
}
    if ((1f as? (Float)?) != null) {
println("THEN");
return "fail 27"
}

    
val e = true
when (e) {
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
