package leetcode.medium.arrayandstrings

// https://leetcode.com/problems/set-matrix-zeroes/description/

object Set73SetMatrixZeroes {
  def setZeroes(matrix: Array[Array[Int]]): Unit = {
    val rows = matrix.length
    val cols = matrix(0).length

    // this can not be def - since matrix is gonna change
    val firstRowHasZero = {
      matrix(0).map(_ == 0).find(_ == true).getOrElse(false)
    }

    // this can not be def - since matrix is gonna change
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

}
