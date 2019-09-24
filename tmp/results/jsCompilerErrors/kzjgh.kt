
typealias AddLastDesc<T> = AddLastDesc2<T>
class AddLastDesc2<
 T : LockFreeLinkedListNode>(
 node: T)
class SendBuffered : AddLastDesc<*>()
