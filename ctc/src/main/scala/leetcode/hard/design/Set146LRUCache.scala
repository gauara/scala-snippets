package leetcode.hard.design

import com.sun.corba.se.impl.dynamicany.DynEnumImpl

import scala.collection.mutable

/*
class LRUCache(_capacity: Int) {

  // my code
  var map: Map[Int, mutable.DoubleLinkedList[Int]] = Map.empty
  map.+=()

  mutable.LinkedHashSet

  var front: mutable.DoubleLinkedList[Int] = null
  var rear: mutable.DoubleLinkedList[Int] = null



  var size = 0

  def size(): Int = size

  // my code ends

  def moveNodeToFront(n: mutable.DoubleLinkedList[Int]): Unit = {


    n.remove() // rm from current position

    front.prev = n
    n.next = front

    front = n
  }

  def get(key: Int): Int = {
    // check is the the k exists
    map.get(key) match {
      case Some(dl) => {
        if (size)moveNodeToFront(dl)
        dl.elem
      }
      case _ => -1
    }
  }


  def appendLastAndUpdateMap(k: Int, v: Int): Unit = {
    val n = mutable.DoubleLinkedList(v)
    n.elem = v
    rear.next = n
    n.prev = rear
    rear = n // new node is new rear

    // update map
    map = map + (k -> n)
  }

  def evict() = {
    val temp = rear
    rear = rear.prev
    temp.remove() // I don't need to any pointer adjustment -- library should do that
  }

  def put(key: Int, value: Int): Unit = {
    // if element already exists don't do anything
    if (!map.contains(key)) {
      if (size == _capacity) {
        evict()
        appendLastAndUpdateMap(key, value)
        // No need to update capacity since we removed one and added one
      } else {
        appendLastAndUpdateMap(key, value)
        // updateSize of cache
        size += size
      }
    }
  }
}


object Set146LRUCache extends App {

  val dll: mutable.DoubleLinkedList[Int] = new mutable.DoubleLinkedList()


  def get(key: Int): Int = {

  }





}
*/