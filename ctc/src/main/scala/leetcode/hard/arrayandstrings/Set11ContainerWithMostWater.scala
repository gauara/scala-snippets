package leetcode.hard.arrayandstrings

//https://leetcode.com/problems/container-with-most-water

object Set11ContainerWithMostWater extends App {

  def maxArea(height: Array[Int]): Int = {

    var maxArea = Int.MinValue

    var left = 0
    var right = height.length-1

    while(left < right) {

      val width = right-left
      var area = Math.min(height(left), height(right)) *  width

      if (area > maxArea) {
        maxArea = area
      }

      if (height(left) < height(right))
        left += 1
      else
        right -= 1
    }

    println(s"Given Heights: ${height.mkString(",")}")
    println(s"Max Area: $maxArea")
    maxArea
  }

  maxArea(Array(3, 4, 4)) // 4
  maxArea(Array(1, 2)) // 1
  maxArea(Array(3, 1, 2, 4, 1)) //
  maxArea(Array(2,3,10,5,7,8,9))

}
