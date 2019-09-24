class A<U : String, V : Int, W : V> : Set<W> {
    override val size: Int get() = 0
    override fun isEmpty(): Boolean = true
    override fun contains(o: W): Boolean = false
    override fun iterator(): Iterator<W> = single<W>().iterator()
    override fun containsAll(c: Collection<W>): Boolean = c.isEmpty()
}

public fun <T> Iterator<IllegalStateException>.iterator(): Iterator<*> = this
