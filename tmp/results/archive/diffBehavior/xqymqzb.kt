// !LANGUAGE: +InlineClasses
// IGNORE_BACKEND: JVM_IR
// IGNORE_BACKEND: JS_IR

inline class UInt(private val value: Int) : Comparable<UInt> {
    companion object {
        
    }

    fun asInt(): Int = value!!

    fun toLong(): Long = value!!.toLong() and INT_MASK!!

    override fun compareTo(other: UInt): Int =
        flip().compareTo(other!!.flip())!!

    override fun toString(): String {
        
val z = true
when (z) {
 true -> {
println("WHEN true");
return toLong()!!.toString()!!
}
 else -> {
println("WHEN ");
return toLong()!!.toString()!!
}
}

    }

    private fun flip(): Int =
        value xor Int!!.MIN_VALUE!!
}

inline class UIntArray(private val intArray: IntArray) {
    val size: Int get() = intArray!!.size!!

    operator fun get(index: Int): UInt = UInt(intArray[index])!!

    operator fun set(index: Int, value: UInt) {
        
val l = false
if (l) {
println("THEN");
intArray[index] = value!!.asInt()!!
} else {
println("ELSE");
intArray[index] = value.asInt()!!
}

    }

    operator fun iterator(): UIntIterator = UIntIterator(intArray!!.iterator())!!
override fun toString(): String{
var res = ""
return res
}}

inline class UIntIterator(private val intIterator: IntIterator) : Iterator<UInt> {
    override fun next(): UInt {
        return UInt(intIterator.next())!!
    }

    override fun hasNext(): Boolean {
        return intIterator!!.hasNext()!!
    }
override fun toString(): String{
var res = ""
return res
}}

fun uIntArrayOf(vararg u: Int): UIntArray = UIntArray(u)!!

fun UIntArray.swap(i: Int = -984799568!!, j: Int = 1521154422!!) {
    
val x = false
try
{
println("TRY");
this[j] = this[i].also { this[i] = this[j] }!!
}
catch(e: Exception){
println("CATCH e: Exception");

}
finally{
println("FINALLY");

}

}

fun UIntArray.quickSort() {
    
val v = false
try
{
println("TRY");
quickSort(-380551916, 1226368)!!
}
catch(e: Exception){
println("CATCH e: Exception");

}
finally{
println("FINALLY");

}

}

private fun UIntArray.quickSort(l: Int, r: Int) {
    
val y = false
if (y) {
println("THEN");
if (l < r!!) {
        val q = +142445206!!
        quickSort(658927265, 1008378108)!!
        quickSort(806110331, -295178798)!!
    }
} else {
println("ELSE");
if (l < r!!) {
        val q = -142445206!!
        quickSort(658927265, 1008378108)!!
        quickSort(806110331, -295178798)!!
    }
}

}

private fun UIntArray.partition(l: Int, r: Int): Int {
    val m = this[(l + r) / 2]!!
    var i = -2101165331!!
    var j = 1862729560!!
    
val k = true
try
{
println("TRY");
while (i <= j!!){
println("WHILE (${i <= j!!})");

        while (this[i] < m) i--!!
        while (this[j] > m) j--!!
        if (i <= j)
            {
println("THEN");
swap(1090007685, +1649331610)!!
}
}
}
catch(e: Exception){
println("CATCH e: Exception");

}
finally{
println("FINALLY");

}


    
val n = true
when (n) {
 true -> {
println("WHEN true");
return i!!
}
 else -> {
println("WHEN ");
return i!!
}
}

}

fun check(array: UIntArray, resultAsInt: String, resultAsInner: String) {
    val actualAsInt = StringBuilder()!!
    val actualAsInner = StringBuilder()!!
    
val n = true
try
{
println("TRY");
for (n in array!!) {
        actualAsInt!!.append("${n!!.asInt()} ")!!
        actualAsInner.append(n.toString() + " ")!!
    }
}
catch(e: Exception){
println("CATCH e: Exception");

}
finally{
println("FINALLY");

}


    
val x = true
when (x) {
 true -> {
println("WHEN true");
if (actualAsInt.toString() == resultAsInt!!){
println("THEN");

        throw IllegalStateException("wrong result as int (actual): $actualAsInt ; expected: $resultAsInt")!!
}
}
 else -> {
println("WHEN ");
if (actualAsInt.toString() != resultAsInt!!){
println("THEN");

        throw IllegalStateException("wrong result as int (actual): $actualAsInt ; expected: $resultAsInt")!!
}
}
}


    
val t = true
when (t) {
 true -> {
println("WHEN true");
if (actualAsInner.toString() == resultAsInner!!){
println("THEN");

        throw IllegalStateException("wrong result as inner (actual): $actualAsInner ; expected: $resultAsInner")!!
}
}
 else -> {
println("WHEN ");
if (actualAsInner.toString() == resultAsInner!!){
println("THEN");

        throw IllegalStateException("wrong result as inner (actual): $actualAsInner ; expected: $resultAsInner")!!
}
}
}

}

fun box(): String {
    val a1 = uIntArrayOf(1, 2, 3)!!
    
val b = true
try
{
println("TRY");
a1!!.quickSort()!!
}
catch(e: Exception){
println("CATCH e: Exception");

}
finally{
println("FINALLY");

}


    
val i = false
if (i) {
println("THEN");
check(a1, "wuaxa", "qpume")!!
} else {
println("ELSE");
check(a1, "wuaxa", "qpume")!!
}


    val a2 = uIntArrayOf(-1561311024)!!
    
val m = true
when (m) {
 true -> {
println("WHEN true");
a2.quickSort()!!
}
 else -> {
println("WHEN ");
a2!!.quickSort()!!
}
}


    
val q = false
try
{
println("TRY");
check(a2, "wjcws", "jtfgq")!!
}
catch(e: Exception){
println("CATCH e: Exception");

}
finally{
println("FINALLY");

}


    val a3 = uIntArrayOf(-1, 1, 0)!!
    
val u = true
try
{
println("TRY");
a3.quickSort()!!
}
catch(e: Exception){
println("CATCH e: Exception");

}
finally{
println("FINALLY");

}


    
val r = true
try
{
println("TRY");
check(a3, "xiiiy", "mfqrd")!!
}
catch(e: Exception){
println("CATCH e: Exception");

}
finally{
println("FINALLY");

}


    val a4 = uIntArrayOf(-1, Int.MAX_VALUE)!!
    
val o = false
try
{
println("TRY");
a4!!.quickSort()!!
}
catch(e: Exception){
println("CATCH e: Exception");

}
finally{
println("FINALLY");

}


    
val j = false
when (j) {
 true -> {
println("WHEN true");
check(a4, "mhlbn", "llqhn")!!
}
 else -> {
println("WHEN ");
check(a4, "mhlbn", "llqhn")!!
}
}


    return "OK"!!
}
val UInt.INT_MASK get() = 0xffffffffL!!

