package language

object MatrixTranspose extends App {

  var matrix = Array(
    Array(1, 2, 3),
    Array(4, 5, 6),
    Array(7, 8, 9)
  )


  def printMatrix(matrix: Array[Array[Int]]): Unit = {
    val rows = matrix.length
    val cols = matrix(0).length
    println("Rows : " + rows + " Cols: " + cols)
    for {
      row <- 0 to (rows-1) // equivalent =  0 to (rows-1) since until is [ ) vs to [ ]
      col <- 0 to (cols-1)
    } yield {
      print( " " + matrix(row)(col) + " ")
      if (col == cols-1) println()
    }
  }


  def transpose() = {
    println("before")
    printMatrix(matrix)

    for (i <- 0 to (matrix.length-1)) {
      for(j <- i to (matrix(0).length-1)) {
        println(s"  i : $i j : $j matrix(i)(j) : ${matrix(i)(j)}  matrix(j)(i): ${matrix(j)(i)}")
        val temp = matrix(i)(j)
        matrix(i)(j) = matrix(j)(i)
        matrix(j)(i) = temp
        println(s"  i : $i j : $j matrix(i)(j) : ${matrix(i)(j)}  matrix(j)(i): ${matrix(j)(i)}")
      }
    }
    println("after")
    printMatrix(matrix)
  }


  val N = matrix.length
  def swapRows(row: Int) {
    println("before")
    printMatrix(matrix)

    val row1 = row
    val row2 = N-1-row1 // IMP - note the subtract 1 from N since row starts with 0
    for (col <- 0 to (N-1)) {
      val temp = matrix(row1)(col)
      matrix(row1)(col) = matrix(row2)(col)
      matrix(row2)(col) = temp
    }

    println("after")
    printMatrix(matrix)
  }

  transpose()

//  for (row <- 0 to matrix.length/2 if row < matrix.length/2) {
//    swapRows(row)
//  }
}
