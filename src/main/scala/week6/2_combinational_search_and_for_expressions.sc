val n = 7

def isPrime(n: Int): Boolean = (2 until n) forall (d => n % d != 0)

val xss = (1 until n).flatMap(j =>
  (1 until j) map (i => (i, j))) filter (pair => isPrime(pair._1 + pair._2))


//equivalent with for
val yss = for {
  j <- 1 until n
  i <- 1 until j
  if isPrime(i + j)
} yield (i, j)


def scalarProduct(xs: List[Double], ys: List[Double]): Double =
  (for ((x, y) <- xs zip ys) yield x * y).sum