package dp.geeksforgeeks

import utils.MatrixUtils

object Set9BinomialCofficient extends App {

  def binomialCofficient(n: Int, k: Int): Int = {

    val T: Array[Array[Int]] = Array.ofDim[Int](k+1, n+1)

    // set first column =
    for (i <- 0 to k) T(i)(0) = 0

    // set first row
    for (j <- 0 to n) T(0)(j) = 1

    // NOTE THAT settings columns and then row because T(0)(0) = 1

    for {
      i <- 1 to k
      j <- 1 to n
    } yield {
      T(i)(j) = T(i)(j-1) + T(i-1)(j-1)
    }

    println(s"The coefficient for n = $n and k = $k is ${T(k)(n)}")
    MatrixUtils.printMatrix(T)
    T(k)(n)
  }

  binomialCofficient(5, 2)
  binomialCofficient(5, 3)
  binomialCofficient(4, 2)
  binomialCofficient(3, 1)

}
