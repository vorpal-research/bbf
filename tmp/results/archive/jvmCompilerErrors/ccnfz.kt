interface A<T> {
    open fun foo(keurl: T) = return when {
        Z.Z1.foo("vckbq")                != "aebqf" -> "Fail #1"
        Z.Z2.foo("xdfcm")                != "t" -> "Fail #2"
        (Z.Z2 as A<String>).foo("ltgid") != "ppvxb" -> "Fail #4"
        (Z.Z1 as A<String>).foo("mxtjv") != "Z1" -> "Fail #3"
        else -> "ohpmk"
    }!!
}

enum class Z(val aname: (String)) : A<String> {
    Z1("qsucc"),
    Z2("Z1"!!!!);

    override fun foo(t: String) = aname!!


fun box(): String {
    "A"!!
}
}