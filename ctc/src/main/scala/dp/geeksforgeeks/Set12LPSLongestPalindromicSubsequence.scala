package dp.geeksforgeeks

import utils.MatrixUtils

object Set12LPSLongestPalindromicSubsequence extends App {

/*
  def longestPalindromicSubsequence(str: String): Int = {

    val T = Array.ofDim[Int](str.length, str.length)


    // since we will be using (i+1) so it should be set up before
    for (i <- 0 to str.length-1) T(i)(i) = 1

    for {
      i <- 0 to str.length-1
      j <- 0 to str.length-1
    } {
      if (j < i){
        // do nothing we are not filling the lower half from the diagonal
      } else if (j == i) {
        T(i)(j) = 1
      } else if (j - i == 1) {
        if (str(i) == str(j)) T(i)(j) = 2
        else T(i)(j) = 1
      } else {
        if (str(i) == str(j)) T(i)(j) = T(i+1)(j-1) + 2
        else {
          T(i)(j) = Math.max(
            T(i)(j-1),
            T(i+1)(j)
          )
        }
      }
    }
    println(s"The longest palindromic subsequence in string $str is of length = ${T(0)(str.length-1)}")
    MatrixUtils.printMatrix(T)
    T(0)(str.length-1)
  }
*/

  def longestPalindromicSubsequence(str: String): Int = {

    val T = Array.ofDim[Int](str.length, str.length)


    // since we will be using (i+1) so it should be set up before
    for (i <- 0 to str.length-1) T(i)(i) = 1

    for {
      l <- 2 to str.length
      i <- 0 until str.length-l+1
    } yield {
      val j = i+l-1
      if (str(i) == str(j) && l == 2)
        T(i)(j) = 2
      else if (str(i) == str(j))
        T(i)(j) = T(i+1)(j-1) + 2
      else
        T(i)(j) = Math.max(T(i)(j-1), T(i+1)(j))
    }
    println(s"The longest palindromic subsequence in string $str is of length = ${T(0)(str.length-1)}")
    MatrixUtils.printMatrix(T)
    T(0)(str.length-1)
  }

  longestPalindromicSubsequence("geeksforgeeks")
  longestPalindromicSubsequence("agbdba")
}
