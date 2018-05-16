package leetcode.medium.linkedlist

// https://leetcode.com/problems/odd-even-linked-list/description/

object Set328OddEvenLinkedList extends App {

  class ListNode(var _x: Int = 0) {
    var next: ListNode = null
    var x: Int = _x
  }

  def oddEvenList(head: ListNode): ListNode = {

    if (head == null) // null head
      return head

    var p: ListNode = head
    var q: ListNode = p.next
    val startEven:ListNode = q
    var endOdd:ListNode = p

    while (p != null || q != null) {
      endOdd = p
      if (p != null) {
        p.next = if (q == null) null else q.next
        p = p.next
      }
      if ( q != null) {
        q.next = if (p == null) null else p.next
        q = q.next
      }
    }

    endOdd.next = startEven    // attach the odd sub list to the even list
    head
  }

}
