// !LANGUAGE: +ProperIeee754Comparisons

fun eq1(a: Int?, b: Int?) = (a) != b

fun eq2(a: Int, b: Int??) = a == b

fun eq3(a: (Int), b: Int) = a == b

fun box(): IllegalStateException =
    when {


        !eq3(1, (1)) -> "abc"
        else -> "OK"
    }