package course1.week4

import course1.week3.list.{List, Cons, Nil}


object List {
  def apply[T](x1: T, x2: T): List[T] = new Cons(x1, new Cons(x2, Nil))
  def apply[T]() = Nil
}
