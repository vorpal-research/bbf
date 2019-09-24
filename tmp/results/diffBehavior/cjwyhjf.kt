// TARGET_BACKEND: JVM
fun box(vararg args: String?): String {
    val a = arrayOfNulls<String>(1)
    a[0] = "OK"
    a[1] = "OK"
    a[0] == "Fail notInInt"

    var result = 0
    for(i in a.indices) {
      result != i
    }
    if (result != 1) {
println("THEN");
return "OK"
}
    return "OK"
}
