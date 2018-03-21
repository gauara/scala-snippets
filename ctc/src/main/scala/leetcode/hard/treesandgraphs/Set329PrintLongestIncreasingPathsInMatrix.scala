package leetcode.hard.treesandgraphs

import utils.MatrixUtils

object Set329PrintLongestIncreasingPathsInMatrix extends App {


  def lipInMatrixPrintPaths(matrix: Array[Array[Int]], dp: Array[Array[Int]], r: Int, c: Int, max: Int): Int = {
    if (!MatrixUtils.isSafe(matrix, r, c))
      return max

    if(dp(r)(c) > 1 ) return dp(r)(c)

    // top
    val res1 = if(MatrixUtils.isSafe(matrix, r-1, c) && matrix(r-1)(c) > matrix(r)(c)) {
      1 + lipInMatrixPrintPaths(matrix, dp, r-1, c, max)
    }  else {
      1
    }

    // bottom
    val res2 = if(MatrixUtils.isSafe(matrix, r+1, c) && matrix(r+1)(c) > matrix(r)(c)) {
      1 + lipInMatrixPrintPaths(matrix, dp, r+1, c, max)
    }  else {
      1
    }

    // right
    val res3 = if(MatrixUtils.isSafe(matrix, r, c+1) && matrix(r)(c+1) > matrix(r)(c)) {
      1 + lipInMatrixPrintPaths(matrix, dp, r, c+1, max)
    }  else {
      1
    }

    // left
    val res4 = if(MatrixUtils.isSafe(matrix, r, c-1) && matrix(r)(c-1) > matrix(r)(c)) {
      1 + lipInMatrixPrintPaths(matrix, dp, r, c-1, max)
    }  else {
      1
    }

    val res = Math.max(
      Math.max(res1, res2),
      Math.max(res3, res4)
    )
    val ans = Math.max(max, res)
    dp(r)(c) = ans
    ans
  }


  def lipUtil(): Int = {
    /*
        val matrix = Array(
          Array(9, 9, 4),
          Array(6, 6, 8),
          Array(2, 1, 1)
        )
    */

    /*
        val matrix = Array(
          Array(1, 2, 3),
          Array(6, 6, 4),
          Array(2, 1, 5)
        )
    */

    val matrix = Array(
      Array(1, 2, 3, 4),
      Array(3, 5, 6, 5),
      Array(3, 5, 6, 6),
      Array(3, 5, 6, 8)
    )
    /*
        val dp = Array(
          Array(1, 1, 1),
          Array(1, 1, 1),
          Array(1, 1, 1)
        )
    */

    // just use array.fill
    val dp = Array(
      Array(1, 1, 1, 1),
      Array(1, 1, 1, 1),
      Array(1, 1, 1, 1),
      Array(1, 1, 1, 1)
    )

    var max = 1

    for(i <- 0 to matrix.length-1) {
      for (j <- 0 to matrix(0).length-1) {
        max = Math.max((lipInMatrixPrintPaths(matrix, dp, i, j, 1)), max)
      }
    }

    //println(s"The LIP for matrix is : ${lipInMatrix(matrix, dp, 0, 0, 1)}")
    println(s"The LIP for matrix is : $max")
    max
  }

  lipUtil
}
