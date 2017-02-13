package course1.week3.list

class Cons[T](val head: T, val tail: List[T]) extends List[T] {

  override def isEmpty = false

  override def toString: String = head + " " + tail.toString

}
