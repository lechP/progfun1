def msort[T](xs: List[T])(implicit ord: Ordering[T]): List[T] = {
  val n = xs.length / 2
  if (n == 0) xs
  else {
    def merge(xs: List[T], ys: List[T]): List[T] = (xs, ys) match {
      case (Nil, ys1) => ys1
      case (xs1, Nil) => xs1
      case (x :: xs1, y :: ys1) =>
        if (ord.lt(x, y)) x :: merge(xs1, ys)
        else y :: merge(xs, ys1)
    }

    val (first, second) = xs splitAt n
    merge(msort(first), msort(second))
  }
}

val nums = List(2, -4, 5, 7, 1)
val fruits = List("apple", "pineapple", "orange", "Banana")
msort(nums)
msort(fruits)