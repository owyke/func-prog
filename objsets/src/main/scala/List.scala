trait List[T] {
    def isEmpty: Boolean
    def head: T
    def tail: List[T]
}

class Cons[T](val head: T, val tail: List[T]) extends List[T] {
    def isEmpty = false
    override def toString = head + " " + tail.toString() 
}

class Nil[T] extends List[T]{
    def isEmpty = true
    def head = throw new NoSuchElementException("Nil.head")
    def tail = throw new NoSuchElementException("Nil.tail")
    override def toString = ""
    
}


object Run {

    def main(args: Array[String]) {
        val l = new Cons[Int](1,new Cons[Int](3,new Cons[Int](5, new Nil[Int])));
        println(l.tail.tail.head)
        val element = nth[Int](l, 1)
        println(element)
    }
    
    
    def nth[T](list: List[T], index: Int): T  = {
        if(list.isEmpty) 
            throw new IndexOutOfBoundsException
        else if (index == 0) 
            list.head
        else 
            nth(list.tail, index - 1)
    }
}
