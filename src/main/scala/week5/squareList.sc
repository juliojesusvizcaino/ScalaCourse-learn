def squareListMatch(xs: List[Int]): List[Int] = xs match {
  case Nil => xs
  case y :: ys => List(y * y) ::: squareListMatch(ys)
}

val nums = List(1, 2, 3, 4, 5)
squareListMatch(nums)