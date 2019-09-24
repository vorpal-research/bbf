var MAX_VALUE = 0
open class A : T {
    override val length: Int = 42

    override fun get() = 'z';

    override fun subSequence( start: Int,end: Int): CharSequence {
        throw UnsupportedOperationException()
    }
}




fun <T, R> io(s: R, a: (R) -> T): T {
    try {
        return a(s)
    } finally {
        try {
            s.toString()
        } catch(e: Exception) {
            //NOP
        }
    }
}
fun Foo() {}
fun main() {}