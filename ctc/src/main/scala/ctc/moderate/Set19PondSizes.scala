package ctc.moderate

import graphs.geeksfoegeeks.NumberOfIslands
import utils.MatrixUtils

import scala.collection.mutable.ArrayBuffer

// ACTUALLY WE ARE DOING ISLAND SIZES BUT ONE AND SAME THING -
// IDEA is to compute the connected component

object Set19PondSizes extends App {

  def computeSize(M: Array[Array[Int]], visited: Array[Array[Int]], row: Int, col: Int): Int = {
    // if out of edges OR
    // terminating OR
    // already visited
    // RETURN

    if(!NumberOfIslands.isSafe(M, row, col) || M(row)(col) == 0 || visited(row)(col) == 1) {
      return 0
    }

    visited(row)(col) = 1
    var size = 1
    for (r <- row-1 to row+1) {
      for (c <- col-1 to col+1) {
        size += computeSize(M, visited, r, c)
      }
    }
    size
  }

  def countIslandsAndSize(M: Array[Array[Int]]): (Int, ArrayBuffer[Int]) = {

    val visited = Array.ofDim[Int](M.length, M(0).length)
    val rows = M.length
    val cols = M(0).length
    var countOfIslands = 0

    val pondSizes = ArrayBuffer.empty[Int]

    for (r <- 0 to rows-1) {
      for (c <- 0 to cols-1) {
        if(M(r)(c) == 1 && visited(r)(c) != 1) {
          val size = computeSize(M, visited, r, c)
          countOfIslands += 1
          pondSizes.append(size)
        }
      }
    }
    (countOfIslands, pondSizes)
  }

  val matrix = Array(
    Array(1, 1, 0, 0),
    Array(0, 1, 0, 0),
    Array(1, 1, 0, 1),
    Array(0, 0, 0, 0),
    Array(0, 1, 1, 0),
    Array(0, 1, 1, 0)
  )
  val islandAndSizes = countIslandsAndSize(matrix)
  println("Given Matrix: ")
  MatrixUtils.printMatrix(matrix)
  println(s"Island and  Sizes : Islands -> ${islandAndSizes._1} Sizes -> ${islandAndSizes._2}")

}
