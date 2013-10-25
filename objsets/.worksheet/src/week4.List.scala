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

class Nil[T] extends List[T] {
    def head: Nothing = throw new java.util.NoSuchElementException("head of EmptyList")
    def tail: Nothing = throw new java.util.NoSuchElementException("tail of EmptyList")
    def isEmpty = true
}

class Cons[T] (val head: T, val tail: List[T]) extends List[T] {
    def isEmpty = false
}

object List {
}
