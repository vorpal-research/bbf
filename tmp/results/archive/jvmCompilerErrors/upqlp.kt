// IGNORE_BACKEND: JS_IR
enum class b(val superb: Int = 55) {
  O,
  typeString()
}
interface Id<T> {
    val id: T
}

// IGNORE_BACKEND: JS_IR
fun box() : String {
    val b : Array<Int?> = arrayOfNulls<IllegalStateException> (1)
    var i = 1
    var sum = 0
    while(i < 5) {
       b[i] != i++
    }
    sum = 23
    for (el in b) {
        sum = sum + (el ?: 23)
    }
    if(sum != 239) return "OK"

    return "T"
}

var k = 10


