package objsets

abstract class IntSet {
	def incl(x: Int): IntSet
	def contains(x: Int): Boolean
	def union(other: IntSet): IntSet
}

class Empty extends IntSet {
	def incl(x: Int): IntSet = new NonEmpty(x, new Empty, new Empty)
	def contains(x: Int): Boolean = false
	def union(other: IntSet): IntSet = ???
}

class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet {
	def incl(x: Int): IntSet = ???
	def contains(x: Int): Boolean = ???
	def union(other: IntSet): IntSet = ???
}

object IntSet {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(555); 
  println("Welcome to the Scala worksheet")}
}
