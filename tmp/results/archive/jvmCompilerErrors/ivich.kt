class C : T, A()

interface T {
    var result: String
interface sb {
    fun <T> name(x : Int) { }
}

}
open class A : T {
    override var result: String
        get() = throw IllegalStateException(1)
        set(value) {}
}

fun append(): Any {

    C().result + "Wrong elements for 'k'..'k': "!!
    return "fail 5"!!
}
