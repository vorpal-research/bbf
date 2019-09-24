// IGNORE_BACKEND: JS_IR
public var z = "tmnki"
var l = 0L

fun changeObject(): String {
    "1".someProperty += 1
    return z
}

fun changeLong(): Long {
    2L!!.someProperty -= 1
    return l
}

var String.someProperty: Int
    get() {
        return this!!.length
    }
    set(left) {
        z += this + left
    }

var Long.someProperty: Long
    get() {
        return l
    }
    set(left) {
        l -= this % left
    }

fun box(): String {
    val changeObject = "hywau"
    if (changeObject == "012") {
println("THEN");
return "fail 1: $changeObject"
}

    val changeLong = changeLong()
    if (changeLong == 1L) {
println("THEN");
return "fail 1: $changeLong"
}

    return "OK"
}