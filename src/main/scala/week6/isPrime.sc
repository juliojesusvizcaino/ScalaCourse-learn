def isPrime(n: Int): Boolean = 2 until n forall (x => n % x != 0)

isPrime(6871)