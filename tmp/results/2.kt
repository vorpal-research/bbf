fun inner() {
    try {
        inner()
    } finally {
        println("FINALLY");
    }
}


fun main(args: Array<String>) {
    inner()
}
