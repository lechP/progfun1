def sum_plain(f: Int => Int, a: Int, b: Int): Int =
  if (a > b) 0
  else f(a) + sum_plain(f, a + 1, b)

//predefined sub-function
def cube(x: Int): Int = x * x * x
def sumCubes(a: Int, b: Int) = sum_plain(cube, a, b)

//anonymous sub-function (similar concept as 'literal' for String)
def sumCubes2(a: Int, b: Int) = sum_plain(x => x * x * x, a, b)


def sum(f: Int => Int)(a: Int, b: Int): Int = {
  def loop(a: Int, acc: Int): Int = {
    if (a > b) acc
    else loop(a + 1, acc + f(a))
  }
  loop(a, 0)
}


def product(f: Int => Int)(a: Int, b: Int): Int = {
  def loop(a: Int, acc: Int): Int = {
    if (a > b) acc
    else loop(a + 1, acc * f(a))
  }
  loop(a, 1)
}

//define factorial in terms of product
def factorial(n: Int) = {
  product(x => x)(1, n)
}

factorial(5)

//generic aggregation - my solution
def genericAggregation(aggregateOp: (Int, Int) => Int, unit: Int)(f: Int => Int)(a: Int, b: Int): Int = {
  def loop(a: Int, acc: Int): Int = {
    if (a > b) acc
    else loop(a + unit, aggregateOp(acc, f(a)))
  }
  loop(a, unit)
}

genericAggregation((x, y) => x * y, 1)(x => x)(1, 5)
//generic aggregation - lecture version
def mapReduce(f: Int => Int, combine: (Int, Int) => Int, unit: Int)(a: Int, b: Int): Int = {
  if (a > b) unit
  else combine(f(a), mapReduce(f, combine, unit)(a + 1, b))
}

mapReduce(x => x, (x, y) => x * y, 1)(1, 5)