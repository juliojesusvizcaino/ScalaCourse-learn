def msort[T](xs: List[T])(implicit ord: Ordering[T]): List[T] = {
  val n = xs.length / 2
  if (n == 0) xs
  else {
    def merge(xs: List[T], ys: List[T]): List[T] = (xs, ys) match {
      case (Nil, _) => ys
      case (_, Nil) => xs
      case (x2 :: xs1, y2 :: ys1) =>
        if (ord.lt(x2, y2)) x2 :: merge(xs1, ys)
        else y2 :: merge(xs, ys1)
    }

    val (x, y) = xs splitAt n
    merge(msort(x), msort(y))
  }
}

val nums = List(-5, -9, 2, 5, 1, -8, 15)
val words = List("house", "dog", "cat", "monkey", "utils", "onion", "common")
msort(nums)
msort(words)