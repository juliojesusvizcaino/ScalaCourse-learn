def pack[T](xs: List[T]): List[List[T]] = xs match {
  case Nil => Nil
  case x :: _ =>
    val (a, b) = xs span (x2 => x2 == x)
    a :: pack(b)
}

pack(List("a", "a", "a", "b", "c", "c", "a"))

def encode[T](xs: List[T]): List[(T, Int)] = pack(xs) map (y => (y.head, y.length))

encode(List("a", "a", "a", "b", "c", "c", "a"))