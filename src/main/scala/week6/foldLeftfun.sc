def sum(list: List[Int]): Int = (list foldLeft 0) (_ + _)
def product(list: List[Int]): Int = (list foldLeft 1) (_ * _)
def count(list: List[Any]): Int = (list foldLeft 0) ((r, _) => r + 1)
def average(list: List[Int]): Double = (list foldLeft 0.0) (_ + _.toDouble / list.length)
def last[T](list: List[T]): T = (list foldLeft list.head) ((r, c) => c)
def doNothing[T](list: List[T]): List[T] = (list foldLeft List[T]()) ((r, c) => c :: r).reverse
def doNothing2[T](list: List[T]): List[T] = (list foldRight List[T]()) ((c, r) => c :: r)

val list = List(1, 2, 3, 4)
average(list)
last(list)
doNothing(list) == list
doNothing2(list) == list