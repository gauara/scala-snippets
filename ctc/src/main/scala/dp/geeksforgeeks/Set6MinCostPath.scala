package dp.geeksforgeeks

import utils.MatrixUtils

object Set6MinCostPath extends App {

  def minCostPath(T: Array[Array[Int]], row: Int, col: Int): Int = {
    val  rows = T.length
    val cols = T(0).length

    // populate first col
    for(i <- 1 to rows-1)
      T(i)(0) = T(i-1)(0) + T(i)(0)

    // populate first row
    for(j <- 1 to cols-1)
      T(0)(j) = T(0)(j-1) + T(0)(j)

    // do the min cost for the rest of the rows and cols

    for {
      i <- 1 to rows-1
      j <- 1 to cols-1
    } yield {
      T(i)(j) = T(i)(j) + Math.min(
        Math.min(
        T(i)(j-1),
        T(i-1)(j)
      ),
        T(i-1)(j-1)
      )
    }

    println(s"The min cost to reach row $row and col $col is = ${T(row)(col)}" )
    T(row)(col)
  }



  minCostPath(Array(
    Array(1, 2, 3),
    Array(4, 8, 2),
    Array(1, 5, 3),
  ), 2, 2)

  minCostPath(Array(
    Array(1, 2, 3),
    Array(4, 8, 2),
    Array(1, 5, 3),
  ), 1, 1)

  minCostPath(Array(
    Array(1, 2, 3),
    Array(4, 8, 2),
    Array(1, 5, 3),
  ), 1, 2)

  minCostPath(Array(
    Array(1, 2, 3),
    Array(4, 8, 2),
    Array(1, 5, 3),
  ), 2, 1)



}
