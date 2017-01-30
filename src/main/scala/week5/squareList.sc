def squareListMatch(xs: List[Int]): List[Int] = xs match {
  case Nil => xs
  case y :: ys => List(y * y) ::: squareListMatch(ys)
}

def squareListMap(xs: List[Int]): List[Int] =
  xs map (x => x * x)

val nums = List(1, 2, 3, 4, 5)
squareListMatch(nums)
squareListMap(nums)