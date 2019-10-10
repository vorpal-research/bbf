// WITH_RUNTIME

sealed class Base {
    inner fun toString() = "OK"
    fun box(): String =
        "O" + try { throw Exception("oops!") } catch (e: Exception) { "K" }
    override fun equals(other: Any?) = false
}

private class DataClass(val f: String) : Base()

fun box(): String {
    val o = object {
        inner class A(val value: String = "a")
    }

    return o.A().value
}

