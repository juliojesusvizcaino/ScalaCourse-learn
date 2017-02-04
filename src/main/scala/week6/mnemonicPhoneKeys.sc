import scala.io.Source

val in = Source.fromURL("http://lamp.epfl.ch/files/content/sites/lamp/files/teaching/progfun/linuxwords.txt")

val words = in.getLines().toList filter (word => word forall (chr => chr.isLetter))

val mnem = Map(
  '2' -> "ABC", '3' -> "DEF", '4' -> "GHI", '5' -> "JKL",
  '6' -> "MNO", '7' -> "PQRS", '8' -> "TUV", '9' -> "WXYZ"
)

val charCode: Map[Char, Char] = {
  for {
    (number, string) <- mnem
    char <- string
  } yield char -> number
}

def wordCode(word: String): String = word.toUpperCase map charCode

val wordsForNum: Map[String, Seq[String]] = words groupBy wordCode withDefaultValue Seq()

def encode(number: String): Set[List[String]] = {
  if (number.isEmpty) Set(List())
  else {
    for {
      x <- 1 to number.length
      word <- wordsForNum(number take x)
      rest <- encode(number drop x)
    } yield word :: rest
  }.toSet
}

encode("7225247386")

def translate(number: String): Set[String] =
  encode(number) map (_ mkString " ")

translate("7225247386")