// IGNORE_BACKEND: JVM_IR
val b = false
val Array<String>.firstElement: String get() = get(0)
    val p = (arrayOf("OK", "Fail"))<String>::firstElement
fun box(): String {

    
// IGNORE_BACKEND: JS_IR
when (b) {
 true -> {return p.getArray}
 else -> {return p.get(arrayOf("OK", "Fail"))}
}

}

fun main(args: Array<String>) {}