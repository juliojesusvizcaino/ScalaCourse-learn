def msort[T](xs: List[T])(implicit ord: Ordering[T]): List[T] = {
  val n = xs.length / 2
  if (n == 0) xs
  else {
    def merge(xs: List[T], ys: List[T]): List[T] = (xs, ys) match {
      case (Nil, y) => ys
      case (x, Nil) => xs
      case (x :: xs1, y :: ys1) =>
        if (ord.lt(x, y)) x :: merge(xs1, ys)
        else y :: merge(xs, ys1)
    }

    val (x, y) = xs splitAt n
    merge(msort(x), msort(y))
  }
}

val nums = List(-5, -9, 2, 5, 1, -8, 15)
val words = List("house", "dog", "cat", "monkey", "utils", "onion", "common")
msort(nums)
msort(words)