package funsets

import com.sun.corba.se.spi.orb.Operation

object Currying {
	def product(f: Int => Int)(a: Int, b:Int): Int = {
		if (a > b) 1
		else f(a)*product(f)(a+1, b)
	}                                         //> product: (f: Int => Int)(a: Int, b: Int)Int
  
  
  def factorial(n: Int) = product(x => x)(1,n)    //> factorial: (n: Int)Int
  
  
  factorial(4)                                    //> res0: Int = 24
  factorial(5)                                    //> res1: Int = 120
  
  product(x => x*x)(2, 3)                         //> res2: Int = 36
  
  
  def calc(f: Int => Int, unit: Int, doMult: Boolean)(a: Int, b:Int): Int = {
		if (a > b) unit
		else if(doMult) f(a)*calc(f,unit,doMult)(a+1, b)
		else f(a)+calc(f,unit,doMult)(a+1, b)
		
	}                                         //> calc: (f: Int => Int, unit: Int, doMult: Boolean)(a: Int, b: Int)Int
	
	
	
	def calc2(f: Int => Int, unit: Int, combine: (Int, Int) => Int)(a: Int, b:Int): Int = {
		if (a > b) unit
		else combine(f(a), calc2(f, unit, combine)(a+1, b))
		
	}                                         //> calc2: (f: Int => Int, unit: Int, combine: (Int, Int) => Int)(a: Int, b: Int
                                                  //| )Int
	
	calc(x=>x, 0, false)(1,3)                 //> res3: Int = 6
	
  calc2(x=>x, 1, (x: Int, y: Int) => x*y)(1,5)    //> res4: Int = 120

}