val nums = List(2, -4, 5, 7, 1)

def sum(xs: List[Int]) = (0 :: xs) reduceLeft ((x, y) => x + y)
//underscore notation
def product(xs: List[Int]) = (1 :: xs) reduceLeft (_ * _)

//reduceleft alternative: foldleft
def sum2(xs: List[Int]) = (xs foldLeft 0) (_ + _)

sum(nums)
product(nums)

//there are dual functions: reduceRight and foldRight
def lengthFun[T](xs: List[T]): Int =
(xs foldRight 0) ((x, y) => 1 + y)

def mapFun[T, U](xs: List[T], f: T => U): List[U] =
  (xs foldRight List[U]()) ((x, y) => f(x) :: y)