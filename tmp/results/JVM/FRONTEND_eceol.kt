class AddLastDesc2<
 T : LockFreeLinkedListNode>(
 node: T)
typealias AddLastDesc<T> = AddLastDesc2<T>
fun 
()  {
     object : AddLastDesc<*>() {}
}