package dp.geeksforgeeks

import utils.MatrixUtils

object Set13CuttinARod extends App {

  /*

  INCLUDE/EXCLUDE -- Infinite supply of pieces

   */
  def cutRod(price: Array[Int], l: Option[Int]): Int = {

    val L = l match {
      case Some(ln) => ln
      case _ => price.length
    }

    val T = Array.ofDim[Int](L+1, L+1)

    // base case first row
    for (j <- 0 to L) T(0)(j) = 0 // if we cant do anything max possible price is 0

    // base case first col
    for (i <- 0 to L) T(i)(0) = 0

    for {
      //i <- 1 to L
      i <- 1 to price.length // this covers the cases when given length is higher than number of possible pieces
      j <- 1 to L            // e.g rod length give 20 but possible pieces 1 to 8 size length
    } yield {

      if (j < i) T(i)(j) = T(i-1)(j)

      // only include and no left over
      if (j == i) {
        T(i)(j) = Math.max(
          price(i-1), // include
          T(i-1)(j) // exclude
        )
      }

      // max of either include or exclude
      if (j > i) {
        T(i)(j) = Math.max(
          price(i-1) + T(i)(j-i),
          T(i-1)(j)
        )
      }
    }

    println(s"The maximum profit by cutting $L length rod with given price is = ${T(price.length)(L)}")
    MatrixUtils.printMatrix(T)
    T(price.length)(L)
  }

  cutRod(Array(1, 5, 8, 9, 10, 17, 17, 20), None)
  cutRod(Array(2, 5, 9, 6), Some(5)) // given length is higher than array size
}
