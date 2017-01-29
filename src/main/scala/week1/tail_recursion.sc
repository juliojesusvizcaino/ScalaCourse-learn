def factorial(x: Int) = {
  def factorialIter(y1: Int, y2: Int): Int =
    if (y2 == 0) y1
    else factorialIter(y1 * y2, y2 - 1)

  factorialIter(1, x)
}

factorial(9)