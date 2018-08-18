package leetcode.easy.linkedlist

object Set19RemoveNthNodeFromEndOfList extends App {

  class ListNode(var _x: Int = 0) {
    var next: ListNode = null
    var x: Int = _x
  }

  def removeNthFromEnd(head: ListNode, n: Int): ListNode = {
    // no node , head is null
    if (head == null) {
      return head
    }

    // one node
    if (head.next == null) {
      return head.next
    }

    var slow = new ListNode()
    var fast = new ListNode()

    slow = head
    fast = head
    var count = 0

    while(count < n) { // since count start with 0, fast takes n steps
      fast = fast.next
      count += 1
    }

    // if fast already reached null, then its the slow node that needs be removed, head node - last from the tailend
    if (fast == null)   {
      return head.next
    }

    // more generic flow for rest of the cases
    // SLOW IS THE PREV NODE the NODE TO BE DELETED
    // otherwise normal case
    // if we reached here note that we are procedding until fast.next is null, at this point both ptrs move one step

    while (fast.next != null) {
      slow = slow.next
      fast = fast.next
    }

    slow.next = slow.next.next  // SLOW points to THE PREV NODE from the NODE TO BE DELETED
    head
  }
}
