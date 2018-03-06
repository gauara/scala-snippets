package leetcode.hard.design


// STATUS - ACCEPTED AT LEETCODE - even with negative numbers

// NOTE -- use deque instead of head

import leetcode.hard.design.Set295ContiniusMedian.medianFinder

import scala.collection.mutable
import scala.collection.mutable.PriorityQueue

class MedianFinder() {

  /** initialize your data structure here. */

  var maxHeap = mutable.PriorityQueue.empty[Int]
  var minHeap = mutable.PriorityQueue.empty(Ordering[Int].reverse)

  def addNum(num: Int) {
    if(maxHeap.size == minHeap.size) {
      if(minHeap.size > 0 && num > minHeap.head) {
        maxHeap.+=(minHeap.dequeue) // deque instead of head

        //minHeap.dequeue()

        minHeap.+=(num)
      } else {
        maxHeap.+=(num)
      }
    } else {
      if(num < maxHeap.head) {
        minHeap.+=(maxHeap.dequeue) // deque instead of head
        maxHeap.+=(num)
      } else {
        minHeap.+=(num)
      }
    }

    println("Min Heap Stats: "  + minHeap.toString())
    println("Max heap Stats: " + maxHeap.toString())
  }

  def findMedian(): Double = {
    if (maxHeap.isEmpty) {
      0
    } else if((maxHeap.size == minHeap.size)) {
      (maxHeap.head + minHeap.head).toDouble/2
    } else {
      maxHeap.head
    }
  }
}

object Set295ContiniusMedian extends App {

  val medianFinder = new MedianFinder()
/*
  medianFinder.addNum(1)
  medianFinder.addNum(2)
  println(medianFinder.findMedian()) // 1.5
  medianFinder.addNum(3)
  println(medianFinder.findMedian())  //  2
*/


  medianFinder.addNum(-1)
  medianFinder.addNum(-2)
/*
  println(medianFinder.findMedian()) // 1.5
  medianFinder.addNum(-3)
  println(medianFinder.findMedian())  //  2
*/

  //println(medianFinder.minHeap.dequeueAll)
  //println(medianFinder.maxHeap.dequeueAll)

}
