package leetcode.hard.linkedlist

import linkedlist.LinkedListNode

import scala.collection.mutable
import scala.collection.mutable.PriorityQueue


// NOTE -- MY THIS SOLUTION DOES NOT WORK FOR LEETCODE - GETTING DIFF OUTPUT FOR SAME INPUT
// CHECK ANOTHER VERSION THAT IS COPIED FROM LEETCODE Solution
// COPIED SOLUTION WORKS FOR LEETCODE

class ListNode(var _x: Int = 0) {
  var next: ListNode = null
  var x: Int = _x
}

object ListNode {
  def printLinkedList(head: ListNode): Unit = {
    println("\nPrinting linked list")
    if (head != null) {
      var temp = head
      while (temp != null) {
        print(temp._x)
        if (temp.next != null) print("=>")
        temp = temp.next
      }
    }
    println()
  }
}



object Set23MergeKSortedLists extends App {

  //val head = null // dont need head for this problem
  var head: ListNode = null
  var tail: ListNode = null

  def append(n: ListNode): Unit = {
    println(n._x)
    if (head == null) {
      head = n
      tail = n
    } else {
      tail.next = n
      tail = n
      //tail.next = null
    }
  }


  def mergeKLists(lists: Array[ListNode]): ListNode = {

    var minHeap = mutable.PriorityQueue.empty(Ordering.by[ListNode, Int](_._x).reverse)

    for (i <- 0 to lists.length-1) {
      val node = lists(i)
      if (node != null) {
        minHeap.enqueue(node)
      }
    }

    ListNode.printLinkedList(minHeap.head)

    while(!minHeap.isEmpty) {
      val node = minHeap.dequeue()
      append(node) // node cant be null because we do this check at insert to queue

      // add the next node to the queue
      if (node.next != null) {
        minHeap.enqueue(node.next)
      }
    }
    head
  }

  val n1a = new ListNode(0)
  val n1b = new ListNode(2)
  val n1c = new ListNode(5)
  n1a.next = n1b
  n1b.next = n1c
  n1c.next = null

  val node = mergeKLists(Array(n1a))
  ListNode.printLinkedList(node)

}


