open class A
class C : A() {
    inner class X : A()
}
fun box() {
    when (when (C().X()) {}) {}
}