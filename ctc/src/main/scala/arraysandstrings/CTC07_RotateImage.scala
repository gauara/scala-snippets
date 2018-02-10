package arraysandstrings

object CTC07_RotateImage extends App {

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

  def rotate(matrix: Array[Array[Int]]): Unit = {
    // technique is:
    // 1. first check out the result and see if its a clear realtion to get the result relative to original matric
    // 2. If not obvious translation and find the matrix which is tranpose of RESULT matric and see if this intermediatory
    // .  matrix is easy to obtain from the original matrix

    // For this problem - swap the first and last row and so on and take transpose
    // first swap / reverse step is basically reversing the columns 0 through N, we can implement it various ways


    println("original matrix")
    printMatrix(matrix)

    // reverse the columns
    val N = matrix.length // gives number of rows , or columns for a square matrix

    // IMP - note the if guard
    for (row <- 0 to N/2 if row < N/2) {
      swapRows(row)
    }

    // good example of fact that arrays are passed by reference in scala
    def swapRows(row: Int) {
      println()
      println("In Swap")
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

    // now take the transpose of the matrix
    def transpose() = {
      println()
      println("In Transpose")
      println("before")
      printMatrix(matrix)

      for (i <- 0 to (N-1)) {
        for(j <- i to (N-1)) { // NOTE THAT it starts with i
          //println(s"  i : $i j : $j matrix(i)(j) : ${matrix(i)(j)}  matrix(j)(i): ${matrix(j)(i)}")
          val temp = matrix(i)(j)
          matrix(i)(j) = matrix(j)(i)
          matrix(j)(i) = temp
          //println(s"  i : $i j : $j matrix(i)(j) : ${matrix(i)(j)}  matrix(j)(i): ${matrix(j)(i)}")
        }
      }
      println("before")
      printMatrix(matrix)
    }

    transpose()
  }

  val matrix = Array(
    Array(1, 2, 3),
    Array(4, 5, 6),
    Array(7, 8, 9),
  )
  rotate(matrix)
}
