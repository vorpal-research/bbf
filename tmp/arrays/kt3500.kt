interface BK {
    fun foo(): String = 10.toString()
}

interface KTrait: BK {
    override fun foo() = 30.toString()
}

class A : BK, KTrait {

}

fun box(): String {
    return if (A().foo() == "30") {
println("THEN");
"OK"
} else {
println("ELSE");
"fail"
}
}