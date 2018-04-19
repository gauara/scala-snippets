package leetcode.hard.arrayandstrings

import scala.collection.mutable
import scala.collection.mutable.Map

// https://leetcode.com/problems/longest-consecutive-sequence/description/

object Set128LongestConsecutiveSequence extends App {
/*
[100, 4, 200, 1, 3, 2]
 [1, 2, 3, 4]

 */

  def longestConsecutiveOpt1(nums: Array[Int]): Int = {
    if (nums.length <= 1)
      return nums.length

    var m = mutable.Map.empty[Int, Int]
    var maxLength = Int.MinValue

    for (i <- 0 to nums.length-1) {
      if (!m.contains(nums(i))) {
        val pre = m.getOrElse(nums(i)-1, 0)
        val post = m.getOrElse(nums(i)+1, 0)

        val delta = pre + post + 1
        if (delta > maxLength)
          maxLength = delta

        val from = nums(i) - pre
        val to = nums(i) + post

        for (j <- from to to) {
          m.put(j, delta)
        }
      }
    }
    println(s"Max consecutive length is: $maxLength")
    maxLength
  }


  def longestConsecutive(nums: Array[Int]): Int = {
    if (nums.length <= 1)
      return nums.length

    var m = mutable.Map.empty[Int, Int]
    var maxLength = Int.MinValue

    for (i <- 0 to nums.length-1) {
      if (!m.contains(nums(i))) {
        val pre = m.getOrElse(nums(i)-1, 0)
        val post = m.getOrElse(nums(i)+1, 0)

        val delta = pre + post + 1
        if (delta > maxLength)
          maxLength = delta

        val from = nums(i) - pre // boundaries
        val to = nums(i) + post

        if (pre > 0) m.put(from, delta) // if left boundary existed
        if (post > 0) m.put(to, delta) // if right boundary existed
        m.put(nums(i), delta)
      }
    }
    println(s"Max consecutive length is: $maxLength")
    maxLength
  }


  longestConsecutiveOpt1(Array(100, 4, 200, 1, 3, 2))
  longestConsecutiveOpt1(Array(-5, -4, -3, -2, -1, 0, 1, 5))
  longestConsecutiveOpt1(Array(1, 2, 0, 1))

  longestConsecutive(Array(100, 4, 200, 1, 3, 2))
  longestConsecutive(Array(-5, -4, -3, -2, -1, 0, 1, 5))
  longestConsecutive(Array(1, 2, 0, 1))

}
