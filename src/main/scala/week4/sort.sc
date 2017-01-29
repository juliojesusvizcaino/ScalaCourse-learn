// sort a List ascending

def isort(xs: List[Int]): List[Int] = xs match {
  case List() => List()
  case y :: ys => insert(y, isort(ys))
}

def insert(x: Int, xs: List[Int]): List[Int] = xs match {
  case List() => List(x)
  case y :: ys =>
    if (x < y) x :: xs
    else y :: insert(x, ys)
}

isort(8::3::4::2::8::Nil)