package leetcode.hard.arrayandstrings

import scala.collection.mutable.ListBuffer

object Set239SlidingWindowMaximumUsingListBuffer extends App {

  def maxSlidingWindow(nums: Array[Int], k: Int): Array[Int] = {
    if (nums.isEmpty)
      return Array.empty[Int]

    if (nums.length < k)
      return Array.emptyIntArray

    val result: Array[Int] = new Array(nums.length - k + 1)
    var dq: ListBuffer[Int] = ListBuffer.empty

    for(i <- 0 to nums.length-1) {

      // Dequeue is not empty
      // since we are adding 1 element only head element can be out of window range possibly
      if (dq.nonEmpty && dq.head < i + 1 - k) {
        // SUPER Interesting - drop methods do not remove in-place
        // SUPER Interesting - REMOVE Is the method you need if you want to mutate original
        //dq = dq.drop(1)
        dq.remove(0) // remove the head element
      }

      // Dequeue is not empty
      // Drop all elements smaller than nums(i) to its left since those are useless
      while (dq.nonEmpty && nums(dq.last) < nums(i)) {
        // Need to do in-place
        //dq = dq.dropRight(1)
        dq.remove(dq.length-1)
      }

      // (1) Either dq is empty
      // (2) nums(i) is smaller than the tail end element - possibly we already removed smaller elements in above step
      // DO IN PLACE
      //dq = dq.:+(i)
      dq.append(i)

      // now for this ith value if we are past window size, add element for this window to result
      if (i >= k-1)
        result(i+1-k) = nums(dq.head)
    }
    println(s"The Maximum Sliding Window is: ${result.mkString(",")}")
    result
  }
  maxSlidingWindow(Array(1,3,-1,-3,5,3,6,7), 3)

  //maxSlidingWindow(Array(), 3)

  maxSlidingWindow(Array(1, -1), 1)

}
