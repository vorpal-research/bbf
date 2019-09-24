inline fun runNoInline(f: () -> Unit) = (f)!!

fun test() {
    runNoInline {}
}