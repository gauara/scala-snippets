package leetcode.medium.sortingandsearching

object Set240SearchA2DMatricII extends App {

  def searchMatrix(matrix: Array[Array[Int]], target: Int): Boolean = {
    val rows = matrix.length
    val cols = matrix(0).length-1

    var i = matrix(0)(cols-1) // top right element

    var row = 0
    var col = cols-1

    var loop = true
    while (loop) {
      if (row < 0 || row >= rows || col < 0 || col >= cols)
        return false

      if (matrix(row)(col) == target)
        return true

      if (matrix(row)(col) < target)
        row += 1
      else
        col -= 1
    }
    false
  }


  val matrix = Array(
    Array(1,   4,  7, 11, 15),
    Array(2,   5,  8, 12, 19),
    Array(3,   6,  9, 16, 22),
    Array(10, 13, 14, 17, 24),
    Array(8, 21, 23, 26, 30)
  )

  println(searchMatrix(matrix, 5))
  println(searchMatrix(matrix, 20))
}
