package dp.geeksforgeeks

import utils.MatrixUtils

object Set10ZeroOneKnapsack extends App {


  /*

   Rows: 6 Cols: 10

       0 1 2 3  4  5  6  7  8  9  10 ( Total Capacity )

       0  0  0  0  0  0  0  0  0  0  // base row
wts(i) 0  1  1  1  1  1  1  1  1  1
       0  0  0  4  5  5  5  5  5  5
       0  0  0  0  5  5  5  9  10  10
       0  0  0  0  0  7  7  9  10  12
       0  0  4  4  4  7  7  11  11  13

  Array(1, 3, 4, 5, 2), Array(1, 4, 5, 7, 4), 9)

  wts() -> values()
  1 => 1
  3 => 4
  4 => 5
  5 => 7
  2 => 4


   */

  def zeroOneKnapsack(wts: Array[Int], values: Array[Int], W: Int): Int = {

    // base case

    // Cols - given weight to form / capacity
    // Rows - given items with weight and values

    // base case

    // fill row with zeroes

    val T = Array.ofDim[Int](wts.length+1, W+1)

    // first col
    for (j <- 0 to W) T(0)(j) = 0

    // first row
    for (i <- 0 to wts.length) T(i)(0) = 0

    // NO Special handling for T(0)(0)

    for {
      i <- 1 to wts.length
      j <- 1 to W
    } yield {

      // include and exclude case for all scenarios

      if (j < wts(i-1)) { // starting with i = 1 helps with this array out of bound cases
        T(i)(j) = 0
      }

      if (j == wts(i-1)) {
        // Max(include, exclude case)
        T(i)(j) = Math.max(
          values(i-1), // included - nothing else left to include as j == i
          T(i-1)(j) // if its excluded
        )
      }

      if (j > wts(i-1)) {
        // Max(include, exclude case)
        // IMPORTANT NOTE -- see (i-1) because there is NO INFINITE Supply of ITEMS
        T(i)(j) = Math.max(
          values(i-1) + T(i-1)(j - wts(i-1)), // included - nothing else left to include as j == i
          T(i-1)(j) // if its excluded
        )
      }
    }
    println(s"The maximum values achieved by using given weights and capacity = $W is = ${T(wts.length)(W)}")
    MatrixUtils.printMatrix(T)
    T(wts.length)(W)
  }


  zeroOneKnapsack(Array(10, 20, 30), Array(60, 100, 120), 50)
  zeroOneKnapsack(Array(1, 3, 4, 5, 2), Array(1, 4, 5, 7, 4), 9)


}
