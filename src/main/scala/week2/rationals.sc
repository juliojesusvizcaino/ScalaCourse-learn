val x = new Rational(1, 3)
val y = new Rational(5, 7)
val z = new Rational(3, 2)

x.numer
x.denom
x.sub(y).sub(z)

x + y
x - y
-y + x

class Rational(x: Int, y: Int) {
  def numer = x
  def denom = y

  def unary_- =
    new Rational(-numer, denom)

  def add(that: Rational) =
    new Rational(numer * that.denom + that.numer*denom,
      denom * that.denom)

  def sub(that: Rational) =
    add(-that)

  override def toString: String = numer + "/" + denom

  def +(that: Rational) = add(that)
  def -(that: Rational) = sub(that)
}