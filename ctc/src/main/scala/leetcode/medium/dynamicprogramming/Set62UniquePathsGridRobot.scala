package leetcode.medium.dynamicprogramming

object Set62UniquePathsGridRobot extends App {
  def isSafe(rows1: Int, cols1: Int, row: Int, col: Int): Boolean = {
    val rows =  rows1
    val cols = cols1

    if ((row >= 0 && row < rows) &&
      (col >= 0 && col < cols)
    ) {
      true
    } else {
      false
    }
  }

  def paths(rows: Int, cols: Int, row: Int, col: Int, dp: Array[Array[Int]]): Int = {
    if (!isSafe(rows, cols, row, col))
      return 0

    if (row == rows-1 && col == cols-1)
      return 1

    if (dp(row)(col) != -1) {
      dp(row)(col)
    } else {
      val rPaths = paths(rows, cols, row, col+1, dp)
      val dPaths = paths(rows, cols, row+1, col, dp)
      dp(row)(col) = rPaths + dPaths
      dp(row)(col)
    }
  }

  def uniquePaths(m: Int, n: Int): Int = {
    if (m == 1)
      return 1

    val dp: Array[Array[Int]] = Array.tabulate[Int](m, n)((x,y) => -1)
    val res = paths(m, n, 0, 0, dp)
    //println(s"Unique paths for m: $m and n: $n == $res")
    res
  }

}
