package objsets



object test {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(108); val res$0 = 
	//val t1 = new NonEmpty(3, new Empty, new Empty)
	//val t2 = t1.incl(4)
	1;System.out.println("""res0: Int(1) = """ + $show(res$0))}
	
}


abstract class IntSet {
	def incl(x: Int): IntSet
	def contains(x: Int): Boolean
	def union(other: IntSet): IntSet
}

class Empty extends IntSet {
	def incl(x: Int): IntSet = new NonEmpty(x, new Empty, new Empty)
	def contains(x: Int): Boolean = false
	def union(other: IntSet): IntSet = ???
	override def toString = "."
}

class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet {
	
	def incl(x: Int): IntSet =
		if (x < elem) new NonEmpty(elem, left incl x, right)
		else if (x > elem) new NonEmpty(elem, left, right incl x)
		else this
	
	def contains(x: Int): Boolean =
		if (x < elem) left contains x
		else if (x > elem) right contains x
		else true
		
		
		
	def union(other: IntSet): IntSet = ???
	
	override def toString = "{" + left + elem + right + "}"
}
