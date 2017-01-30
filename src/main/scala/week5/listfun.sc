def pack[T](xs: List[T]): List[List[T]] = xs match {
  case Nil => Nil
  case x :: xs1 => {
    val (a, b) = xs span (x2 => x2 == x)
    a :: pack(b)
  }
}

pack(List("a", "a", "a", "b", "c", "c", "a"))