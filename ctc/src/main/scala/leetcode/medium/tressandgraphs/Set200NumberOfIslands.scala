package leetcode.medium.tressandgraphs

// https://leetcode.com/problems/number-of-islands/description/

object Set200NumberOfIslands extends App {


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

  def markVisited(M: Array[Array[Char]], visited: Array[Array[Int]], row: Int, col: Int): Unit = {
    // if out of edges OR
    // terminating OR
    // already visited
    // RETURN

    if(!isSafe(M, row, col) || M(row)(col) == '0' || visited(row)(col) == 1) {
      return
    }

    visited(row)(col) = 1

    // ONLY 4 directions
    markVisited(M, visited, row-1, col) // top
    markVisited(M, visited, row+1, col) // bottom
    markVisited(M, visited, row, col-1) // left
    markVisited(M, visited, row, col+1) // right

  }

  def numIslands(grid: Array[Array[Char]]): Int = {
    val visited = Array.ofDim[Int](grid.length, grid(0).length)
    val rows = grid.length
    val cols = grid(0).length
    var countOfIslands = 0

    for (r <- 0 to rows-1) {
      for (c <- 0 to cols-1) {
        if(grid(r)(c) == '1' && visited(r)(c) != 1) {
          markVisited(grid, visited, r, c)
          countOfIslands += 1
        }
      }
    }
    countOfIslands
  }

  val m1 = Array(
    Array('1', '1', '0', '0'),
    Array('0', '1', '0', '0'),
    Array('1', '1', '0', '1'),
    Array('0', '0', '0', '0'),
    Array('0', '1', '1', '0'),
    Array('0', '1', '1', '0')
  )
  println(numIslands(m1))

  val m2 = Array(
    Array('1', '1', '1', '1', '0'),
    Array('1', '1', '0', '1', '0'),
    Array('1', '1', '0', '0', '0'),
    Array('0', '0', '0', '0', '0')
  )
  println(numIslands(m2))


  val m3 = Array(
    Array('1', '1', '0', '0', '0'),
    Array('1', '1', '0', '0', '0'),
    Array('0', '0', '1', '0', '0'),
    Array('0', '0', '0', '1', '1')
  )
  println(numIslands(m3))


}
