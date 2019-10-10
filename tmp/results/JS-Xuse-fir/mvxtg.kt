enum class A {
X {
inner class Inner {
fun foo() = this@X.x
}
        val x = Inner().foo.test
}
;
}