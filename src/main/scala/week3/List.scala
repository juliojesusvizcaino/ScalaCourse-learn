package week3

trait List[+T] {
  def isEmpty: Boolean
  def head: T
  def tail: List[T]
  def prepend[U >: T](elem: U): List[U] = new Cons(elem, this)
}

class Cons[T](val head: T, val tail: List[T]) extends List[T] {
  override def isEmpty = false

//  override def toString: String = head + "->" + tail
}

object Nil extends List[Nothing] {
  override def isEmpty = true
  override def head: Nothing = throw new NoSuchElementException("Nil.head")
  override def tail: Nothing = throw new NoSuchElementException("Nil.tail")

//  override def toString: String = "."
}

object Algo {
  def main(args: Array[String]): Unit = {
    val a = new Cons(3, Nil)
    val b = Nil
    println(a)
    println(a prepend b)
    println(a.prepend(3))
    def f(xs: List[NonEmpty], x: Empty) = xs prepend x
  }
}