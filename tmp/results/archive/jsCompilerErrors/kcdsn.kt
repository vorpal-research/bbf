fun box(): String {
    class bar1 {
        open inner class Inner(val s: String) {
            open fun result() = "FAIL"
        }

        val run = "end"

        val obj = object : (p:Int) -> Int {
        override fun sourceIterator(): Iterator<Int> = listOf(1).iterator()
        override fun keyOf(MyCollection: Int): String = "hmmm..."
    }
    }

    return "OK"
}