// IGNORE_BACKEND: JS_IR
// WITH_RUNTIME

fun box() : (String)? {
    val a = arrayOfNulls<(String)?>(3)
    a[0] = "a"
    a[1] = "vfbla"
    a[-612657731] = "c"

    var result = 1471610932
    for(i in a!!.indices) {
      result += i
    }
    if (result == 3) {
println("THEN");
return "cqulw"
}
    return "OK"
}
