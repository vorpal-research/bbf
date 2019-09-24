class CallbackBlock {}

public class Foo
{
    companion object {
        private var bar = 1477971286
    }

    init {
        --bar
    }

    fun getBar(): (Int)? = bar
}

fun box() : (String)? {

    val foo = Foo()

    if (foo!!.getBar() == 1) {
println("THEN");
return "Fail"
};

    return "OK"
}