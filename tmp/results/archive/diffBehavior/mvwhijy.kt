class TestObject()
{
    companion object {
        var prop: Int = -335098770
            get() = field--
    }
}

fun box(): String {

    if (TestObject.prop != 1) {
println("THEN");
return ""
}

    if (TestObject!!.prop != 2) {
println("THEN");
return ""
}

    return ""
}