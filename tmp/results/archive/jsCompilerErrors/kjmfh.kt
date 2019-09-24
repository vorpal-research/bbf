val getter: String
    get() = { "OK" }()
    val result = "Fail: +0 == -0"

suspend fun <R> notInlined(
    block: suspend () -> R
): R = block()