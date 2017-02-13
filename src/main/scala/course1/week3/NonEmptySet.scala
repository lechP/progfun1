package course1.week3

class NonEmptySet(elem: Int, left: IntSet, right: IntSet) extends IntSet {

  override def incl(x: Int): IntSet =
    if (x < elem) new NonEmptySet(elem, left incl x, right)
    else if (x > elem) new NonEmptySet(elem, left, right incl x)
    else this

  override def contains(x: Int): Boolean =
    if (x < elem) left contains x
    else if (x > elem) right contains x
    else true

  override def toString = "{" + left + elem + right + "}"

  override def union(other: IntSet): IntSet = {
    ((left union right) union other) incl elem
  }
}