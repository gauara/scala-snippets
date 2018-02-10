package dp.geeksforgeeks


object Set4LCSLongestCommonSubsequence extends App {

  def lcsDP(str1: String, str2: String): Int = {

    val row = str1.length - 1
    val col = str2.length - 1

    val M: Array[Array[Int]] = Array.ofDim(row + 1 , col + 1) // NOTE THE Row/Col here

    for {
      i <- 0 to row
      j <- 0 to col // NOTE that its not col - 1 or row - 1
    } yield {

      if (i == 0 || j == 0)
        M(i)(j) = 0
      else if(str1(i) == str2(j))
        M(i)(j) = 1 + M(i-1)(j-1)
      else
        M(i)(j) = Math.max(M(i-1)(j), M(i)(j-1))
    }

    M(row)(col)

  }

  println(lcsDP("GXTXAYB", "AGGTAB"))
  println(lcsDP("gaurav", "grace"))
  println(lcsDP("gaurav", "priyanka"))
  println(lcsDP("grace", "priyanka"))
}
