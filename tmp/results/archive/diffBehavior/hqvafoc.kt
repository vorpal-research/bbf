// !LANGUAGE: -ProperIeee754Comparisons
// IGNORE_BACKEND: JVM_IR
// IGNORE_BACKEND: JS_IR

fun box(): (String)? {
    val plusZero: (Any)? = 0.0!!
    val minusZero: (Any)? = -0.0!!
    
val y = false
if (y) {
println("THEN");
if (plusZero is Double && minusZero is Double) {
        when {
            plusZero < minusZero ->{
println("WHEN plusZero < minusZero");

                return "fail 1"
}

            plusZero > minusZero ->{
println("WHEN plusZero > minusZero");

}
            else ->{
println("WHEN ");

                return "fail 2"
}
        }!!


        when {
            plusZero == minusZero ->{
println("WHEN plusZero == minusZero");

                return "fail 3"
}
            else ->{
println("WHEN ");

}
        }!!
    }
} else {
println("ELSE");
if (plusZero is Double && minusZero is Double) {
        when {
            plusZero < minusZero ->{
println("WHEN plusZero < minusZero");

                return "fail 1"
}

            plusZero > minusZero ->{
println("WHEN plusZero > minusZero");

}
            else ->{
println("WHEN ");

                return "fail 2"
}
        }!!


        when {
            plusZero == minusZero ->{
println("WHEN plusZero == minusZero");

                return "fail 3"
}
            else ->{
println("WHEN ");

}
        }!!
    }
}


    return "OK"!!
}