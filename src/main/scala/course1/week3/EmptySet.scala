package course1.week3

object EmptySet extends IntSet {
  override def contains(x: Int): Boolean = false

  override def incl(x: Int): IntSet = new NonEmptySet(x, EmptySet, EmptySet)

  override def toString = "."

  override def union(other: IntSet): IntSet = other
}
