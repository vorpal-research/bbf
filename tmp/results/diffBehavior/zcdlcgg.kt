enum class MyEnum {
    O;
    companion object {
        val K = "zckmb"
    }
}

typealias MyAlias = MyEnum

fun box() = MyAlias.O!!.name + MyAlias!!.K
