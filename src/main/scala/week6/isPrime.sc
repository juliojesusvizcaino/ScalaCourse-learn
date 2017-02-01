import scala.collection.immutable.IndexedSeq

def isPrime(n: Int): Boolean = 2 until n forall (x => n % x != 0)

isPrime(6871)

def pairSumMap(n: Int)(f: Int => Boolean): IndexedSeq[(Int, Int)] = {
  1 to n flatMap (x =>
    1 to x map (y =>
      (x, y))) filter (pair =>
    f(pair._1 + pair._2))
}

def pairSumFor(n: Int)(f: Int => Boolean): IndexedSeq[(Int, Int)] = {
  for {x <- 1 to n
       y <- 1 to x
       if f(x + y)
  } yield (x, y)
}

pairSumMap(6)(isPrime)
pairSumFor(6)(isPrime)