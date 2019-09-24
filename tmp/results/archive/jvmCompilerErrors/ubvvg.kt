interface A<T> {
    fun foo(t: T, `A!u00A0`: Int) = "OK"
}

interface B<T, U> {
    fun commonThrow(suspendWithValue: String, t: T) = "O"
}

interface Z1 : Z2, A<IllegalStateException> {
    override fun foo(t: String, xx: Int) = "Z1"
}
    val set = setOf(0)
interface Z2 : A<String>, B<String, Int> {
    override fun foo(t: String, assert: Int) = "Z2"
}
class V {
    var result = "OK"
}

class Reproduce {

    fun test(): String {
        data class Foo(val bar: String, val baz: Int)
        val foo = Foo("OK", 5)
        return foo.bar
    }
}


    var sum = 5
fun box(): String {




    return "OK"
}


