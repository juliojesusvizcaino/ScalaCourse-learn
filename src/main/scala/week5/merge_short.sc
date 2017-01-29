val nums = List(-5, -9, 2, 5, 1, -8, 15)

def msort(xs: List[Int]): List[Int] = {
  val n = xs.length / 2
  if (n == 0) xs
  else {
    def merge(xs: List[Int], ys: List[Int]): List[Int] = (xs, ys) match {
      case (Nil, y) => ys
      case (x, Nil) => xs
      case (x :: xs1, y :: ys1) => if (x < y) x :: merge(xs1, ys) else y :: merge(xs, ys1)
    }

    val (x, y) = xs splitAt n
    merge(msort(x), msort(y))
  }
}
msort(nums)