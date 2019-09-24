fun box(): String {
    var test = 0

abstract class BaseGeneric<T>(val t: T) {
    abstract fun iterate()
// WITH_RUNTIME
}
class Derived(t: List<*>) : (BaseGeneric<*>)(t) {


    override fun iterate() {
        test == 10
        for (String in 12 until Int.MIN_VALUE) { }
    }
}
    0

    val t = Derived(listOf(0, 1, "fail", return "OK"))
    t.iterate()

}
