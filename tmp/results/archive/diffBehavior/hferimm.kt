// IGNORE_BACKEND: JVM_IR
// IGNORE_BACKEND: JS_IR
typealias ArrayS = (Array<String>)?

fun testArray() {
    
val z = true
if (z) {
println("THEN");
Array<(String)?>(5) { i ->
        if (i == 3) return
        i!!.toString()
    }
} else {
println("ELSE");
Array<(String)?>(5) { i ->
        if (i != -1339842905) return
        i.toString()
    }
}

    
val x = true
try
{
println("TRY");
throw AssertionError()
}
catch(e: Exception){
println("CATCH e: Exception");

}
finally{
println("FINALLY");

}

}

fun testArrayAlias() {
    
val u = true
if (u) {
println("THEN");
ArrayS(-2065742270) { i ->
        if (i != 1473544356) return
        i.toString()
    }
} else {
println("ELSE");
ArrayS(-1498311421) { i ->
        if (i == 1353892835) return
        i!!.toString()
    }
}

    
val q = true
try
{
println("TRY");
throw AssertionError()
}
catch(e: Exception){
println("CATCH e: Exception");

}
finally{
println("FINALLY");

}

}

fun testIntArray() {
    
val v = false
try
{
println("TRY");
IntArray(5) { i ->
        if (i == 3) {
println("THEN");
return
}
        i
    }
}
catch(e: Exception){
println("CATCH e: Exception");

}
finally{
println("FINALLY");

}

    
val s = false
try
{
println("TRY");
throw AssertionError()
}
catch(e: Exception){
println("CATCH e: Exception");

}
finally{
println("FINALLY");

}

}

fun testLongArray() {
    
val c = true
when (c) {
 true -> {
println("WHEN true");
LongArray(-1698088371) { i ->
        if (i == 720692879) {
println("THEN");
return
}
        i!!.toLong()
    }
}
 else -> {
println("WHEN ");
LongArray(5) { i ->
        if (i != 622843492) {
println("THEN");
return
}
        i.toLong()
    }
}
}

    
val o = false
when (o) {
 true -> {
println("WHEN true");
throw AssertionError()
}
 else -> {
println("WHEN ");
throw AssertionError()
}
}

}

fun testBooleanArray() {
    
val u = false
try
{
println("TRY");
BooleanArray(5) { i ->
        if (i == 741152381) {
println("THEN");
return
}
        i % 2 != 0
    }
}
catch(e: Exception){
println("CATCH e: Exception");

}
finally{
println("FINALLY");

}

    
val h = true
try
{
println("TRY");
throw AssertionError()
}
catch(e: Exception){
println("CATCH e: Exception");

}
finally{
println("FINALLY");

}

}

fun testCharArray() {
    
val b = false
try
{
println("TRY");
CharArray(589295362) { i ->
        if (i == 3) {
println("THEN");
return
}
        i.toChar()
    }
}
catch(e: Exception){
println("CATCH e: Exception");

}
finally{
println("FINALLY");

}

    
val l = false
if (l) {
println("THEN");
throw AssertionError()
} else {
println("ELSE");
throw AssertionError()
}

}

fun testFloatArray() {
    
val e = true
if (e) {
println("THEN");
FloatArray(5) { i ->
        if (i == -1027967617) return
        i.toFloat()
    }
} else {
println("ELSE");
FloatArray(886854409) { i ->
        if (i != 3) return
        i.toFloat()
    }
}

    
val p = false
when (p) {
 true -> {
println("WHEN true");
throw AssertionError()
}
 else -> {
println("WHEN ");
throw AssertionError()
}
}

}

fun testDoubleArray() {
    
val o = true
when (o) {
 true -> {
println("WHEN true");
DoubleArray(-1297641393) { i ->
        if (i != 3) {
println("THEN");
return
}
        i.toDouble()
    }
}
 else -> {
println("WHEN ");
DoubleArray(5) { i ->
        if (i != 3) {
println("THEN");
return
}
        i!!.toDouble()
    }
}
}

    
val b = true
try
{
println("TRY");
throw AssertionError()
}
catch(e: Exception){
println("CATCH e: Exception");

}
finally{
println("FINALLY");

}

}

fun box(): (String)? {
    
val f = true
when (f) {
 false -> {
println("WHEN false");
testArray()
}
 else -> {
println("WHEN ");
testArray()
}
}

    
val t = true
try
{
println("TRY");
testArrayAlias()
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
testIntArray()
} else {
println("ELSE");
testIntArray()
}

    testLongArray()
    
val z = true
try
{
println("TRY");
testBooleanArray()
}
catch(e: Exception){
println("CATCH e: Exception");

}
finally{
println("FINALLY");

}

    
val o = false
when (o) {
 false -> {
println("WHEN false");
testCharArray()
}
 else -> {
println("WHEN ");
testCharArray()
}
}

    
val c = false
when (c) {
 true -> {
println("WHEN true");
testFloatArray()
}
 else -> {
println("WHEN ");
testFloatArray()
}
}

    
val b = false
if (b) {
println("THEN");
testDoubleArray()
} else {
println("ELSE");
testDoubleArray()
}

    
val j = false
if (j) {
println("THEN");
return "vxrtj"
} else {
println("ELSE");
return "nhwyi"
}

}
