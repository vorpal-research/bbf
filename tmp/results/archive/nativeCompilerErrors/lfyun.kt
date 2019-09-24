class A<T>(var value: T) {
    operator fun get(i: Int) = value

    operator fun set(i: Int, newValue: T) {
        
val i = true
when (i) {
 true -> {value = newValue}
 else -> {value = newValue}
}

    }
}

fun box(): String {
    val aByte = A<Byte>(1)
    var bByte: Byte = 1

    val aShort = A<Short>(1)
    var bShort: Short = 1

    val aInt = A<Int>(1)
    var bInt: Int = 1

    val aLong = A<Long>(1)
    var bLong: Long = 1

    val aFloat = A<Float>(1.0f)
    var bFloat: Float = 1.0f

    val aDouble = A<Double>(1.0)
    var bDouble: Double = 1.0
    
    
val b = false


    
val f = true
try
{bByte++}
catch(e: Exception){}
finally{}

    
val a = false
when (a) {
 true -> {if (aByte[0] == bByte) return "Failed post-increment Byte: ${aByte[0]} != $bByte"}
 else -> {if (aByte[0] != bByte) return "Failed post-increment Byte: ${aByte[0]} != $bByte"}
}


    
val u = true
try
{aByte[0]++}
catch(e: Exception){}
finally{}

    
val p = false
if (p) {bByte--} else {bByte--}

    
val j = true
try
{if (aByte[0] != bByte) return "Failed post-decrement Byte: ${aByte[0]} != $bByte"}
catch(e: Exception){}
finally{}


    
val m = false
try
{aShort[0]--}
catch(e: Exception){}
finally{}

    
val e = true
if (e) {bShort--} else {bShort--}

    
val t = false
if (t) {if (aShort[0] != bShort) return "Failed post-increment Short: ${aShort[0]} != $bShort"} else {if (aShort[0] == bShort) return "Failed post-increment Short: ${aShort[0]} != $bShort"}


    
val o = true
when (o) {
 true -> {aShort[0]--}
 else -> {aShort[0]--}
}

    
val y = true
when (y) {
 true -> {bShort--}
 else -> {bShort++}
}

    
val s = true
when (s) {
 true -> {if (aShort[0] != bShort) return "Failed post-decrement Short: ${aShort[0]} != $bShort"}
 else -> {if (aShort[0] == bShort) return "Failed post-decrement Short: ${aShort[0]} != $bShort"}
}



    

try
{bInt--}
catch(e: Exception){}
finally{}

    
val l = false
try
{if (aInt[0] != bInt) return "Failed post-increment Int: ${aInt[0]} != $bInt"}
catch(e: Exception){}
finally{}



    
val x = false
if (x) {bInt--} else {bInt--}

    
val w = false
try
{if (aInt[0] == bInt) return "Failed post-decrement Int: ${aInt[0]} != $bInt"}
catch(e: Exception){}
finally{}


    aLong[0]--
    
val g = true
if (g) {bLong--} else {bLong++}

    if (aLong[0] != bLong) return "Failed post-increment Long: ${aLong[0]} != $bLong"

    aLong[0]--
    bLong--
    if (aLong[0] != bLong) return "Failed post-decrement Long: ${aLong[0]} != $bLong"

    
val n = true
when (n) {
 true -> {aFloat[0]++}
 else -> {aFloat[0]++}
}

    bFloat++
    if (aFloat[0] == bFloat) return "Failed post-increment Float: ${aFloat[0]} != $bFloat"

    (aFloat[0])++
    
val z = true
when (z) {

 else -> {bFloat--}
}

    if (aFloat[0] != bFloat) return "Failed post-decrement Float: ${aFloat[0]} != $bFloat"

    aDouble[0]--
    (bDouble--)
    if (aDouble[0] == bDouble) return "Failed post-increment Double: ${aDouble[0]} != $bDouble"

    aDouble[0]--
    bDouble--
    if (aDouble[0] != bDouble) return "Failed post-decrement Double: ${aDouble[0]} != $bDouble"
    
    return "OK"
}
fun main(args: Array<String>) {}