val myString = "houses"
val charOcurrences = myString groupBy (c => c) mapValues (_.length)

val myNumbers = List(1, 2, 3, 1, 1, 3, 2, 1, 3, 4, 5, 6, 3, 2, 1, 4, 3, 2, 6, 8)
val numberOcurrences = (myNumbers groupBy (n => n) mapValues (_.length)).toList.sorted