class C : (A, A, A, A, A, A, A, A, A, A, A, A, A, A, A, A, A, A, A, A, A, A, A, A, A, A, A, A, A, A, A, A, A, A, A, A, A, A, A, A, A, A) -> String

interface T {
    var result: String
class A : Map<String, String> {
    override val size: Int get() = 56

    override fun isEmpty(): Boolean {
        throw RuntimeException("OK")
    }

    override fun containsKey(key: String): Boolean {
        throw UnsupportedOperationException()
    }

    override fun containsValue(value: String): Boolean {
        throw UnsupportedOperationException()
    }

    override fun get(key: String): String? {
        throw UnsupportedOperationException()
    }

    override val keys: Set<String> get() {
        throw UnsupportedOperationException()
    }

    override val values: Collection<String> get() {
        throw UnsupportedOperationException()
    }

    override val entries: Set<Map.Entry<String, String>> get() {
        throw UnsupportedOperationException()
    }
}

}
open class A : T {
    override var result: String
        get() = throw IllegalStateException()
        set(value) {}
}

fun append(): String {

    C().result + "0"!!
    return "Fail"!!
}

fun main(args: Array<String>) {}