package leetcode.hard.backtracking

import utils.MatrixUtils

import scala.collection.mutable.ArrayBuffer

object Set212WordSearchII extends App {

  /*


  DOES NOT WORK



  def wordSearch(matrix: Array[Array[Char]], words: Array[String]): List[String] = {
    val rows = matrix.length
    val cols = matrix(0).length
    var list: List[String] = List.empty[String]

    for(i <- 0 to words.length-1) {
      val word = words(i)
      searchWord(word)
    }

    def searchWord(word: String) = {
      var loop = true
      for(r <- 0 to rows-1) {
        for (c <- 0 to cols-1) {
          if (matrix(r)(c) == word.charAt(0) && loop) {
            val found = dfs(matrix, r, c, -1, -1, 0, word)
            println("-----------------------")
            println(s"Word: $word Found ? : $found")
            println("-----------------------")
            if (found) {
              list = list :+ word
              loop = false
            } else {
              println("-----------------------")
              println(s"Word:  $word NOT FOUND")
              println("-----------------------")
            }
          }
        }
      }
    }
    list
  }

  def isSafe(matrix: Array[Array[Char]], r: Int, c: Int, pr:Int, pc: Int): Boolean = {
    val rows = matrix.length
    val cols = matrix(0).length

    //println(s"****** IsSafe row: $r and col: $c")
    if (r >= 0 && r < rows && c >=0 && c < cols && !(pr == r && pc == c)) true
    //if (r >= 0 && r < rows && c >=0 && c < cols ) true
    else false
  }

  def dfs(matrix: Array[Array[Char]], row: Int, col: Int, prevRow: Int, prevCol: Int, index: Int, str: String): Boolean = {

    //println(s"Index: ${index} char: ${matrix(row)(col)} row: $row col: $col str length: ${str.length}")


    if(index > str.length -1 || matrix(row)(col) != str(index)) return false

    //if(index == str.length-1 && matrix(row)(col) == str(index)) return true
    if(index == str.length) return true

    println(s"Index: ${index} char: ${matrix(row)(col)} row: $row col: $col str length: ${str.length}")


    //println(s"Index: ${index} char: ${matrix(row)(col)} row: $row col: $col")
    for (r <- row-1 to row+1) {
      for (c <- col-1 to col+1) {
        if (isSafe(matrix, r, c, row, col)) {
          val result = dfs(matrix, r, c, row, col, index+1, str)
        }
      }
    }

  }

  val grid = Array(
    Array('o','a','a','n'),
    Array('e','t','a','e'),
    Array('i','h','k','r'),
    Array('i','f','l','v')
  )

  val words = Array("oath","pea","eat","rain", "kite")

  //val words = Array("oath")
  println(wordSearch(grid, words))
*/



  def wordSearchII(words: List[String], matrix: Array[Array[Char]]): ArrayBuffer[String] = {
    var cache: ArrayBuffer[String] = ArrayBuffer.empty

    val rows:Int = matrix.length
    val cols:Int = matrix(0).length

    words.foreach( w => {

      for(i <- 0 to rows-1) {
        for (j <- 0 to cols-1) {

          if (matrix(i)(j) == w(0) && !cache.contains(w)) {
            println(s"Outer i: $i j: $j")
            val visited = Array.tabulate[Boolean](rows, cols)((x,y) => false)
            val result = dfs(matrix, visited, w, 0, i, j, cache)
            if (result) {
              println("was here")
            } else {
              println("ERRRR why I am here")
            }
          }
        }
      }
    })

    if (cache.size > 0) {
      println("Following words were found")
      cache.foreach(println)
    } else {
      println(" No words found")
    }
    cache
  }

  def dfs(matrix: Array[Array[Char]], visited: Array[Array[Boolean]], str: String, index: Int, r: Int, c: Int, cache: ArrayBuffer[String]): Boolean = {



    if (index == 0) {
      println(str)
      //MatrixUtils.printMatrix(visited)
    }


    if (index == str.length-1 && str(index) == matrix(r)(c)) {
      cache.append(str)
      println(s"Found word : $str")
      return true
    }


    if (!MatrixUtils.isSafe(matrix, r, c))
      return false

    if (visited(r)(c) == true)
      return false

    if (matrix(r)(c) != str(index))
      return false

    visited(r)(c) = true

    println(s"Index: $index r: $r, c: $c, str(index) : ${str(index)} matrix(r)(c): ${matrix(r)(c)}")

    var result = false

    /*

    THIS CODE IS BUGGY BECAUSE WE ARE CONTINUING THE DFS FOR ALL CASES
    IT SHOULD BE AN LOGICAL OR OF ALL POSSIBLE RECURSIVE CALLS

     */

    for (r1 <- r-1 to r+1) {
      for (c1 <- c-1 to c+1) {
        if (MatrixUtils.isSafe(matrix, r1, c1)) {
          result = dfs(matrix, visited, str, index+1, r1, c1, cache)
        }
      }
    }

    result
  }



  val matrix = Array(
    Array('o','a','a','n'),
    Array('e','t','a','e'),
    Array('i','h','k','r'),
    Array('i','f','l','v')
  )

  val words = List("oath","pea","eat","rain", "kite")
  //val words = List("eat")

  println(wordSearchII(words, matrix))

}
