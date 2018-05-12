package leetcode.hard.arrayandstrings

/*

Any live cell with fewer than two live neighbors dies, as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population..
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.


 */





object Set289GameOfLife extends App {

  trait CellStatus
  object CellDiesUnderPopulation extends CellStatus
  object CellLivesNextGen extends CellStatus
  object CellDiesOverPopulation extends CellStatus
  object CellReborn extends CellStatus
  object NoChange extends CellStatus

  object CellStatus {

    def countOnes(board: Array[Array[Int]], r: Int, c: Int): Int = {

      val rows = board.length
      val cols = board(0).length

      def validCell(r: Int, c: Int): Boolean = {
        r >= 0 && r < rows &&
        c >=0 && c < cols
      }
      var count = 0
      for (row <- r-1 to r+1) {
        for (col <- c-1 to c+1) {
          if (validCell(row, col)) {
            count += 1
          }
        }
      }
      count
    }


    def apply(board: Array[Array[Int]], state: Int, r: Int, c: Int): CellStatus = {
      val ones = countOnes(board, r, c)
      (ones, state) match {
        case (x, _) if x < 2 => CellDiesUnderPopulation
        case (x, _) if x == 2 || x == 3 => CellLivesNextGen
        case (x, _) if x > 3 => CellDiesOverPopulation
        case (x, _) if x == 3 => CellReborn
        case _ => NoChange
      }

    }
  }


  def gameOfLife(board: Array[Array[Int]]): Unit = {

    val rows = board.length
    val cols = board(0).length

    val newBoard: Array[Array[Int]] = new Array(rows)(cols)

    for (i <- 0 to board.length-1) {
      for (j <- 0 to board(0).length-1) {

        CellStatus.apply(board, board(i)(j), i, j) match {
          case CellDiesUnderPopulation => newBoard(i)(j) = 0
          case CellLivesNextGen => newBoard(i)(j) = 1
          case CellDiesOverPopulation => newBoard(i)(j) = 1
          case CellReborn => newBoard(i)(j) = 1
          case NoChange => newBoard(i)(j) = board(i)(j)
        }
      }
    }

    for (i <- 0 to board.length-1) {
      for (j <- 0 to board(0).length-1) {
        board(i)(j) = newBoard(i)(j)
      }
    }
  }
}
