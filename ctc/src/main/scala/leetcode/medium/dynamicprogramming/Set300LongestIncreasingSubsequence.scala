package leetcode.medium.dynamicprogramming

// https://leetcode.com/problems/longest-increasing-subsequence/description/

object Set300LongestIncreasingSubsequence extends App {

  def lengthOfLIS(nums: Array[Int]): Int = {

    if (nums.length < 2) return nums.length
    val lis: Array[Int] = Array.fill(nums.length)(1)

    for (i <- 1 to nums.length-1) {
      for (j <- 0 to i) {
        if (nums(i) > nums(j) &&
          lis(j) + 1 > lis(i))
            lis(i) += 1
      }
    }
    println(s"The LIS for array: ${nums.mkString(",")} IS ${lis.max}")
    lis.max
  }

  lengthOfLIS(Array(10,9,2,5,3,7,101,18))

}
