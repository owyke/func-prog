package recfun
import common._

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = if(c==0) 1 else if(c==r) 1 else pascal(c-1, r-1) + pascal(c, r-1)

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    
    def plusMinusBalance(chars: List[Char], bal: Int): Boolean = {

      if(bal<0)  false
      else if(chars.isEmpty) bal==0
      else if(chars.head == '(') {
        plusMinusBalance(chars.tail, bal+1)
      } else if (chars.head == ')'){
        plusMinusBalance(chars.tail, bal-1)
      } else {
        plusMinusBalance(chars.tail, bal)
      }
    }
    plusMinusBalance(chars, 0)
  }

  /**
   * Exercise 3
   */

  
    def countChange(money: Int, denominations: List[Int]): Int = {
          
      if(money == 0) 1 
      else if (money < 0 || denominations.isEmpty) 0 
      else countChange(money, denominations.tail) + countChange(money - denominations.head, denominations)
        
  }
  
  
  
}
