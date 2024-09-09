class Rational(n: Int, d: Int) {
  require(d != 0, "Denominator cannot be zero")

  // Simplify the fraction by dividing by gcd
  private val g = gcd(n.abs, d.abs)
  val numer: Int = n / g
  val denom: Int = d / g

  // Auxiliary constructor for whole numbers
  def this(n: Int) = this(n, 1)

  // Method to negate a rational number (neg)
  def neg: Rational = new Rational(-numer, denom)

  // Method to subtract two rational numbers (sub)
  def sub(that: Rational): Rational = {
    new Rational(
      numer * that.denom - that.numer * denom, // Cross multiply numerators
      denom * that.denom                      // Multiply denominators
    )
  }

  // Override toString to display Rational in fraction form
  override def toString: String = s"$numer/$denom"

  // Helper method to calculate greatest common divisor (gcd)
  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
}

object RationalExample extends App {

  // Creating rational numbers
  val x = new Rational(3, 4)  // x = 3/4
  val y = new Rational(5, 8)  // y = 5/8
  val z = new Rational(2, 7)  // z = 2/7

  // Using neg method to negate x
  println(s"x.neg = ${x.neg}")  

  // Using sub method to calculate y - z
  val result = y.sub(z)
  println(s"y - z = $result")   
}
