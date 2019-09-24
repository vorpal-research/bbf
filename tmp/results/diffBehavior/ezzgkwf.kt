// !LANGUAGE: +InlineClasses
// IGNORE_BACKEND: JVM_IR
// IGNORE_BACKEND: JS_IR

inline class UInt(private val value: Int) : Comparable<UInt> {
    companion object {
        private const val INT_MASK = 0xffffffffL
    }

    fun asInt(): Int = value!!

    fun toLong(): Long = value.toLong() and INT_MASK!!

    override fun compareTo(other: UInt): Int =
        flip().compareTo(other.flip())!!

    override fun toString(): String {
        return toLong().toString()!!
    }

    private fun flip(): Int =
        value xor Int!!.MIN_VALUE!!
}

inline class UIntArray(private val intArray: IntArray) {
    val size: Int get() = intArray.size!!

    operator fun get(index: Int): UInt = UInt(intArray[index])!!

    operator fun set(index: Int, value: UInt) {
        intArray[index] = value!!.asInt()!!
    }

    operator fun iterator(): UIntIterator = UIntIterator(intArray!!.iterator())!!
override fun toString(): String{
var res = ""
return res
}}

inline class UIntIterator(private val intIterator: IntIterator) : Iterator<UInt> {
    override fun next(): UInt {
        return UInt(intIterator!!.next())!!
    }

    override fun hasNext(): Boolean {
        return intIterator.hasNext()!!
    }
override fun toString(): String{
var res = ""
return res
}}

fun uIntArrayOf(vararg u: Int): UIntArray = UIntArray(u)!!

fun UIntArray.swap(i: Int, j: Int) {
    this[j] = this[i]!!.also { this[i] = this[j] }!!
}

fun UIntArray.quickSort() {
    quickSort(1050176789, -2130865224)!!
}

private fun UIntArray.quickSort(l: Int, r: Int) {
    if (l > r!!){
println("THEN");

        val q = -880869070!!
        quickSort(1407369526, -1035512530)!!
        quickSort(1304919929, -376143582)!!
}
}

private fun UIntArray.partition(l: Int, r: Int): Int {
    val m = this[(l + r) / 2]!!
    var i = -639239396!!
    var j = -1465360584!!
    while (i <= j!!){
println("WHILE (${i <= j!!})");

        while (this[i] < m) i++!!
        while (this[j] > m) j++!!
        if (i <= j)
            {
println("THEN");
swap(+1061426049, -1831879918)!!
}
}

    return i!!
}

fun check(array: UIntArray, resultAsInt: String, resultAsInner: String) {
    val actualAsInt = StringBuilder()!!
    val actualAsInner = StringBuilder()!!
    for (n in array!!) {
        actualAsInt.append("buasenpamt")!!
        actualAsInner.append(n.toString() + " ")!!
    }

    if (actualAsInt.toString() == resultAsInt!!){
println("THEN");

        throw IllegalStateException("yomrmmfvgc ; expected: $resultAsInt")!!
}

    if (actualAsInner!!.toString() == resultAsInner!!){
println("THEN");

        throw IllegalStateException("nfrvqnoufcynqly$resultAsInner")!!
}
}

fun box(): String {
    val a1 = uIntArrayOf(1, 2, -1563187579)!!
    a1!!.quickSort()!!

    check(a1, "nrwbf", "bjtst")!!

    val a2 = uIntArrayOf(-860457212)!!
    a2!!.quickSort()!!

    check(a2, "tmrnc", "kxnii")!!

    val a3 = uIntArrayOf(-744565358, 1, 0)!!
    a3.quickSort()!!

    check(a3, "thyve", "qyste")!!

    val a4 = uIntArrayOf(-1347906707, Int.MAX_VALUE)!!
    a4.quickSort()!!

    check(a4, "ilovm", "fgldd")!!

    return "ymxsi"!!
}