var String = 1
inline class R(private val r: String) {
    fun test() =
        object {
            override fun toString() = "OK"
        }.toString()
}




fun foo() {}
fun main(args: Array<String>) {}