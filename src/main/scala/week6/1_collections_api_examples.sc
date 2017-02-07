val r: Range = 1 until 5
val s: Range = 1 to 5
1 to 10 by 3
6 to 1 by -2


s exists (c => c > 3)
s forall (c => c > 0)

val pairs = List(1, 2, 3) zip "Hello"
pairs.unzip

val n = "Hello world"
n flatMap (c => List('.', c))

def combinations(M: Int, N: Int) =
  (1 to M) flatMap (x => (1 to N) map (y => (x, y)))

combinations(4, 6)

def scalarProduct(xs: Vector[Double], ys: Vector[Double]): Double =
  (xs zip ys).map(xy => xy._1 * xy._2).sum
//(xs zip ys).map{ case (x,y) => x*y }.sum

scalarProduct(Vector(1, 2, 3), Vector(2, 2, 5))


def isPrime(n: Int): Boolean =  (2 until n) forall (d => n % d != 0)



