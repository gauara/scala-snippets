package leetcode.medium.linkedlist

// https://leetcode.com/problems/add-two-numbers/description/

object Set2AddTwoNumberLinkedList extends App {

  class ListNode(var _x: Int = 0) {
    var next: ListNode = null
    var x: Int = _x
  }

  def addTwoNumbers(l1: ListNode, l2: ListNode): ListNode = {
    var h1 = l1
    var h2 = l2

    var head: ListNode = null
    var tail: ListNode = null
    var carry = 0

    while (h1 != null || h2 != null) {
      var x1 = 0
      var x2 = 0
      var d = 0

      if (h1 != null) {
        x1 = h1.x
        h1 = h1.next
      }

      if (h2 != null) {
        x2 = h2.x
        h2 = h2.next
      }

      if (x1 + x2 + carry > 9) {
        d = (x1 + x2 + carry) % 10
        carry = 1
      } else {
        d = x1 + x2 + carry
        carry = 0
      }

      val node = new ListNode(d)
      //println("hello: " + node.x)

      if (head == null) {
        head = node
        tail = head
      } else {
        tail.next = node
        tail = node
      }
    }

    if (carry == 1) {
      val node = new ListNode(carry)
      tail.next = node
      tail = node
    }
    head
  }

}
