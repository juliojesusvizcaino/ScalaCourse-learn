def pack[T](xs: List[T]): List[List[T]] = xs match {
  case Nil => Nil
  case x :: _ =>
    val (a, b) = xs span (x2 => x2 == x)
    a :: pack(b)
}

pack(List("a", "a", "a", "b", "c", "c", "a"))

def encode[T](xs: List[T]): List[(T, Int)] = pack(xs) map (y => (y.head, y.length))

encode(List("a", "a", "a", "b", "c", "c", "a"))

def mapFun[T, U](xs: List[T], f: T => U): List[U] =
  (xs foldRight List[U]()) (f(_) :: _)

def lengthFun[T](xs: List[T]): Int =
  (xs foldRight 0) ((_, y) => 1 + y)

mapFun(List(1, 2, 1, 1), (x: Int) => x + 4)
lengthFun(List(1, 2, 3, 4, 5, 6, 7))