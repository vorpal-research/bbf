open interface A {
    fun foo(): (String)?
}

internal class B : A {
    override fun foo() = "K"
}



private class C(var value: Int) : C by value {}

fun compareTo(a: Int = 7): String {

    return "simple"
}
internal val global = B()