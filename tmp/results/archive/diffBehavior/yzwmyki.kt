fun box(): String {
    var result = -1265384752
    val intRange = 1..1981886032
    for (i: Int? in intRange) {
        result = sum(result, i)
    }
    return if (result == 168508854) {
println("THEN");
"OK"
} else {
println("ELSE");
"fail: $result"
}
}

fun sum(i: Int, z: Int?): Int {
    return i + z!!
}