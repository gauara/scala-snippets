package leetcode.hard.design

import com.sun.corba.se.impl.dynamicany.DynEnumImpl

import scala.collection.mutable


/*
case class Node(
               var next: Node = null,
               var pre: Node = null,
               var value: Int = -1
               )

class LRUCache(_capacity: Int) {

  var map = scala.collection.mutable.Map.empty[Int, Node]

  var head: Node = null
  var tail: Node = null
  var currSize = 0

  def getNewNode(v: Int) = Node(value = v)


  def appendNodeInFront(n: Node) = {
    if (head == null) {
      head = n
      tail = n
    } else {
      head.pre = n
      n.next = head
      head = n

      if (n == tail) {
        tail = tail.pre
      }
    }
  }


  def moveNodeToFront(n: Node): Unit = {
    if (n == null) return

    if (head == null) {
      head = n
      tail = n
    } else {

      // link pre and next nodes
      val pre = n.pre
      val next = n.next

      if (pre != null) {
        pre.next = next
      }

      if (next != null) {
        next.pre = pre
      } else {
        //tail = tail.pre
      }

      // move n to front and make it new head
      n.pre = null
      n.next = head

      head.pre = n
      head = n

    }

  }


  def get(key: Int): Int = {
    if (map.contains(key)) {
      val n = map(key)
      moveNodeToFront(n)
      n.value
    } else {
      -1
    }
  }

  def evict() = {
    if (tail != null) {
      map.-=(tail.value)
      currSize -= 1

      val pre = tail.pre
      if (pre != null) {
        pre.next = null
        tail = tail.pre
      }
    }
  }

  def put(key: Int, value: Int): Unit = {
    // element exists
    if (map.contains(key)) {
      val n = map.get(key).get
      n.value = value
      moveNodeToFront(n)
    } else {
      if (currSize < _capacity) {
        val n = getNewNode(value)
        map.+=(key -> n)
        appendNodeInFront(n)
        currSize += 1
      } else {
        evict()
        val n = getNewNode(value)
        map.+=(key -> n)
        moveNodeToFront(n)
        currSize += 1
      }
    }
  }
}


object Set146LRUCache extends App {

  val cache = new LRUCache(2)
  cache.put(1, 1)
  cache.put(2, 2)
  println(cache.get(1))
  cache.put(3, 3)
  println(cache.get(2))
  cache.put(4, 4)
  println(cache.get(1))
  println(cache.get(3))
  println(cache.get(4))

}
*/
