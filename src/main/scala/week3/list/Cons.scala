package week3.list

class Cons[T](val head: T, val tail: List[T]) extends List[T] {

  override def isEmpty = false

}
