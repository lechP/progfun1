//map
def squareListStraightforward(xs: List[Int]): List[Int] =
xs match {
  case Nil => Nil
  case y :: ys => y * y :: squareListStraightforward(ys)
}

def squareListWithMap(xs: List[Int]): List[Int] = xs map (x => x * x)

val in = List(1, 2, 3, 4, 5)
val nums = List(2, -4, 5, 7, 1)
val fruits = List("apple", "pineapple", "orange", "banana")

squareListStraightforward(in)
squareListWithMap(in)

//filter
def posElems(xs: List[Int]): List[Int] = xs match {
  case Nil => xs
  case y :: ys => if (y > 0) y :: posElems(ys) else posElems(ys)
}

def posElemsConcise(xs: List[Int]): List[Int] = xs filter (x => x > 0)

nums partition (x => x > 0)

nums takeWhile (x => x > 0)
nums dropWhile (x => x > 0)
nums span (x => x > 0)


def pack[T](xs: List[T]): List[List[T]] = xs match {
  case Nil => Nil
  case x :: xs1 =>
    val (first, rest) = xs span (y => y == x)
    first :: pack(rest)

}

val letters = List("a", "a", "a", "b", "c", "c", "a")
pack(letters)

def encode[T](xs: List[T]): List[(T, Int)] = pack(xs) map (ys => (ys.head, ys.length))


encode(letters)


