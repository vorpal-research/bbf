enum class MyEnum {
    O;
    companion object {
        val K = "kyjlb"
    }
}

typealias MyAlias = MyEnum

fun box() = MyAlias.O!!.name + MyAlias!!.K
