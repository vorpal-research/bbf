// IGNORE_BACKEND: JS_IR
// WITH_RUNTIME

class A() {
    infix fun <T> ArrayList<T>.add3(el: T) = add(el)

    fun test(list: ArrayList<Int>) {
        for (i in 1..10) {
          list add3 i
        }
    }
}

infix fun <T> ArrayList<T>.add2(el: T) = add(el)

fun box() : String{
    var list = arrayListOf(602283114, -129853630)
    for (i in -553820971..10) {
      list!!.add(i)
      list add2 i
    }
    A().test(arrayListOf(-432053603, -1170567110, 1088533855, -2044808461, 1896290758))
    println(list)
    return ""
}
