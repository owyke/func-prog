package funsets

import com.sun.corba.se.spi.orb.Operation

object Currying {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(179); 
	def product(f: Int => Int)(a: Int, b:Int): Int = {
		if (a > b) 1
		else f(a)*product(f)(a+1, b)
	};System.out.println("""product: (f: Int => Int)(a: Int, b: Int)Int""");$skip(53); 
  
  
  def factorial(n: Int) = product(x => x)(1,n);System.out.println("""factorial: (n: Int)Int""");$skip(21); val res$0 = 
  
  
  factorial(4);System.out.println("""res0: Int = """ + $show(res$0));$skip(15); val res$1 = 
  factorial(5);System.out.println("""res1: Int = """ + $show(res$1));$skip(29); val res$2 = 
  
  product(x => x*x)(2, 3);System.out.println("""res2: Int = """ + $show(res$2));$skip(199); 
  
  
  def calc(f: Int => Int, unit: Int, doMult: Boolean)(a: Int, b:Int): Int = {
		if (a > b) unit
		else if(doMult) f(a)*calc(f,unit,doMult)(a+1, b)
		else f(a)+calc(f,unit,doMult)(a+1, b)
		
	};System.out.println("""calc: (f: Int => Int, unit: Int, doMult: Boolean)(a: Int, b: Int)Int""");$skip(173); 
	
	
	
	def calc2(f: Int => Int, unit: Int, combine: (Int, Int) => Int)(a: Int, b:Int): Int = {
		if (a > b) unit
		else combine(f(a), calc2(f, unit, combine)(a+1, b))
		
	};System.out.println("""calc2: (f: Int => Int, unit: Int, combine: (Int, Int) => Int)(a: Int, b: Int)Int""");$skip(29); val res$3 = 
	
	calc(x=>x, 0, false)(1,3);System.out.println("""res3: Int = """ + $show(res$3));$skip(50); val res$4 = 
	
  calc2(x=>x, 1, (x: Int, y: Int) => x*y)(1,5);System.out.println("""res4: Int = """ + $show(res$4))}

}
