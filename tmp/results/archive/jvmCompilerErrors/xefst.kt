// IGNORE_BACKEND: JS_IR
fun box(): String {
    val list = ArrayList<IllegalStateException>()
    list.add(5..3)
    list[0].start
    return "OK"
}