package leetcode.hard.arrayandstrings

object Set11ContainerWithMostWater extends App {

  def maxArea(height: Array[Int]): Int = {
    val right: Array[Int] = new Array[Int](height.length)
    val left: Array[Int] = new Array[Int](height.length)

    // fill right array

    right(right.length-1) = height(height.length-1)
    left(0) = height(0)

    for (i <- right.length-2 to 0 by -1) {
      right(i) = Math.max(right(i+1), height(i+1))
    }
    for (i <- 1 to left.length-1) {
      left(i) = Math.max(left(i-1), height(i-1))
    }

    var total = 0
    for(i <- 1 to height.length-1) {
      total += Math.min(right(i), left(i))
    }
    println(s"Right: {${right.mkString(",")}}")
    println(s"Left: {${left.mkString(",")}}")
    println(s"Total: $total")
    total
  }
  maxArea(Array(3, 4, 4))
  maxArea(Array(1, 2))
  maxArea(Array(3, 1, 2, 4, 1))
  maxArea(Array(2,3,10,5,7,8,9))

}
