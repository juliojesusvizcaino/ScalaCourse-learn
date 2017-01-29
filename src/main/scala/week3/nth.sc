import week3._

object nth {
  def nth[T](i: Int, l: List[T]): T = {
    if (l.isEmpty) throw new IndexOutOfBoundsException
    else if (i > 0) nth(i - 1, l.tail)
    else if (i == 0) l.head
    else throw new IndexOutOfBoundsException
  }

  val a = new Cons(3, new Cons(2, new Nil))
  nth(0, a)
  nth(1, a)
  nth(-1, a)
}