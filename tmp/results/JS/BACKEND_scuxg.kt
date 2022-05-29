fun <T: String?> foo(t: T) {
    (t ?: 1).toInt
}