def product(f: Int => Int, a: Int, b: Int): Int = {
  if (a>b) 1
  else f(a) * product(f, a+1, b)
}

def curryproduct(f: Int=>Int)(a: Int, b: Int): Int = {
  if (a>b) 1
  else f(a) * curryproduct(f)(a+1, b)
}

product(x=>x*x, 3, 4)
curryproduct(x=>x*x)(3, 4)

def factorial(a: Int): Int = {
  product(x=>x, 1, a)
}

def curryfactorial(n: Int): Int =
  curryproduct(x=>x)(1, n)

factorial(5)
curryfactorial(5)

def mapReduce(f: Int=>Int, g: (Int, Int)=>Int)(a: Int, b: Int): Int = {
  if (a<b) g(f(a), mapReduce(f, g)(a+1, b))
  else f(a)
}

def mapReducev2(f: Int=>Int, g: (Int, Int)=>Int, zero: Int)(a: Int, b: Int): Int = {
  if (a>b) zero
  else g(f(a), mapReducev2(f, g, zero)(a+1, b))
}

mapReduce(x=>x*x, (x, y)=>x*y)(5, 4)
mapReducev2(x=>x*x, (x, y)=>x*y, 1)(3, 4)