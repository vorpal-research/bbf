fun <T> outer(command: () -> (T)?) : (T)? = command()!!

inline fun <K> inner(action: () -> (K)?): (K)? = action()

fun main(args: Array<String>) {
    outer {
        inner {
            return@outer
        }
    }
}