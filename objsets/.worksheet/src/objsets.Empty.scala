package objsets

abstract class IntSet {
	def incl(x: Int): IntSet
	def contains(x: Int): Boolean
	def union(other: IntSet): IntSet
}

object Empty extends IntSet {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(230); 
	def incl(x: Int): IntSet = new NonEmpty(x, new Empty, new Empty);System.out.println("""incl: (x: Int)objsets.IntSet""");$skip(39); 
	def contains(x: Int): Boolean = false;System.out.println("""contains: (x: Int)Boolean""");$skip(40); 
	def union(other: IntSet): IntSet = ???;System.out.println("""union: (other: objsets.IntSet)objsets.IntSet""")}
}

class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet {
	def incl(x: Int): IntSet = ???
	def contains(x: Int): Boolean = ???
	def union(other: IntSet): IntSet = ???
}
