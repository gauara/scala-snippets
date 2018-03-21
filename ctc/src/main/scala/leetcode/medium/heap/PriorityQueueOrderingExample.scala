package leetcode.medium.heap

import scala.collection.mutable

// https://stackoverflow.com/questions/39343425/priority-queue-with-custom-ordering
object PriorityQueueOrderingExample extends App {

  // YOU define a winning criteria
  // BY default its the HIGHEST priority wins
  // that is its a MAX HEAP
  // YOu DEFIEN THE MAX HEAP CRITIERIA AND call .reverse
  // print prints the highest priority first

  case class CustomTuple(s: String, f: Int) extends Ordered[CustomTuple] {
    override def compare(that: CustomTuple): Int = {
      //if (this.f == that.f ) that.s.compareTo(this.s)
      if (this.f == that.f ) that.s.length - this.s.length // THIS WINS if length of THIS is shorter
      else this.f - that.f
    }
  }

  var heap1 = mutable.PriorityQueue.empty[CustomTuple]
  heap1.enqueue(CustomTuple("hello", 5), CustomTuple("h", 5))
  println(heap1.mkString)
  println(heap1.dequeue().toString)


  // CONVERTING INTO A MIN HEAP

  var heap2 = mutable.PriorityQueue.empty[CustomTuple].reverse
  heap2.enqueue(CustomTuple("hello", 5), CustomTuple("h", 5))
  println(heap2.mkString)
  println(heap2.dequeue().toString)

  //var minHeap = mutable.PriorityQueue.empty(Ordering.by[ListNode, Int](_._x).reverse)


  // fromLessThan creates a min heap  -- if

  def compare(ths: (String, Int), tht: (String, Int)): Boolean = {

   // (ths._2 > tht._2 || ths._1.length < tht._1.length)
    if (ths._2 == tht._2) ths._1.length < tht._1.length
    else ths._2 > tht._2
  }

  var heap3 = mutable.PriorityQueue.empty(Ordering.fromLessThan[(String, Int)](compare))

  heap3.enqueue(("hello", 5), ("h", 5))
  println(heap3.mkString)

  var heap4 = mutable.PriorityQueue.empty(Ordering.fromLessThan[(String, Int)](compare).reverse)

  heap4.enqueue(("hello", 5), ("h", 5))
  println(heap4.mkString)



  var heap5 = mutable.PriorityQueue.empty(Ordering.fromLessThan[(Int)]((x,y) => x > y))
  //heap5.enqueue(1, 2, 3, 4, 5, 6)
  heap5.enqueue(6, 5, 4, 3, 2, 1)
  println(heap5.mkString)


}
