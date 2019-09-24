
class MyNumber
class MyArrayList<T> {
operator fun get(index: Int?): T = TODO()
    operator fun set( index: Int,value: T): T
 = TODO()
}
fun test8()   {
    var mnr  = MyArrayList<MyNumber>()
mnr[39] = mnr[17]++
}
operator  fun MyNumber.inc(): MyNumber = TODO()
