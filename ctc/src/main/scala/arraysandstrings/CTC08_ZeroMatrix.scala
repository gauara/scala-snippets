package arraysandstrings
import utils.MatrixUtils._

object CTC08_ZeroMatrix extends App {
  def setZeroes(matrix: Array[Array[Int]]): Unit = {
    val rows = matrix.length
    val cols = matrix(0).length

    val firstRowHasZero = {
      matrix(0).map(_ == 0).find(_ == true).getOrElse(false)
    }

    val firstColHasZero = {
      var break = false
      for (row <- 0 to (rows - 1) if break == false) {
        if (matrix(row)(0) == 0 ) break = true
      }
      break
    }

    // use first row for rows status
    for (row <- 1 to (rows-1)) {
      for (col <- 1 to (cols-1)) {
        if (matrix(row)(col) == 0) {
          setColumnToZero(col)
          setRowToZero(row)
        }
      }
    }

    def setColumnToZero(col: Int) {
      matrix(0)(col) = 0
    }

    def setRowToZero(row: Int) {
      matrix(row)(0) = 0
    }

    // set 0 for rows
    for(row <- 1 to (rows - 1)) {
      if (matrix(row)(0) == 0 ) {
        for (i <- 1 to (cols-1)) matrix(row)(i) = 0
      }
    }

    // set 0 for cols
    for(col <- 1 to (cols - 1)) {
      if (matrix(0)(col) == 0 ) {
        for (i <- 1 to (rows-1)) matrix(i)(col) = 0
      }
    }

    // set 1st row zero
    if (firstRowHasZero)
      for (col <- 0 to (cols-1)) matrix(0)(col) = 0

    // set 1st col to zero
    if (firstColHasZero)
      for (row <- 0 to (rows-1)) matrix(row)(0) = 0
  }


  val matrix1 = Array(
    Array(1, 1, 1),
    Array(1, 1, 1),
    Array(1, 1, 1),
  )

  val matrix2 = Array(
    Array(1, 1, 1),
    Array(1, 0, 1),
    Array(1, 1, 1),
  )

  setZeroes(matrix1)
  printMatrix(matrix1)

  setZeroes(matrix2)
  printMatrix(matrix2)
}
