package week2

class Rational(x: Int, y: Int) {
  require(y != 0, "denominator must be nonzero")

  def this(x: Int) = this(x, 1)

  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

  private val g = gcd(x, y)

  def numerator = x / g

  def denominator = y / g

  def +(that: Rational) =
    new Rational(
      numerator * that.denominator + that.numerator * denominator,
      denominator * that.denominator)

  def unary_- : Rational = new Rational(-numerator, denominator)

  def -(that: Rational): Rational = this + -that

  def <(that: Rational) = numerator * that.denominator < that.numerator * denominator

  def max(that: Rational) = if (this < that) that else this

  override def toString: String = {
    numerator + "/" + denominator
  }

}
