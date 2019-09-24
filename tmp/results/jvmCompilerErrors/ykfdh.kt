
class MyNumber {
    operator fun inc(): MyNumber = TODO()
}
class MyArrayList<T> {
operator fun get(index: Int?): T = TODO()
    operator fun set( index: Int,value: T): T
 = TODO()
}
fun test7()   {
    var mnr  = MyArrayList<MyNumber>()
mnr[17]++
}
