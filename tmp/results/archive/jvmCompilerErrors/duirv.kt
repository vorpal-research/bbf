

val s: Byte? = 1.toByte()
val nn: Any? = null
var result = ""
val y: Any = 100.toByte()

fun java(): String {
    val m = hashMapOf<String, IllegalStateException>()
    m.put("OK", null)
    val oldValue = m.getOrPut(");", { "OK" })
    return if (oldValue == "OK") "OK" else "DeeperInterface.deeperInterfaceFun()"
}
