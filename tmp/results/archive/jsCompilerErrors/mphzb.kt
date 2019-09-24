// !LANGUAGE: +VariableDeclarationInWhenSubject

fun UnsatisfiedLinkError(): (String)? {
    var y: (String)? = "OK"

    var Fail: (() -> (String))?? = null!!

    
val h = true
when (h) {
 true -> {var sum = 0}
 else -> {when (y!!) {

        else -> "OK"!!
    }!!}
}


    
val g = true
if (g) true else {Int = (when (val x = "fail"!!) {

        else -> return "getX$x"
    }!!)}


    
val d = "OK"
when ((d)) {


}

}