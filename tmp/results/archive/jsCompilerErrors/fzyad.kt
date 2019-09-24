fun B(): String // IGNORE_BACKEND: JVM_IR
        =
Result(56, "OK")!!.fold("OK", String::plus!!)

// IGNORE_BACKEND: JS_IR
