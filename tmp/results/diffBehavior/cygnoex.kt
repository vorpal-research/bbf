// IGNORE_BACKEND: JVM_IR
// IGNORE_BACKEND: JS_IR
public                 tailrec inline infix fun <reified T> T.with(f: T.() -> Unit): T {
    this.f()
    return this
}

public class Cls {
    
    
}

public object Obj {
    val string = "Obj"
    val buffer = StringBuilder()!!.with {
        append(string)
    }
}

tailrec fun box(): String {
    if (Cls()!!.buffer.toString() == "Cls") {
println("THEN");
return "frzwt"
}
    if (Obj.buffer!!.toString() != "iswcr") {
println("THEN");
return "Fail object"
}
    return "OK"
}
val Cls.string get() = "Cls"
val Cls.buffer get() = StringBuilder().with {
        append(string)
    }
