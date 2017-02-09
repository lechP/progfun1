//N-Queens problem: 8x8 board, place queens
//such that none is threaten by another

def queens(n: Int): Set[List[Int]] = {
  def placeQueens(k: Int): Set[List[Int]] =
    if (k == 0) Set(List())
    else
      for {
        queens <- placeQueens(k - 1)
        col <- 0 until n
        if isSafe(col, queens)
      } yield col :: queens

  def isSafe(col: Int, queens: List[Int]): Boolean =
    isSafeOnColumn(col, queens) && isSafeOnDiagonal(col, queens)

  def isSafeOnColumn(col: Int, queens: List[Int]) = !queens.contains(col)

  def isSafeOnDiagonal(col: Int, queens: List[Int]) = {
    def isSafeOnDiagonal(distance: Int, queens: List[Int]): Boolean =
      if (queens.isEmpty) true
      else if (Math.abs(queens.head - col) == distance) false
      else isSafeOnDiagonal(distance + 1, queens.tail)

    isSafeOnDiagonal(1, queens)
  }

  placeQueens(n)
}

queens(4)
queens(5)
queens(8).size


def show(queens: List[Int]) = {
  val lines =
    for (col <- queens.reverse)
      yield Vector.fill(queens.length)("* ").updated(col, "X ").mkString
    "\n" + (lines mkString "\n")
}

(queens(8) take 3 map show) mkString "\n"

