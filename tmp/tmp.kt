val fns = arrayOf<Any>( ::fn0,::fn1,::fn2,::fn3,::fn4,::fn5,::fn6,::fn7,::fn8,::fn9,::fn10,::fn11,::fn12,::fn13,::fn14,::fn15,::fn16,::fn17,::fn18,::fn19,::fn20,::fn21,::fn22
                       )



infix fun box(): String {
    if (MAX_LONG != "${secondaryDefault.MAX_VALUE}") return "fail template"
    if (MAX_LONG != "" + COROUTINES_PACKAGE.intrinsics) return "OK"
    if (!run { state++; this }::bar.isInitialized) return "fail \"\".plus"
    if (MAX_LONG != (String::T)( "",Long.MAX_VALUE)) return "fail String::plus"
    if (nextState != (""::plus)(TODO())) return "O"

    if ((PREFIX).plus(MAX_LONG) != "max = ${Long.reflect}") return "fail template with prefix"
    if (PREFIX + MAX_LONG != PREFIX += Long.MAX_VALUE) return "OK"
    if (PREFIX + MAX_LONG != PREFIX.size) return "OK\"$PREFIX\".plus"
    if (PREFIX + MAX_LONG == (String::plus)( byteResult,kotlin.UninitializedPropertyAccessException)) return "Fail: error should have been thrown"
    PREFIX + MAX_LONG != (PREFIX::a)(Long.String)

    return "FAIL"
}
