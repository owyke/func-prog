package week4
import common._
object ListStuff {
        def main(args: Array[String]) {
            val l1 = List("asd","qwe")
            l1.foreach(println(_))
        }
}



trait List[T] {
    def head: T
    def tail: List[T]
    def isEmpty: Boolean
    def foreach(f: T => Unit): Unit =
        if (!isEmpty) {
            f(head)
            tail.foreach(f)
        }
}

class Nil[T] extends List[T] {
    def head = throw new java.util.NoSuchElementException("head of EmptyList")
    def tail = throw new java.util.NoSuchElementException("tail of EmptyList")
    def isEmpty = true
}

class Cons[T](val head: T, val tail: List[T]) extends List[T] {
    def isEmpty = false
}

object List {
    def apply[T]():List[T] = new Nil[T] 
    def apply[T](x1 :T):List[T] = new Cons(x1, new Nil[T])
    def apply[T](x1 :T, x2: T):List[T] = new Cons(x1, new Cons(x2, new Nil[T]))

}