val xs = List(1, 2, 3, 10, 25, 4)
//first elem and remaining list
xs.head
xs.tail
//last elem and 'remaining' list
xs.last
xs.init

def init[T](xs: List[T]): List[T] = xs match {
  case List() => throw new Error("init of empty list")
  case List(x) => List()
  case y :: ys => y :: init(ys)
}

init(xs)

val zs = List(3, 5, 11)
//concatenation possibilities
xs ::: zs
xs ++ zs

def concat[T](xs: List[T], ys: List[T]): List[T] = xs match {
  case List() => ys
  case w :: ws => w :: concat(xs, ys)
}


//reverse
def reverse[T](xs: List[T]): List[T] = xs match {
  case List() => xs
  case y :: ys => reverse(ys) ++ List(y)
}

def removeAt[T](n: Int, xs: List[T]): List[T] =
  if (n >= xs.length || n < 0) throw new Error("no such element")
  else {
    if (n == 0) xs.tail
    else xs.head :: removeAt(n - 1, xs.tail)
  }

def removeAtShort[T](n: Int, xs: List[T]): List[T] = (xs take n) ++ (xs drop n + 1)


removeAt(2, xs)

