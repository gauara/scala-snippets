package leetcode.hard.arrayandstrings

import scala.collection.mutable.Map

object Set454F4SumII extends App {

  def fourSumCount(A: Array[Int], B: Array[Int], C: Array[Int], D: Array[Int]): Int = {
   if (A.length == 0)
      return 0


    var m = Map.empty[Int, Int]

    for (i <- 0 to A.length-1) {
      for (j <- 0 to B.length-1) {
        val s = A(i) + B(j)
        val c = m.getOrElse(s, 0)
        m.+=(s -> (c+1))
      }
    }

    var count = 0
    for (i <- 0 to C.length-1) {
      for (j <- 0 to D.length-1) {
        val s = C(i) + D(j)
        count += m.getOrElse(-1*s, 0)
      }
    }
    println(s"Output: $count")
    count
  }

  fourSumCount(Array(1, 2), Array(-2,-1), Array(-1, 2), Array(0, 2))
}


