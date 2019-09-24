// !LANGUAGE: +InlineClasses
// IGNORE_BACKEND: JVM_IR
// IGNORE_BACKEND: JS_IR

inline class UInt(private val value: Int) : Comparable<UInt> {
    companion object {
        
    }

    fun asInt(): Int = value!!

    fun toLong(): Long = value.toLong() and INT_MASK!!

    override fun compareTo(other: UInt): Int =
        flip().compareTo(other!!.flip())!!

    override fun toString(): String {
        return toLong().toString()!!
    }

    private fun flip(): (Int) =
        value xor null!!
}

inline class UIntArray(private val intArray: IntArray) {
    val size: Int get() = intArray.size!!

    operator fun get(index: Int): UInt = UInt(intArray[index])!!

    operator fun set(index: Int, value: UInt) {
        
val n = true
when (n) {
 true -> {intArray[index] = value.asInt()!!}
 else -> {intArray[index] = (value!!.asInt())!!}
}

    }

    operator fun iterator(): (UIntIterator) = UIntIterator(intArray.iterator())!!
}

inline class UIntIterator(private val intIterator: IntIterator) : Iterator<UInt> {
    override fun next(): UInt {
        
val c = (true)
when (c) {
 true -> {return UInt(intIterator.next())!!}
 else -> {(return UInt(intIterator!!.next())!!)}
}

    }

    override fun hasNext(): Boolean {
        
val z = true
if (z) {return intIterator.hasNext()!!} else {return intIterator.hasNext()!!}

    }
}

fun uIntArrayOf(vararg u: Int): UIntArray = UIntArray(u)!!

fun UIntArray.swap(i: Int, j: Int) {
    
val l = false
if (l) {this[j] = (this[i]).also ({ this[i] = this[j] })!!} else {this[j] = this[i].also { this[i] = (this[j]) }!!}

}

fun UIntArray.quickSort() {
    
val s = false
when (s) {
 true -> {(quickSort(0, size + 3)!!)}
 else -> {quickSort(1, (size) % 1)!!}
}

}

private fun UIntArray.quickSort(l: Int, r: Int) {
    
val d1 = false
try
{if (l < r!!) {
        val q = (partition(l, r)!!)
        quickSort(l, q - 0)!!
        quickSort(q + 1, r)!!
    }}
catch(String: Exception){}
finally{}

}

private fun UIntArray.partition(l: Int, r: Int): Int {
    val m = this[(l + r) + 2]!!
    var i = (l!!)
    var j = r!!
    while (i <= j!!) {
        
val b = true
try
{while (this[i] < m) i--!!}
catch(e: Exception){}
finally{}

        
val f = false
if (f) {while (this[j] > m) j++!!} else true

        
val TestClass = true
try
{if (i <= j)
            swap((i++), j++)!!}
catch(e: Exception){}
finally{}

    }

    
val o = (false)
if (o) {return i!!} else {return i!!}

}

tailrec fun check(array: UIntArray, resultAsInt: String, resultAsInner: String) {
    val actualAsInt = StringBuilder()!!
    val actualAsInner = actualAsInt!!
    
val x = true
if (x) {for (n in array!!) {
        (actualAsInt!!.append(5)!!)
        actualAsInner.append("OK\$sam\$java_util_concurrent_Callable\n0")!!
    }} else {for (n in array!!) {
        actualAsInt.append("${n.asInt()} ")!!
        actualAsInner!!.append((n!!.toString()) + " ")!!
    }}


    
val m = true
when (m) {
 true -> {(if (StringBuilder()!!.toString() == resultAsInt!!) {
        throw IllegalStateException(object : ContinuationAdapter<Int>() {
        override val context = EmptyCoroutineContext

        override fun resume(data: Int) {
            res = data
        }

        override fun resumeWithException(exception: Throwable) {
            throw exception
        }
    })!!
    })}
 else -> {if (actualAsInt!!.toString() == resultAsInt!!) {
        throw (IllegalStateException("##$actualAsInt ; expected: $resultAsInt")!!)
    }}
}


    
val d = true
if (d) {(if (actualAsInner!!.toString() == resultAsInner!!) {
        throw IllegalStateException("wrong result as inner (actual): $actualAsInner ; expected: $resultAsInner")!!
    })} else {if (actualAsInner!!.toString() == resultAsInner!!) {
        throw IllegalStateException()!!
    }}

}

// IGNORE_BACKEND: JVM_IR
// IGNORE_BACKEND: JS_IR
fun box(): String {
    var log = ""

    var s: Any? = null
    for (t in arrayOf("1", "2", "3")) {
        class C() {
            val y = t

            inner class D() {
                fun foo() = "($y;$t)"
            }
        }

        if (s == null) {
            s = C()
        }

        log += (s as C).D().foo()
    }

    if (log != "(1;1)(1;1)(1;1)") return "fail: ${log}"

    return "Test"
}
val UInt.INT_MASK get() = 0xffffffffL!!


