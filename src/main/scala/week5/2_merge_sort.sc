def msort(xs: List[Int]): List[Int] = {
  val n = xs.length / 2
  if (n == 0) xs
  else {
    def merge(xs: List[Int], ys: List[Int]): List[Int] = (xs, ys) match {
      case (Nil, ys1) => ys1
      case (xs1, Nil) => xs1
      case (x :: xs1, y :: ys1) =>
        if (x < y) x :: merge(xs1, ys)
        else y :: merge(xs, ys1)
    }

    val (first, second) = xs splitAt n
    merge(msort(first), msort(second))
  }
}

//tuples
val pair = ("answer", 42)
val (label, value) = pair

val tuple = ("answer", 42, 3.3)
val (label2, val1, val2) = tuple

val in = List(5, 11, 2, -5, 4, 32, 9)
msort(in)
