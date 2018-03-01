package graphs.geeksfoegeeks

import utils.MatrixUtils

//https://www.geeksforgeeks.org/find-number-of-islands/

object NumberOfIslands extends App {

  // Matrix and starting row and col to check connected component starting at M[row][col]

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

  def markVisited(M: Array[Array[Int]], visited: Array[Array[Int]], row: Int, col: Int): Unit = {
    // if out of edges OR
    // terminating OR
    // already visited
    // RETURN

    if(!isSafe(M, row, col) || M(row)(col) == 0 || visited(row)(col) == 1) {
      return
    }

    visited(row)(col) = 1

    for (r <- row-1 to row+1) {
      for (c <- col-1 to col+1) {
        markVisited(M, visited, r, c)
      }
    }
  }


  var matrix = Array(
    Array(1, 1, 0, 0),
    Array(0, 1, 0, 0),
    Array(1, 1, 0, 0),
    Array(1, 0, 0, 0),
    Array(0, 0, 0, 0)
  )

  var visited = Array.ofDim[Int](5, 4)

  MatrixUtils.printMatrix(visited)
  println(markVisited(matrix, visited, 0, 0))
  MatrixUtils.printMatrix(visited)


  var matrix1 = Array(
    Array(1, 1, 0, 0),
    Array(0, 1, 0, 0),
    Array(1, 1, 0, 0),
    Array(1, 0, 0, 0),
    Array(0, 1, 1, 0),
    Array(0, 1, 1, 0)
  )

  var visited1 = Array.ofDim[Int](matrix1.length, matrix1(0).length)

  MatrixUtils.printMatrix(visited1)
  println(markVisited(matrix1, visited1, 0, 0))
  MatrixUtils.printMatrix(visited1)




  // NOW pass a matric and check connected graphs

  def countIslands(M: Array[Array[Int]]): Int = {

    val visited = Array.ofDim[Int](M.length, M(0).length)
    val rows = M.length
    val cols = M(0).length
    var countOfIslands = 0

    for (r <- 0 to rows-1) {
      for (c <- 0 to cols-1) {
        if(M(r)(c) == 1 && visited(r)(c) != 1) {
          markVisited(M, visited, r, c)
          countOfIslands += 1
        }
      }
    }
    countOfIslands
  }

  val m = Array(
    Array(1, 1, 0, 0),
    Array(0, 1, 0, 0),
    Array(1, 1, 0, 0),
    Array(1, 0, 0, 0),
    Array(0, 1, 1, 0),
    Array(0, 1, 1, 0)
  )
  val islands = countIslands(m)
  println("Given Matrix: ")
  MatrixUtils.printMatrix(m)
  println(s"NUmber of Islands : $islands")

  val m1 = Array(
    Array(1, 1, 0, 0),
    Array(0, 1, 0, 0),
    Array(1, 1, 0, 1),
    Array(0, 0, 0, 0),
    Array(0, 1, 1, 0),
    Array(0, 1, 1, 0)
  )
  val islands1 = countIslands(m1)
  println("Given Matrix: ")
  MatrixUtils.printMatrix(m1)
  println(s"NUmber of Islands : $islands1")

}
