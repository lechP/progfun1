package week3.list

trait List[+T] {
  def isEmpty: Boolean

  def head: T

  def tail: List[T]

  def prepend[U >: T](elem: U) : List[U] = new Cons(elem, this)

  def nth(n: Int): T = {
    def loop(n: Int, list: List[T]): T = {
      println(n)
      if (isEmpty) throw new IndexOutOfBoundsException
      else if (n == 0) head else loop(n - 1, tail)
    }
    loop(n, this)
  }
}
