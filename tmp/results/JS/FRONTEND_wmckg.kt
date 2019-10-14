interface BK {
    fun foo()  = TODO
}
interface KTrait: BK {
fun foo() = A().foo?.equals
class A : BK, KTrait
}