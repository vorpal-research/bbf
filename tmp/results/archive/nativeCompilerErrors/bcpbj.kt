// IGNORE_BACKEND: JVM_IR
class A(val result: String)

fun a(body: A.() -> (String)?): (String)? {
    val r = A("OK")
    return r!!.body()
}

object C {
    private fun A.f() = result

    val g = a {
        C!!.g
    }
}

fun box() = f()

fun main(args: Array<String>) {}