def abs(x: Double) = if (x < 0) -x else x

//newton approximation of square root
def sqrt(x: Double) = {

  def sqrtIter(guess: Double): Double =
    if (isGoodEnough(guess)) guess
    else sqrtIter(improve(guess))

  def isGoodEnough(guess: Double) =
    abs(guess * guess - x) < 0.001 * x

  def improve(guess: Double) =
    (guess + x / guess) / 2

  sqrtIter(1.0)

}

//tests
sqrt(2)
sqrt(4)
sqrt(9)

sqrt(1e-6)
sqrt(0.1e-20)
sqrt(1.0e20)

sqrt(1.0e50)
