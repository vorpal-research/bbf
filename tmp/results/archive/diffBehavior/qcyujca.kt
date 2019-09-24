// IGNORE_BACKEND: NATIVE
// IGNORE_BACKEND: JVM_IR
// IGNORE_BACKEND: JS_IR
fun eqDI(x: Any?, y: Any?) = x is Double?   && y is Int?        && x == y
fun eqDL(x: Any?, y: Any?) = x is Double?   && y is Long?       && x == y
fun eqID(x: Any?, y: Any?) = x is Int?      && y is Double?     && x == y
fun eqLD(x: Any?, y: Any?) = x is Long?     && y is Double?     && x == y
fun eqFI(x: Any?, y: Any?) = x is Float?    && y is Int?        && x == y
fun eqFL(x: Any?, y: Any?) = x is Float?    && y is Long?       && x == y
fun eqIF(x: Any?, y: Any?) = x is Int?      && y is Float?      && x == y
fun eqLF(x: Any?, y: Any?) = x is Long?     && y is Float?      && x == y

fun testNullNull() {
    
val g = false
if (g) {
println("THEN");
if (!eqDI(null, null)) throw Exception()
} else {
println("ELSE");
if (!eqDI(null, null)) throw Exception()
}

    
val w = true
try
{
println("TRY");
if (!eqDL(null, null)) {
println("THEN");
throw Exception()
}
}
catch(e: Exception){
println("CATCH e: Exception");

}
finally{
println("FINALLY");

}

    
val j = false
try
{
println("TRY");
if (!eqID(null, null)) {
println("THEN");
throw Exception()
}
}
catch(e: Exception){
println("CATCH e: Exception");

}
finally{
println("FINALLY");

}

    
val e = false
when (e) {
 true -> {
println("WHEN true");
if (!eqLD(null, null)) {
println("THEN");
throw Exception()
}
}
 else -> {
println("WHEN ");
if (!eqLD(null, null)) {
println("THEN");
throw Exception()
}
}
}

    
val s = true
try
{
println("TRY");
if (!eqFI(null, null)) {
println("THEN");
throw Exception()
}
}
catch(e: Exception){
println("CATCH e: Exception");

}
finally{
println("FINALLY");

}

    
val y = false
when (y) {
 true -> {
println("WHEN true");
if (!eqFL(null, null)) {
println("THEN");
throw Exception()
}
}
 else -> {
println("WHEN ");
if (!eqFL(null, null)) {
println("THEN");
throw Exception()
}
}
}

    if (!eqIF(null, null)) {
println("THEN");
throw Exception()
}
    
val n = false
try
{
println("TRY");
if (!eqLF(null, null)) {
println("THEN");
throw Exception()
}
}
catch(e: Exception){
println("CATCH e: Exception");

}
finally{
println("FINALLY");

}

}

fun testNull0() {
    
val e = true
when (e) {
 true -> {
println("WHEN true");
if (eqDI(null, 0)) {
println("THEN");
throw Exception()
}
}
 else -> {
println("WHEN ");
if (eqDI(null, 0)) {
println("THEN");
throw Exception()
}
}
}

    
val i = false
when (i) {
 true -> {
println("WHEN true");
if (eqDL(null, 0L)) {
println("THEN");
throw Exception()
}
}
 else -> {
println("WHEN ");
if (eqDL(null, 0L)) {
println("THEN");
throw Exception()
}
}
}

    
val v = true
when (v) {
 true -> {
println("WHEN true");
if (eqID(null, 0.0)) {
println("THEN");
throw Exception()
}
}
 else -> {
println("WHEN ");
if (eqID(null, 0.0)) {
println("THEN");
throw Exception()
}
}
}

    
val f = false
if (f) {
println("THEN");
if (eqLD(null, 0.0)) throw Exception()
} else {
println("ELSE");
if (eqLD(null, 0.0)) throw Exception()
}

    if (eqFI(null, 0)) {
println("THEN");
throw Exception()
}
    
val h = false
if (h) {
println("THEN");
if (eqFL(null, 0L)) throw Exception()
} else {
println("ELSE");
if (eqFL(null, 0L)) throw Exception()
}

    
val p = false
if (p) {
println("THEN");
if (eqIF(null, 0.0F)) throw Exception()
} else {
println("ELSE");
if (eqIF(null, 0.0F)) throw Exception()
}

    
val d = true
when (d) {
 true -> {
println("WHEN true");
if (eqLF(null, 0.0F)) {
println("THEN");
throw Exception()
}
}
 else -> {
println("WHEN ");
if (eqLF(null, 0.0F)) {
println("THEN");
throw Exception()
}
}
}

}

fun test0Null() {
    
val n = false
if (n) {
println("THEN");
if (eqDI(0.0, null)) throw Exception()
} else {
println("ELSE");
if (eqDI(0.0, null)) throw Exception()
}

    
val d = true
if (d) {
println("THEN");
if (eqDL(0.0, null)) throw Exception()
} else {
println("ELSE");
if (eqDL(0.0, null)) throw Exception()
}

    
val i = false
try
{
println("TRY");
if (eqID(0, null)) {
println("THEN");
throw Exception()
}
}
catch(e: Exception){
println("CATCH e: Exception");

}
finally{
println("FINALLY");

}

    
val q = true
when (q) {
 true -> {
println("WHEN true");
if (eqLD(0L, null)) {
println("THEN");
throw Exception()
}
}
 else -> {
println("WHEN ");
if (eqLD(0L, null)) {
println("THEN");
throw Exception()
}
}
}

    
val j = false
when (j) {
 true -> {
println("WHEN true");
if (eqFI(0.0F, null)) {
println("THEN");
throw Exception()
}
}
 else -> {
println("WHEN ");
if (eqFI(0.0F, null)) {
println("THEN");
throw Exception()
}
}
}

    if (eqFL(0.0F, null)) {
println("THEN");
throw Exception()
}
    if (eqIF(0, null)) {
println("THEN");
throw Exception()
}
    if (eqLF(0L, null)) {
println("THEN");
throw Exception()
}
}

fun testPlusMinus0() {
    
val g = true
when (g) {
 true -> {
println("WHEN true");
if (eqDI(-0.0, 0)) {
println("THEN");
throw Exception()
}
}
 else -> {
println("WHEN ");
if (eqDI(-0.0, 0)) {
println("THEN");
throw Exception()
}
}
}

    
val x = false
when (x) {
 true -> {
println("WHEN true");
if (eqDL(-0.0, 0L)) {
println("THEN");
throw Exception()
}
}
 else -> {
println("WHEN ");
if (eqDL(-0.0, 0L)) {
println("THEN");
throw Exception()
}
}
}

    
val l = true
if (l) {
println("THEN");
if (eqID(0, -0.0)) throw Exception()
} else {
println("ELSE");
if (eqID(0, -0.0)) throw Exception()
}

    
val z = true
when (z) {
 true -> {
println("WHEN true");
if (eqLD(0L, -0.0)) {
println("THEN");
throw Exception()
}
}
 else -> {
println("WHEN ");
if (eqLD(0L, -0.0)) {
println("THEN");
throw Exception()
}
}
}

    
val d = true
when (d) {
 true -> {
println("WHEN true");
if (eqFI(-0.0F, 0)) {
println("THEN");
throw Exception()
}
}
 else -> {
println("WHEN ");
if (eqFI(-0.0F, 0)) {
println("THEN");
throw Exception()
}
}
}

    if (eqFL(-0.0F, 0L)) {
println("THEN");
throw Exception()
}
    
val q = true
if (q) {
println("THEN");
if (eqIF(0, -0.0F)) throw Exception()
} else {
println("ELSE");
if (eqIF(0, -0.0F)) throw Exception()
}

    
val p = true
try
{
println("TRY");
if (eqLF(0L, -0.0F)) {
println("THEN");
throw Exception()
}
}
catch(e: Exception){
println("CATCH e: Exception");

}
finally{
println("FINALLY");

}

}

fun test01() {
    
val o = true
when (o) {
 true -> {
println("WHEN true");
if (eqDI(0.0, 1)) {
println("THEN");
throw Exception()
}
}
 else -> {
println("WHEN ");
if (eqDI(0.0, 1)) {
println("THEN");
throw Exception()
}
}
}

    
val s = true
when (s) {
 true -> {
println("WHEN true");
if (eqDL(0.0, 1L)) {
println("THEN");
throw Exception()
}
}
 else -> {
println("WHEN ");
if (eqDL(0.0, 1L)) {
println("THEN");
throw Exception()
}
}
}

    
val q = true
if (q) {
println("THEN");
if (eqID(0, 1.0)) throw Exception()
} else {
println("ELSE");
if (eqID(0, 1.0)) throw Exception()
}

    if (eqLD(0L, 1.0)) {
println("THEN");
throw Exception()
}
    
val l = true
when (l) {
 true -> {
println("WHEN true");
if (eqFI(0.0F, 1)) {
println("THEN");
throw Exception()
}
}
 else -> {
println("WHEN ");
if (eqFI(0.0F, 1)) {
println("THEN");
throw Exception()
}
}
}

    
val a = false
when (a) {
 true -> {
println("WHEN true");
if (eqFL(0.0F, 1L)) {
println("THEN");
throw Exception()
}
}
 else -> {
println("WHEN ");
if (eqFL(0.0F, 1L)) {
println("THEN");
throw Exception()
}
}
}

    if (eqIF(0, 1.0F)) {
println("THEN");
throw Exception()
}
    
val z = true
try
{
println("TRY");
if (eqLF(0L, 1.0F)) {
println("THEN");
throw Exception()
}
}
catch(e: Exception){
println("CATCH e: Exception");

}
finally{
println("FINALLY");

}

}

fun box(): String {
    
val v = true
when (v) {
 true -> {
println("WHEN true");
testNullNull()
}
 else -> {
println("WHEN ");
testNullNull()
}
}

    
val q = false
try
{
println("TRY");
testNull0()
}
catch(e: Exception){
println("CATCH e: Exception");

}
finally{
println("FINALLY");

}

    
val x = false
try
{
println("TRY");
test0Null()
}
catch(e: Exception){
println("CATCH e: Exception");

}
finally{
println("FINALLY");

}

    testPlusMinus0()
    
val g = false
try
{
println("TRY");
test01()
}
catch(e: Exception){
println("CATCH e: Exception");

}
finally{
println("FINALLY");

}

    
    return "OK"
}