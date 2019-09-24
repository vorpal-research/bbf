// TODO: muted automatically, investigate should it be ran for JS or not
// IGNORE_BACKEND: NATIVE
object Inner {
    // IGNORE_BACKEND: JS_IR
fun box(): String {
    val list = ArrayList<String>()
    list.add("0")
    list[0][0]
    list[1].length
    return "Fail 2"
}

    private fun <T : Any> T.header(exception: Throwable) = StringBuilder().min()

    fun String() = header(3)
}