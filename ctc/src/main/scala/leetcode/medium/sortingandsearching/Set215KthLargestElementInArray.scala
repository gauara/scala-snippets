package leetcode.medium.sortingandsearching

import scala.collection.mutable

object Set215KthLargestElementInArray extends App {


  def findKthLargest(nums: Array[Int], k: Int): Int = {

    var maxHeap: mutable.PriorityQueue[Int] = mutable.PriorityQueue.empty[Int]

    var i = 0
    while (i < nums.size) {
      maxHeap.enqueue(nums(i))
      i += 1
    }

    var num = -1
    for (i <- 1 to k) {
      num = maxHeap.dequeue()
    }
    num
  }
}
