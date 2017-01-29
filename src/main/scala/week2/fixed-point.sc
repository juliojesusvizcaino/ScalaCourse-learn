import math.abs

val tolerance = 0.000000001
def isCloseEnough(x: Double, y: Double): Boolean = {
  (abs(x-y)/x) < tolerance
}

def fixedPoint(f: Double=>Double)(point: Double): Double = {
  if (isCloseEnough(point, f(point))) point
  else fixedPoint(f)(f(point))
}

fixedPoint(x => x/2 + 1)(1)

def averageDamp(f: Double=>Double)(x: Double): Double = {
  (x + f(x))/2
}

def sqrt(x: Double) = fixedPoint(averageDamp(y => x/y))(1)

sqrt(2)