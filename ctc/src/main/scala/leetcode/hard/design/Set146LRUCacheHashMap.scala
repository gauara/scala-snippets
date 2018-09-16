package leetcode.hard.design

object Set146LRUCacheHashMap extends App {

  class LRUCache(_capacity: Int) {

    var cache = scala.collection.mutable.LinkedHashMap.empty[Int, Int]

    def get(key: Int): Int = {

      val r = cache.get(key) match {
        case Some(v) =>
          cache.remove(key) // remove from current position
          cache.put(key, v) // same as last accessed now
          v
        case _ => -1
      }
      println(r)
      r
    }

    def put(key: Int, value: Int): Unit = {

      cache.contains(key) match {
        case true =>
          cache.remove(key)
          cache.put(key, value)

        case false =>
          if (cache.size < _capacity) {
            cache.put(key, value)
          } else {
            val leastUsed = cache.head._1
            cache.remove(leastUsed)
            cache.put(key, value)
          }
      }
    }
  }


  //
  //  val cache = new LRUCache(2)
  //  cache.put(1, 1)
  //  cache.put(2, 2)
  //  println(cache.get(1))
  //  cache.put(3, 3)
  //  println(cache.get(2))
  //  cache.put(4, 4)
  //  println(cache.get(1))
  //  println(cache.get(3))
  //  println(cache.get(4))


  // failed test cases test

  //  val cache = new LRUCache(3)
  //  cache.put(1, 1)
  //  cache.put(2, 2)
  //  cache.put(3, 3)
  //  cache.put(4, 4)
  //
  //  cache.get(4)
  //  cache.get(3)
  //  cache.get(2)
  //  cache.get(1)


  // failed test case

  val cache = new LRUCache(2)
  cache.put(2, 1)
  cache.put(1, 1)
  cache.put(2, 3)
  cache.put(4, 1)

  cache.get(1)
  cache.get(2)
}
