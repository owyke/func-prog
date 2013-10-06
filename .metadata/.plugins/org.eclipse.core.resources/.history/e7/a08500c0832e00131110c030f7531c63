class Rational(x: Int, y: Int) {
	
	require(y != 0, "denominator must be nonzero")
	
	def this(x: Int) = this(x, 1)
	
//	val numer = x / gcd(x, y)
	//val denom = y / gcd(x, y)
	val numer = x
	val denom = y
	
	private def gcd(a: Int, b: Int): Int = if(b == 0) a else gcd(b, a % b)
	
	
	def  + (that: Rational) =
		new Rational(
			numer*that.denom + that.numer*denom,
			denom * that.denom)
	
	
	override def toString = numer / gcd(numer, denom) + "/" + denom / gcd(numer, denom)
			
	def unary_- = new Rational(-numer, denom)
	
	def - (that: Rational) = this + -that

	def < (that: Rational) = numer * that.denom < that.numer * denom

	def max(that: Rational) = if(this<(that)) that else this
}


object RationalNumbers {
  
  val x = new Rational(1, 3)                      //> x  : Rational = 1/3
  val y = new Rational(5, 7)                      //> y  : Rational = 5/7
  val z = new Rational(3, 2)                      //> z  : Rational = 3/2
  
  def gcd(a: Int, b: Int): Int = if(b == 0) a else gcd(b, a % b)
                                                  //> gcd: (a: Int, b: Int)Int
  
  x<y                                             //> res0: Boolean = true
 
 	x max z                                   //> res1: Rational = 3/2
 	x.max(z)                                  //> res2: Rational = 3/2
  
  gcd(6,8)                                        //> res3: Int = 2
  
  
  
}