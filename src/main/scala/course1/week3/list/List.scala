package course1.week3.list

trait List[+T] {
  def isEmpty: Boolean

  def head: T

  def tail: List[T]

  def prepend[U >: T](elem: U) : List[U] = new Cons(elem, this)

  def nth(n: Int): T = {
    def loop(n: Int, list: List[T]): T = {
      println(list)
      if (isEmpty) throw new IndexOutOfBoundsException
      else if (n == 0) list.head else loop(n - 1, list.tail)
    }
    loop(n, this)
  }
}
