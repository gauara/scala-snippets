package linkedlist


case class LinkedListNode(
  data:     Int,
  var next: LinkedListNode
) {

  def printLinkedList(head: LinkedListNode): Unit = {
    println("\nPrinting linked list")
    if (head != null) {
      var temp = head
      while (temp != null) {
        print(temp.data)
        if (temp.next != null) print("=>")
        temp = temp.next
      }
    }
    println()
  }

  def append(head: LinkedListNode, data: Int): LinkedListNode = {
    println("in append")
    if (head == null) {
      val node = new LinkedListNode(data, null)
      return node
    }
    // traverse to the end - add node when we hit the end
    var temp = head
    while (temp.next != null) {
      temp = temp.next
    }
    // create the new node to be appended
    temp.next = new LinkedListNode(data, null)

    head
  }

  def reverseLinkedList(head: LinkedListNode): LinkedListNode = {
    println("in reverse function, printing reversed list ")
    println("=======")
    head.printLinkedList(head)
    println("=======")
    val result = if (head == null) {
      println("Empty Linked List")
      head
    } else {
      var current = head
      var prev: LinkedListNode = null
      var next: LinkedListNode = null

      while (current != null) {
        print("***   "  + current.data + "  *****")
        next = current.next
        current.next = prev
        prev = current

        current = next
      }
      prev
    }
    result.printLinkedList(result)
    result
  }
}

object ReverseLinkedList extends App {

  val ll = LinkedListNode(1, null)

  ll.append(ll, 2)
  //ll.printLinkedList(ll)
  ll.append(ll, 3)
  //ll.printLinkedList(ll)
  ll.append(ll, 4)
  //ll.printLinkedList(ll)
  ll.append(ll, 5)
  //ll.printLinkedList(ll)

  //ll.printLinkedList(ll)

  // reverse the linked list


  // INCOMPLETE -- its going in an infinite loop at the moment

  ll.printLinkedList(ll)

  val rll = ll.reverseLinkedList(ll)

  if (rll == null) println("null return after reverse") else println("non null return " + rll.data)

  rll.printLinkedList(rll)
}
