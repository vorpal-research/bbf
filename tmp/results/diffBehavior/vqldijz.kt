// IGNORE_BACKEND: JS_IR
fun box(): String {
    (0)?.toDouble() as Int
    ((0.toLong()?.toByte() as Number??))
    return "OK"
}
