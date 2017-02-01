class Poly(terms1: Map[Int, Double]) {
  def this(bindings: (Int, Double)*) = this(bindings.toMap)

  val terms: Map[Int, Double] = terms1 withDefaultValue 0.0

  def +(other: Poly): Poly = new Poly((other.terms foldLeft terms) (addTerm))

  def addTerm(terms: Map[Int, Double], term: (Int, Double)): Map[Int, Double] = {
    val (exp, coeff) = term
    terms + (exp -> (coeff + terms(exp)))
  }

  override def toString: String =
    (for ((exp, coeff) <- terms.toList.sorted.reverse) yield coeff + "x^" + exp) mkString " + "
}

val poly1 = new Poly(0 -> 1.1, 2 -> 3.8, 7 -> 2.4)
val poly2 = new Poly(1 -> 3.0, 2 -> 0.2)

poly1 + poly2

poly1.terms(0)
poly1.terms get 0