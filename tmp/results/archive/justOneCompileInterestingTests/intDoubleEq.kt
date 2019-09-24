package sample

// !LANGUAGE: +ProperIeee754Comparisons
fun ltDI(x: (Any)?, y: (Any)?) =
    x is Double && y is Int && x == y

fun main(args: Array<String>) {
    println(ltDI(0.0, 0))
}