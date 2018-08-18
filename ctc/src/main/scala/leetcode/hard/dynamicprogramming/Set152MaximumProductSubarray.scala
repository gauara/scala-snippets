package leetcode.hard.dynamicprogramming

object Set152MaximumProductSubarray extends App {
  def maxProduct(nums: Array[Int]): Int = {
    var max = Int.MinValue
    var pre: Int = 1

    // We do not need to cache the results in 2d matrix, current result depends only on just prev result
    for (i <- 0 to nums.length-1) {
      for (j <- i to nums.length-1) {
        if (j == i) {
          pre = nums(j)
          max = Math.max(max, pre )
        } else {
          max = Math.max(max, pre * nums(j))
          pre = pre * nums(j)
        }
      }
    }
    //println(s"Max for the array ${nums.mkString(",")} is::: $max")
    max
  }


  def maxProductOpt1(nums: Array[Int]): Int = {
    var minSoFar: Int = nums(0)
    var maxSoFar: Int  = nums(0)
    var max = nums(0)
    var temp = nums(0)

    for (i <- 1 to nums.length-1) {
      temp = maxSoFar
      maxSoFar = Math.max(Math.max(nums(i)*minSoFar, nums(i)*maxSoFar), nums(i))
      minSoFar = Math.min(Math.min(nums(i)*temp, nums(i)*minSoFar), nums(i))

      max = Math.max(max, maxSoFar)
    }
    max
  }
}
