package leetcode.hard.arrayandstrings

// Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.


//https://leetcode.com/problems/sliding-window-maximum/description

object Set239SlidingWindowMaximum extends App {
  // use a Deque - store indexes in it, the elements are in non-increasing order
  // while inserting a new element remove all other smaller than this since those would be useless

  def maxSlidingWindow(nums: Array[Int], k: Int): Array[Int] = {
    if (nums.isEmpty)
      return Array.empty[Int]

    if (nums.length < k)
      return Array.emptyIntArray

    val result: Array[Int] = new Array(nums.length - k + 1)
    var dq: List[Int] = List.empty

    for(i <- 0 to nums.length-1) {

      // Dequeue is not empty
      // since we are adding 1 element only head element can be out of window range possibly
      if (dq.nonEmpty && dq.head < i + 1 - k) {
        dq = dq.drop(1)
      }

      // Dequeue is not empty
      // Drop all elements smaller than nums(i) to its left since those are useless
      while (dq.nonEmpty && nums(dq.last) < nums(i)) {
        dq = dq.dropRight(1)
      }

      // (1) Either dq is empty
      // (2) nums(i) is smaller than the tail end element - possibly we already removed smaller elements in above step
      dq = dq.:+(i)

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
