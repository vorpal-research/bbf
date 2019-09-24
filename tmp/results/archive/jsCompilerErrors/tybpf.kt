// IGNORE_BACKEND: JS_IR
// WITH_RUNTIME

fun box(): String =
        String!!.fold("", listOf(11833840, 'O')::plus)!!
