val fruit = List("apples", "oranges", "pears")
val first = fruit.head

//alternative syntax
val fruit2 = "apples" :: ("oranges" :: ("pears" :: Nil))
//:: is right associative
val fruit3 = "apples" :: "oranges" :: "pears" :: Nil


def isort(xs: List[Int]): List[Int] = xs match {
  case List() => List()
  case y :: ys => insert(y, isort(ys))
}

def insert(x: Int, xs: List[Int]): List[Int] = xs match {
  case List() => List(x)
  case y :: ys => if (y > x) x :: insert(y, ys) else y :: insert(x, ys)
}

val input = List(11, 4, 76, 4, 2, 10, 76)
val output = isort(input)


