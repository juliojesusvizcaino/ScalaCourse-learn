package Intsets

object Intsets {

  abstract class IntSet {
    def incl(x: Int): IntSet

    def contains(x: Int): Boolean

    def union(other: IntSet): IntSet

    def unionn(x: IntSet): IntSet
  }

  object Empty extends IntSet {
    def contains(x: Int) = false

    def incl(x: Int) = new NonEmpty(x, Empty, Empty)

    def union(other: IntSet): IntSet = other

    override def unionn(x: IntSet) = Empty

    override def toString: String = ""
  }

  class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet {
    def incl(x: Int): IntSet =
      if (x < elem) new NonEmpty(elem, left incl x, right)
      else if (x > elem) new NonEmpty(elem, left, right incl x)
      else this

    def contains(x: Int): Boolean =
      if (x < elem) left contains x
      else if (x > elem) right contains x
      else true

    def unionn(other: IntSet): IntSet = (left union right) union other

    def union(other: IntSet): IntSet =
      ((left union right) union other) incl elem

    override def toString: String = "{" + left + elem + right + "}"
  }

  //object IntSets {
  //  val x1 = new NonEmpty(1, Empty, Empty) incl 4 incl 2
  //  val x2 = new NonEmpty(3, Empty, Empty) incl -2 incl -1 incl 0 incl 5 incl 1 incl 7 incl 6 incl 8
  //  x2 unionn x1
  //  x2 union x1
  //  x1 union x2
  //}
}