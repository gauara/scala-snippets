package linkedlist

import datastructures.Stack

import scala.collection.mutable.ArrayBuffer


object CTC06_isPalindrome extends App {

  class ListNode(var _x: Int = 0) {
    var next: ListNode = null
    var x: Int = _x
  }


  def append(head: ListNode, data: Int): ListNode = {
    if (head == null) {
      val node = new ListNode(data)
      return node
    }
    // traverse to the end - add node when we hit the end
    var temp = head
    while (temp.next != null) {
      temp = temp.next
    }
    // create the new node to be appended
    temp.next = new ListNode(data)
    head
  }

  def printLinkedList(head: ListNode): Unit = {
    println("\nPrinting linked list")
    if (head != null) {
      var temp = head
      while (temp != null) {
        print(temp.x)
        if (temp.next != null) print("=>")
        temp = temp.next
      }
    }
    println()
  }


  def sizeLinkedList(head: ListNode): Int = {
    var size = 0
    if (head != null) {
      var temp = head
      while (temp != null) {
        size += 1
        print(temp.x)
        if (temp.next != null) print("=>")
        temp = temp.next
      }
    }
    println(s"\nSize of Linked List: $size")
    size
  }

  def pushListElementsToStack(head: ListNode, numElements: Int, stack: Stack): Unit = {
    if (head != null) {
      var current: ListNode = head
      for (i <- 0 to numElements - 1 if current != null) {
        stack.push(current.x)
        current = current.next
      }
    }

    if (!stack.isEmpty()) stack.printStack()
  }

  // approach 1 - using stack

  def isPalindrome(head: ListNode): Boolean = {
    println("\nIn Palindrome, original list")
    printLinkedList(head)

    val s = new Stack()
    val mid = sizeLinkedList(head)/2
    pushListElementsToStack(head, mid, s)

    // now traverse the list to the mid + 1

    var i:Int = 0
    var current = head
    //while(i <= mid && current != null) {
    while(i < mid) {
      i += 1
      current = current.next // since its moving one point ahead of i
    }

    println(s"Traversal up to ${current.x} and mid : $mid and i: $i ")

    var result = true
    while(current.next != null && !s.isEmpty()) {
      if (current.x != s.pop()) {
        result = false
      }
      current = current.next
    }

    if (result) println("list is a palindrome")
    else println("list is NOT a palindrome")
    result
  }



  var head = new ListNode(5)
  append(head, 6)
  append(head, 7)
  append(head, 8)

  printLinkedList(head)
  println(sizeLinkedList(head))

  val s = new Stack()
  pushListElementsToStack(head, sizeLinkedList(head), s)
  s.printStack()


  // check for palindrome
  s.clearStack()
  pushListElementsToStack(head, sizeLinkedList(head)/2, s)

  isPalindrome(head)




  var head1 = new
      ListNode(5)
  append(head1, 6)
  append(head1, 7)
  append(head1, 8)
  append(head1, 8)
  append(head1, 7)
  append(head1, 6)
  append(head1, 5)

  isPalindrome(head1)
}
