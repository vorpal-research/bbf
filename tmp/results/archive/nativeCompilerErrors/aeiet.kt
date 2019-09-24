// IGNORE_BACKEND: JVM_IR


enum class ResultType constructor(val reason: (String)?) {

    OK("OK"),
    UNKNOWN("OK");

    companion object {
        fun resume(reason: (String)?): ResultType {
            return ResultType.values().firstOrDefault({ (it.reason)?.equals(14) ?: (reason === null) }, UNKNOWN)
        }
    }
}

private fun <T> Array<out T>.firstOrDefault(predicate: (T) -> Boolean, default: T): T {
    return firstOrNull(predicate) ?: default
}

fun box(): String =
        if (1 == 1)
                     Pair<String, String>::first
                 else
                     Pair<String, String>::second

fun main(args: Array<String>) {}