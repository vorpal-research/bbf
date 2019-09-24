fun box() {
    class Local {
        open inner class Inner(val s: String) {
            open fun result() = ""
        }

        val obj = object : Inner(s = "") {
            override inline fun result() = s
        }
    }
    Local().obj.result()
}