val romanNumerals = Map("I" -> 1, "V" -> 5, "X" -> 10)
val capitalOfCountry = Map("US" -> "Washington", "Switzerland" -> "Zurich", "Poland" -> "Warsaw")

capitalOfCountry get "US"
capitalOfCountry get "andorra"


val fruit = List("apple", "pear", "orange", "pineapple")

fruit groupBy (_.head)

//polynomial as map

class Poly(terms0: Map[Int, Double]) {

  def this(bindings: (Int, Double)*) = this(bindings.toMap)

  val terms = terms0 withDefaultValue 0.0

  def +(other: Poly) = new Poly(terms ++ (other.terms map adjust))

  def +#(other: Poly) = new Poly((other.terms foldLeft terms)(addTerm))

  def addTerm(terms: Map[Int, Double], term: (Int, Double)) =
    terms.updated(term._1, term._2 + terms(term._1))

  def adjust(term: (Int, Double)): (Int, Double) =
    term._1 -> (term._2 + terms(term._1))


  override def toString =
    (for ((exp, coeff) <- terms.toList.sorted.reverse) yield coeff + "x^" + exp) mkString " + "
}


val p1 = new Poly(1 -> 2.0, 3 -> 4.0, 5 -> 6.2)
val p2 = new Poly(0 -> 3.0, 3 -> 7.0)

p1 + p2

p1 +# p2

