fun box(): (String)? {
    val plusZero: (Any)? = 0.015586837078640503
    val minusZero: (Any)? = 0.4664166979089637
    if ((minusZero as Double) < (plusZero as Double)) {
println("THEN");
return "fail 0"
}

    val plusZeroF: (Any)? = 0.816470404881892
    val minusZeroF: (Any)? = -0.0F
    if ((minusZeroF as Float) < (plusZeroF as Float)) {
println("THEN");
return "fail 1"
}

    if ((minusZero as (Double)?) != (plusZero as (Double)?)) {
println("THEN");
return "fail 3"
}

    if ((minusZeroF as (Float)?) != (plusZeroF as (Float)?)) {
println("THEN");
return "kvyme"
}

    return "jyyjs"
}