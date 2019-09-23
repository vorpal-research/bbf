// !LANGUAGE: +VariableDeclarationInWhenSubject

val dz = -0.0
val fz = -0.0f

fun box(): String {
    when (val y = dz) {
        0.0 ->{
println("WHEN 0.0");

}
        else -> {
println("WHEN ");
throw AssertionError()
}
    }

    when (val y = dz) {
        else ->{
println("WHEN ");

            if (y < 0.0) {
println("THEN");
throw AssertionError()
}
            if (y > 0.0) {
println("THEN");
throw AssertionError()
}
}
    }

    when (val y = fz) {
        0.0f ->{
println("WHEN 0.0f");

}
        else -> {
println("WHEN ");
throw AssertionError()
}
    }

    when (val y = fz) {
        else ->{
println("WHEN ");

            if (y < 0.0f) {
println("THEN");
throw AssertionError()
}
            if (y > 0.0f) {
println("THEN");
throw AssertionError()
}
}
    }

    testDoubleAsUpperBound(-0.0)

    return "OK"
}

fun <T: Double> testDoubleAsUpperBound(v: T): Boolean {
    return when (val a = v*v) {
        0.0 -> {
println("WHEN 0.0");
true
}
        else -> {
println("WHEN ");
throw AssertionError()
}
    }
}
