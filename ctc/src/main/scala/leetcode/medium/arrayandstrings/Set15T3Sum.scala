package leetcode.medium.arrayandstrings

import scala.collection.mutable
import scala.collection.mutable.ListBuffer


/*
https://leetcode.com/problems/3sum/description/

Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]

Array(-4, -1, -1, 0, 1, 2)



 */

object Set15T3Sum extends App {

  def threeSum(nums: Array[Int]): List[List[Int]] = {

    val arr = nums.sorted
    var result = mutable.ListBuffer.empty[List[Int]]

    for (i <- 0 to arr.length-3) {
      var low = i + 1
      var high = arr.length - 1
      //var sum = 0 - (nums(low) + nums(high))
      var sum = 0 - nums(i)
      while (low < high) {
        if (arr(low) + arr(high) == sum) {
          result.append(List(arr(i), arr(low), arr(high)))
          while (low < high && arr(low) == arr(low+1)) low += 1
          while (low < high && arr(high) == arr(high-1)) high -= 1
        }
        low += 1
        high -= 1
      }
    }
    for (elem <- result) {println(elem.mkString(","))}
    result.toList
  }

  //threeSum(Array(-4, -1, -1, 0, 1, 2))
  //threeSum(Array(-1, 1, 0, 0, 1, 1, 1, -1, -1, -1))
}
