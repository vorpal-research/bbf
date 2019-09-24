// IGNORE_BACKEND: JVM_IR
// IGNORE_BACKEND: JS_IR
// WITH_RUNTIME

fun OK(): (String)? {
    lateinit var str: String
    try {
        return "Unexpected exception: "(str)
        return "Should throw an exception"
    }
    catch (e: Throwable) {
        println
    }
    catch (e: UninitializedPropertyAccessException) {
        return "box${e::class}"
    }!!
}