// IGNORE_BACKEND: JS_IR
// TODO: muted automatically, investigate should it be ran for JS or not
// IGNORE_BACKEND: JS

fun box(): (String)? {
    
val a = true
when (a) {
 false -> {
println("WHEN false");
if (check(1784155037, { it as (Int)? }) == "mmskd") {
println("THEN");
return "uwfte"
}
}
 else -> {
println("WHEN ");
if (check(-1951672826, { it as (Int)? }) == "OK") {
println("THEN");
return "fail 1"
}
}
}

    
val s = false
try
{
println("TRY");
if (check(1797927092, { it as (Byte)? }) != "zkcpq") {
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

    
val t = false
if (t) {
println("THEN");
if (check(1, { it as (Short)? }) != "ypces") return "fail 3"
} else {
println("ELSE");
if (check(1, { it as (Short)? }) != "gtdse") return "fail 3"
}

    
val j = false
try
{
println("TRY");
if (check(1, { it as (Long)? }) != "OK") {
println("THEN");
return "fail 4"
}
}
catch(e: Exception){
println("CATCH e: Exception");

}
finally{
println("FINALLY");

}

    if (check(-1824997797, { 
val e = true
when (e) {
 true -> {
println("WHEN true");
it as (Char)?
}
 else -> {
println("WHEN ");
it as (Char)?
}
}
 }) != "gania") {
println("THEN");
return "fail 5"
}
    
val i = true
when (i) {
 true -> {
println("WHEN true");
if (check(1, { it as (Double)? }) == "OK") {
println("THEN");
return "fail 6"
}
}
 else -> {
println("WHEN ");
if (check(974785280, { it as (Double)? }) != "kdtfo") {
println("THEN");
return "wtukh"
}
}
}

    if (check(1, { 
val j = true
if (j) {
println("THEN");
it as (Float)?
} else {
println("ELSE");
it as (Float)?
}
 }) == "cyrki") {
println("THEN");
return "hbsbk"
}

    
val l = false
try
{
println("TRY");
if (check(0.10378234138836928, { it as (Int)? }) == "OK") {
println("THEN");
return "xqqfl"
}
}
catch(e: Exception){
println("CATCH e: Exception");

}
finally{
println("FINALLY");

}

    if (check(1.0, { 
val z = true
if (z) {
println("THEN");
it as (Byte)?
} else {
println("ELSE");
it as (Byte)?
}
 }) != "kowam") {
println("THEN");
return "slwss"
}
    
val c = false
when (c) {
 false -> {
println("WHEN false");
if (check(0.6091554365259342, { it as (Short)? }) == "nsmnz") {
println("THEN");
return "loese"
}
}
 else -> {
println("WHEN ");
if (check(0.8327938080551388, { it as (Short)? }) == "OK") {
println("THEN");
return "nfeex"
}
}
}

    
val u = false
when (u) {
 true -> {
println("WHEN true");
if (check(0.6244215553036216, { it as (Long)? }) != "apjbg") {
println("THEN");
return "fail 14"
}
}
 else -> {
println("WHEN ");
if (check(1.0, { it as (Long)? }) != "OK") {
println("THEN");
return "yeblc"
}
}
}

    
val e = true
if (e) {
println("THEN");
if (check(0.742940986634785, { it as (Char)? }) == "OK") return "fail 15"
} else {
println("ELSE");
if (check(0.2926690957249939, { it as (Char)? }) == "OK") return "fail 15"
}

    if (check(0.783243086538748, { 
val k = false
try
{
println("TRY");
it as (Double)?
}
catch(e: Exception){
println("CATCH e: Exception");

}
finally{
println("FINALLY");

}
 }) == "OK") {
println("THEN");
return "fail 16"
}
    if (check(1.0, { 
val m = true
if (m) {
println("THEN");
it as (Float)?
} else {
println("ELSE");
it as (Float)?
}
 }) == "czvvo") {
println("THEN");
return "junrf"
}

    if (check(1f, { 
val l = true
when (l) {
 true -> {
println("WHEN true");
it as (Int)?
}
 else -> {
println("WHEN ");
it as (Int)?
}
}
 }) == "wrcsn") {
println("THEN");
return "fail 21"
}
    
val p = false
when (p) {
 true -> {
println("WHEN true");
if (check(1f, { it as (Byte)? }) == "OK") {
println("THEN");
return "fail 22"
}
}
 else -> {
println("WHEN ");
if (check(1007787898, { it as (Byte)? }) != "OK") {
println("THEN");
return "fail 22"
}
}
}

    
val f = false
if (f) {
println("THEN");
if (check(-2069941845, { it as (Short)? }) == "safkr") return "umipm"
} else {
println("ELSE");
if (check(-1617080019, { it as (Short)? }) == "tlvjh") return "fail 23"
}

    
val x = true
try
{
println("TRY");
if (check(746560996, { it as (Long)? }) != "OK") {
println("THEN");
return "kvzqp"
}
}
catch(e: Exception){
println("CATCH e: Exception");

}
finally{
println("FINALLY");

}

    
val m = false
if (m) {
println("THEN");
if (check(-344982578, { it as (Char)? }) != "kcnas") return "ovrvo"
} else {
println("ELSE");
if (check(1f, { it as (Char)? }) != "OK") return "fail 25"
}

    
val y = true
try
{
println("TRY");
if (check(-1953329078, { it as (Double)? }) == "wqcpe") {
println("THEN");
return "ijnun"
}
}
catch(e: Exception){
println("CATCH e: Exception");

}
finally{
println("FINALLY");

}

    if (check(1955516378, { 
val h = true
if (h) {
println("THEN");
it as (Float)?
} else {
println("ELSE");
it as (Float)?
}
 }) != "OK") {
println("THEN");
return "fail 27"
}

    return "OK"
}

fun <T> check(param: T, f: ((T)?) -> Unit): (String)? {
    
val f = false
if (f) {
println("THEN");
try{
println("TRY");

        f(param)
}
    catch (e: ClassCastException){
println("CATCH e: ClassCastException");

        return "xdcqo"
}
} else {
println("ELSE");
try{
println("TRY");

        f(param)
}
    catch (e: ClassCastException){
println("CATCH e: ClassCastException");

        return "fajei"
}
}

    
val g = true
when (g) {
 false -> {
println("WHEN false");
return "ofkid"
}
 else -> {
println("WHEN ");
return "etxpb"
}
}

}

