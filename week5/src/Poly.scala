object Polynom {


    

    class Poly(terms0: Map[Int, Double]) {
        def this(bindings: (Int, Double)*) = this(bindings.toMap)
        
        val terms = terms0 withDefaultValue 0.0
        def + (other: Poly) = {
            new Poly(terms ++ (other.terms map adjust))
        }
        
        def ++ (other: Poly) = 
          new Poly((other.terms foldLeft terms)(addTerm))
        
        def addTerm(terms: Map[Int, Double], term: (Int, Double)) = {
            val (exp, coeff) = term
            terms + (exp -> (terms(exp) + coeff))
        }
            
             
        def adjust(term: (Int, Double)): (Int, Double) = {

            val(exp, coeff) = term
            exp -> (coeff + terms(exp))
        }
        
        override def toString =
            (for ((exp, coeff) <- terms.toList.sorted.reverse) yield coeff + "x^" + exp) mkString " + "
    }

    def main(args: Array[String]): Unit = {
        val p1 = new Poly(1 -> 2.0, 3 -> 6.0)
        val p2 = new Poly(2-> 4.0, 3-> 4.0)
        
        println(p1)
        println(p2)
        println(p1 + p2)
        println(p2 ++ p1)

                        
    }
    

}