package leetcode.hard.treesandgraphs

// https://leetcode.com/problems/friend-circles/description/

object Set547FriendCircles extends App {

  def dfs(i: Int, visited: Array[Int], M: Array[Array[Int]]): Unit = {
    for (j <- 0 to M.length-1) {
      if (M(i)(j) == 1 && visited(j) == 0) {
        visited(j) = 1
        println(visited.mkString("=>"))
        dfs(j, visited, M)
      }
    }
  }

  def findCircleNum(M: Array[Array[Int]]): Int = {
    val visited: Array[Int] = Array.fill(M.length)(0)
    var count: Int = 0

    for (i <- 0 to M.length-1) {
      if (visited(i) == 0) {
        visited(i) = 1
        dfs(i, visited, M)
        count += 1
      }
    }
    println(s"Total friend circles: $count")
    count
  }

  val grid: Array[Array[Int]] =
    Array(
      Array(1, 1, 0),
      Array(1, 1, 0),
      Array(0, 0, 1)
    )

  findCircleNum(grid)

  val grid1: Array[Array[Int]] =
    Array(
      Array(1, 1, 0),
      Array(1, 1, 1),
      Array(0, 1, 1)
    )

  findCircleNum(grid1)

  val grid2: Array[Array[Int]] =
    Array(
      Array(1,0,0,1),
      Array(0,1,1,0),
      Array(0,1,1,1),
      Array(1,0,1,1),
    )

  findCircleNum(grid2)



  /*

  [[1,0,0,1],
  [0,1,1,0],
  [0,1,1,1],
  [1,0,1,1]]
   */


}
