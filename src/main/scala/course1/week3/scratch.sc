import course1.week3.{NonEmptySet, EmptySet}
import course1.week3.list._

new course1.week2.Rational(1, 2)


def error(msg: String) = throw new Error(msg)

val x = null
val y: String = x


if (false) 1 else false

val list = new Cons(1, new Cons(2, new Cons(3, Nil)))
list.nth(-2)

def nth[T](n: Int, xs: List[T]): T =
  if (xs.isEmpty) throw new IndexOutOfBoundsException
  else if (n == 0) xs.head else nth(n - 1, xs.tail)

nth(2, list)
nth(-2, list)

//covariance test
val w: List[String] = Nil

def f(xs: List[NonEmptySet]) = xs prepend EmptySet