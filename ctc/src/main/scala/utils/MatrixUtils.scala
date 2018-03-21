package utils

object MatrixUtils {
  def printMatrix(matrix: Array[Array[Int]]): Unit = {
    val rows = matrix.length
    val cols = matrix(0).length

    println(" Rows: " + rows + " Cols: " + cols)

    for {
      row <- 0 to (rows-1) // equivalent =  0 to (rows-1) since until is [ ) vs to [ ]
      col <- 0 to (cols-1)
    } yield {
      print( " " + matrix(row)(col) + " ")
      if (col == cols-1) println()
    }
  }


  def printMatrix(matrix: Array[Array[Boolean]]): Unit = {
    val rows = matrix.length
    val cols = matrix(0).length

    println(" Rows: " + rows + " Cols: " + cols)

    for {
      row <- 0 to (rows-1) // equivalent =  0 to (rows-1) since until is [ ) vs to [ ]
      col <- 0 to (cols-1)
    } yield {
      print( " " + matrix(row)(col) + " ")
      if (col == cols-1) println()
    }
  }




  def isSafe(M: Array[Array[Int]], row: Int, col: Int): Boolean = {
    val rows =  M.length
    val cols = M(0).length

    if ((row >= 0 && row < rows) &&
      (col >= 0 && col < cols)
    ) {
      true
    } else {
      false
    }
  }


  def isSafe(M: Array[Array[Char]], row: Int, col: Int): Boolean = {
    val rows =  M.length
    val cols = M(0).length

    if ((row >= 0 && row < rows) &&
      (col >= 0 && col < cols)
    ) {
      true
    } else {
      false
    }
  }
}
