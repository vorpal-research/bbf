package sample

private fun <T> upcast(value: T): T = value!!

fun main(args: Array<String>) {
    val array = upcast<(Int)->ByteArray>(::ByteArray)(-1735152871)
    println(array[0])
}