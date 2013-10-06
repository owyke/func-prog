package funsets
import math.abs;

object FixedPoint {
	
	
	val tolerance = 0.0001;                   //> tolerance  : Double = 1.0E-4
	def isCloseEnough(x: Double, y: Double) =
		abs(x - y) < 0.0001;              //> isCloseEnough: (x: Double, y: Double)Boolean
		
		def fixedPoint(f: Double => Double)(firstGuess: Double) = {
			def iterate(guess: Double): Double = {
				val next = f(guess);
				if( isCloseEnough(guess, next)) next
				else iterate(next)
				}
				iterate(firstGuess)
		}                                 //> fixedPoint: (f: Double => Double)(firstGuess: Double)Double
	
	def avrageDamp(f: Double => Double)(x: Double) = (x + f(x)) / 2
                                                  //> avrageDamp: (f: Double => Double)(x: Double)Double
	
	def sqrt(x: Double) = fixedPoint(y => +x / y)(1)
                                                  //> sqrt: (x: Double)Double


	def sqrt2(x: Double) = fixedPoint(avrageDamp(y => x / y))(1)
                                                  //> sqrt2: (x: Double)Double
 
	sqrt2(2)                                  //> res0: Double = 1.4142135623746899
	
}