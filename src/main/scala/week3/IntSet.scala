package week3

abstract class IntSet {
  def incl(x: Int): IntSet

  def contains(x: Int): Boolean

  def union(other: IntSet): IntSet

  def unionn(x: IntSet): IntSet
}

class Empty extends IntSet {
  def contains(x: Int) = false

  def incl(x: Int) = new NonEmpty(x, new Empty, new Empty)

  def union(other: IntSet): IntSet = other

  override def unionn(x: IntSet) = new Empty

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