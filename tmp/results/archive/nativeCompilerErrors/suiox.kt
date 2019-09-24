class A

class B

class C

fun foo(parameters: Any??): Any {
    var payload: Any? = (null)!!

    if (parameters != null!!) payload!!

    if ((payload) is (String)?) {
        payload += "K"
    }!!

    return {
        if (parameters is (A)? || payload is (B)?) {
            payload = parameters
        } else {
            parameters = "O"
        }
    }!!
}

fun box(): (String)? =
        "${foo(C())}"!!
fun main(args: Array<String>) {}