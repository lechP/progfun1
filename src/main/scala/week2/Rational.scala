package week2

class Rational(x: Int, y: Int) {
  require(y != 0, "denominator must be nonzero")

  def this(x: Int) = this(x, 1)

  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

  private val g = gcd(x, y)

  def numerator = x / g

  def denominator = y / g

  def add(that: Rational) =
    new Rational(
      numerator * that.denominator + that.numerator * denominator,
      denominator * that.denominator)

  def neg: Rational = new Rational(-numerator, denominator)

  def sub(that: Rational): Rational = add(that.neg)

  def less(that: Rational) = numerator * that.denominator < that.numerator * denominator

  def max(that: Rational) = if (this.less(that)) that else this

  override def toString: String = {
    numerator + "/" + denominator
  }

}
