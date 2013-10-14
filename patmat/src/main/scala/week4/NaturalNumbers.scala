package week4

object NaturalNumbers {
    def main(args: Array[String]) {
        println("==== " + (Zero.successor.successor.successor - Zero.successor.successor+ Zero.successor).numRep)
    }
}


abstract class Nat {
  def isZero: Boolean
  def predecessor: Nat
  def successor: Nat
  def + (that: Nat): Nat
  def - (that: Nat): Nat
  
  
  def numRep: Int 
  override def toString() = numRep + ""
}




object Zero extends Nat {
    def isZero =  true
    def predecessor: Nat = throw new NoSuchElementException("No predeccessor to zero") 
    def successor: Nat = new Succ(this)    
    def + (that: Nat): Nat = that
    def - (that: Nat): Nat = if (that.isZero) Zero else throw new NoSuchElementException("Can subtract from zero")
    def numRep: Int = 0
}


class Succ(n: Nat) extends Nat {
    
    def isZero = false
    def predecessor: Nat = n
    def successor: Nat = new Succ(this)
    def + (that: Nat): Nat = new Succ(n + that)

//    def ++ (that: Nat): Nat = {
//        def plusAcc(thatRemaining: Nat, acc: Nat): Nat =  {
//            if (thatRemaining.isZero) acc
//            else plusAcc(thatRemaining.predecessor, acc.successor)
//        }
//        plusAcc(that, this)
//    }
    
    
    def - (that: Nat): Nat = if(that.isZero) this else n - that.predecessor
    
//    def -- (that: Nat): Nat = {
//        def minusAcc(thatRemaining: Nat, acc: Nat): Nat =  {
//            if (thatRemaining.isZero) acc
//            else if (acc.isZero) throw new NoSuchElementException("Subtraction would lead to undefined number")
//            else minusAcc(thatRemaining.predecessor, acc.predecessor)
//        }
//        minusAcc(that, this)
//    }
    
    def numRep: Int = predecessor.numRep + 1
    
}