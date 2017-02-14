import course2.week1.gen.Generator

val integers = new Generator[Int] {
  override def generate: Int = {
    new java.util.Random().nextInt()
  }
}

val booleans = for (x <- integers) yield x > 0
val booleans2 = integers map { x => x > 0 }


val pairs = for {
  x <- integers
  y <- integers
} yield (x, y)

val pairs2 = integers flatMap { x => integers map { y => (x, y) } }

def genericPairs[T, U](t: Generator[T], u: Generator[U]) = t flatMap {
  x => u map { y => (x, y) }
}


def single[T](x: T): Generator[T] = new Generator[T] {
  override def generate: T = x
}

def choose(lo: Int, hi: Int): Generator[Int] = for (x <- integers) yield lo + x % (hi - lo)

def oneOf[T](xs: T*): Generator[T] =
  for (idx <- choose(0, xs.length)) yield xs(idx)


//list generator
def lists: Generator[List[Int]] = for {
  isEmpty <- booleans
  list <- if (isEmpty) emptyLists else nonEmptyLists
} yield list

def emptyLists = single(Nil)

def nonEmptyLists = for {
  head <- integers
  tail <- lists
} yield head :: tail

val list = lists.generate

//generation of trees
trait Tree

case class Inner(left: Tree, right: Tree) extends Tree

case class Leaf(x: Int) extends Tree

def trees: Generator[Tree] = for {
  isLeaf <- booleans
  tree <- if (isLeaf) leafs else branches
} yield tree

def leafs = for (x <- integers) yield Leaf(x)

def branches = for {
  left <- trees
  right <- trees
} yield Inner(left, right)

val tree = trees.generate


//random test function
def test[T](g: Generator[T], numTimes: Int = 100)
           (testCondition: T => Boolean): Unit = {
  for (i <- 0 until numTimes) {
    val value = g.generate
    assert(testCondition(value), "test failed for " + value)
  }
  println("passed " + numTimes + " tests")
}

test(genericPairs(lists, lists)) {
  case (xs, ys) => (xs++ys).length > xs.length
}

