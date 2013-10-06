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


object RationalNumbers {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(753); 
  
  val x = new Rational(1, 3);System.out.println("""x  : Rational = """ + $show(x ));$skip(29); 
  val y = new Rational(5, 7);System.out.println("""y  : Rational = """ + $show(y ));$skip(29); 
  val z = new Rational(3, 2);System.out.println("""z  : Rational = """ + $show(z ));$skip(68); 
  
  def gcd(a: Int, b: Int): Int = if(b == 0) a else gcd(b, a % b);System.out.println("""gcd: (a: Int, b: Int)Int""");$skip(9); val res$0 = 
  
  x<y;System.out.println("""res0: Boolean = """ + $show(res$0));$skip(12); val res$1 = 
 
 	x max z;System.out.println("""res1: Rational = """ + $show(res$1));$skip(11); val res$2 = 
 	x.max(z);System.out.println("""res2: Rational = """ + $show(res$2));$skip(14); val res$3 = 
  
  gcd(6,8);System.out.println("""res3: Int = """ + $show(res$3))}
  
  
  
}
