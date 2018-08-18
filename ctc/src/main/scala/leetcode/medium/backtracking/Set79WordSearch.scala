package leetcode.medium.backtracking

import scala.collection.mutable

// https://leetcode.com/problems/word-search/description/

object Set79WordSearch extends App {

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

  def dfs(board: Array[Array[Char]], row: Int, col: Int, prefix: String, visited: mutable.Set[(Int, Int)], word: String, idx: Int): Boolean = {
    // if out of border return false
    // visited metrics board
    // if prefix matches the word return true
    // check for prefix ++ horizontal next -- vertical necxt
    //if (row < 0 || row >= board.length || col < 0 || col >= board(0).length) return false

    println(s"Prefix so far: $prefix row: $row col: $col")

    if (!isSafe(board, row, col)) return false

    if (visited.contains(row,col)) return false
    if (idx >= word.length) return false
    if (word(idx) != board(row)(col)) return false

    if (prefix + board(row)(col) == word) return true

    val v = visited.clone()
    v.+=((row, col))
    // check for neighbours recursively
    dfs(board, row+1, col, prefix + board(row)(col), v, word, idx+1) ||
      dfs(board, row-1, col, prefix + board(row)(col), v, word, idx+1) ||
      dfs(board, row, col-1, prefix + board(row)(col), v, word, idx+1) ||
      dfs(board, row, col+1, prefix + board(row)(col), v, word, idx+1)
  }

  def exist(board: Array[Array[Char]], word: String): Boolean = {
    for (i <- 0 to board.length-1) {
      for (j <- 0 to board(0).length-1) {
        if (board(i)(j) == word(0)) {
          //val visited = Array.tabulate(board.length, board(0).length)((x,y) => false)
          if (dfs(board, i, j, "", mutable.Set.empty[(Int, Int)], word, 0)) {
            println(s"Word: $word found in the board")
            return true
          }
        }
      }
    }
    println(s"Word: $word NOT found")
    false
  }


  val board = Array(
    Array('A','B','C','E'),
    Array('S','F','C','S'),
    Array('A','D','E','E')
  )

  exist(board, "ABCCED")
  exist(board, "SEE")
  exist(board, "ABCB")
  exist(board, "AX")

}
