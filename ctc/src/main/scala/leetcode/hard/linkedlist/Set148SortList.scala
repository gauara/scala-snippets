package leetcode.hard.linkedlist

import scala.collection.mutable

// https://leetcode.com/problems/sort-list/description/

//import scala.collection.mutable._

object Set148SortList extends App {

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

  //var minHeap: mutable.PriorityQueue[ListNode] = mutable.PriorityQueue.empty[ListNode](Ordering(_.x).reverse)


  def sortList(head: ListNode): ListNode = {

    if (head == null || head.next == null) {
      ListNode.printLinkedList(head)
      return head
    }

    val minHeap: mutable.PriorityQueue[ListNode] = mutable.PriorityQueue.empty(Ordering.by[ListNode, Int](_.x).reverse)
    var p: ListNode = head

    val dummy: ListNode = new ListNode(0)
    var tail: ListNode = dummy

    while (p != null) {
      minHeap.enqueue(p)
      p = p.next
    }

    while (minHeap.nonEmpty) {
      val node = minHeap.dequeue()
      tail.next = node // tail is not null as per above instantiation
      tail = node // Important to assign tail to new node
      tail.next = null // SUPER Important
    }

    ListNode.printLinkedList(dummy.next)
    dummy.next
  }

  sortList(new ListNode(0))


  // -1->5->3->4->0

  val h: ListNode = new ListNode(-1)
  h.next = new ListNode(5)
  h.next.next = new ListNode(3)
  h.next.next.next = new ListNode(4)
  h.next.next.next.next = new ListNode(0)

  sortList(h)

}
