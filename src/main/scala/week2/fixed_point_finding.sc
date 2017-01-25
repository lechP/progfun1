val tolerance = 0.0001

def abs(x: Double) = if (x < 0) -x else x
def isCloseEnough(x: Double, y: Double) =
  abs((x - y) / x) < tolerance
def fixedPoint(f: Double => Double)(firstGuess: Double) = {
  def iterate(guess: Double): Double = {
    val next = f(guess)
    if (isCloseEnough(guess, next)) next
    else iterate(next)
  }
  iterate(firstGuess)
}

fixedPoint(x => 1 + 0.5 * x)(0)

def averageDamp(f: Double => Double)(x: Double) = (x + f(x)) / 2

def sqrt(x: Double) = fixedPoint(averageDamp(y => x / y))(2.0)

sqrt(16)