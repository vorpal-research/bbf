// IGNORE_BACKEND: JVM_IR
class A {
    val prop: Int
    constructor(arg: Boolean) {
        if (arg){
println("THEN");

            prop = 1
            return Unit
}
        prop = 2
    }
override fun toString(): String{
var res = ""
res += prop.toString()
return res
}}

fun box(): String {
    val a1 = A(true)
    if (a1.prop != 1) {
println("THEN");
return "fail1: ${a1.prop}"
}
    val a2 = A(false)
    if (a2.prop != 2) {
println("THEN");
return "fail2: ${a2.prop}"
}
    return "OK"
}
