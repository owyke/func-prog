package funsets
import math.abs;

object FixedPoint {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(82); 
	
	
	val tolerance = 0.0001;System.out.println("""tolerance  : Double = """ + $show(tolerance ));$skip(66); ;
	def isCloseEnough(x: Double, y: Double) =
		abs(x - y) < 0.0001;System.out.println("""isCloseEnough: (x: Double, y: Double)Boolean""");$skip(230); ;
		
		def fixedPoint(f: Double => Double)(firstGuess: Double) = {
			def iterate(guess: Double): Double = {
				val next = f(guess);
				if( isCloseEnough(guess, next)) next
				else iterate(next)
				}
				iterate(firstGuess)
		};System.out.println("""fixedPoint: (f: Double => Double)(firstGuess: Double)Double""");$skip(67); 
	
	def avrageDamp(f: Double => Double)(x: Double) = (x + f(x)) / 2;System.out.println("""avrageDamp: (f: Double => Double)(x: Double)Double""");$skip(52); 
	
	def sqrt(x: Double) = fixedPoint(y => +x / y)(1);System.out.println("""sqrt: (x: Double)Double""");$skip(65); 


	def sqrt2(x: Double) = fixedPoint(avrageDamp(y => x / y))(1);System.out.println("""sqrt2: (x: Double)Double""");$skip(12); val res$0 = 
 
	sqrt2(2);System.out.println("""res0: Double = """ + $show(res$0))}
	
}
