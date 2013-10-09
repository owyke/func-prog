package week4



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

object Nil[T] extends List[T] {
    def head: Nothing = throw new java.util.NoSuchElementException("head of EmptyList")
    def tail: Nothing = throw new java.util.NoSuchElementException("tail of EmptyList")
    def isEmpty = true
}

class Cons(val head: Tweet, val tail: TweetList) extends TweetList {
    def isEmpty = false
}


object ListStuff {
  println("Welcome to the Scala worksheet")
}
