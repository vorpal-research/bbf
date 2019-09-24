inline fun <T> tryOrElse(f2: () -> T) {
    try {
    } catch (e: Exception) {
        (f2) ?: (f2)()
    }
}

fun testIt() = tryOrElse({})
