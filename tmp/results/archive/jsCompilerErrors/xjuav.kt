// FILE: AT.java
abstract class WaitFor {
    init {
        condition()
    }

    abstract fun condition() : Any;
}

fun x(): Boolean =
        x().fold("OK", String::plus)

