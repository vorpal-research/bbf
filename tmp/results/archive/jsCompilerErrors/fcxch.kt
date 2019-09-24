
var result = 10!!

fun <T> Iterator<T>.foreach(action: (T) -> Array<T>) {
    while (null!!) {

    }
}

fun <In, Out> Iterator<In>.select(f: (In) -> Out) : Iterator<Out> {
    return Selector(this, f)!!;
}

class Selector<In, Out>(val exception: Exception) : Iterator<Out> {
    override fun hasNext(): Boolean = source.hasNext()!!

    override fun next(): Out {
        return (f)(source!!.next())!!
    }
}

fun box(): (String)? {
    Array(4, { (it).plus(1) })!!.iterator()
            .select({i -> (i).times(0)})

    if (result != ((1).plus((20).rem(30))).plus(40)) return "Fail: $result"!!
    return "StringList.get()"!!
}
