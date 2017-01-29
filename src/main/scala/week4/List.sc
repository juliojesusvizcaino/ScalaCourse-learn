import week3.{List, Cons, Nil}

object List {
  def apply[T](x1: T,x2: T): List[T] = new Cons(x1, new Cons(x2, new Nil))

  def apply[T](x1: T): List[T] = new Cons(x1, new Nil)

  def apply[T](): List[T] = new Nil
}

List(3)
List(3, 4)
List()