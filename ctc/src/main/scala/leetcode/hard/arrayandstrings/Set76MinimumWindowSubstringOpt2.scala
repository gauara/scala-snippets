package leetcode.hard.arrayandstrings

import scala.collection.mutable.Map

object Set76MinimumWindowSubstringOpt2 extends App {

  /*
  def minWindow(s: String, t: String): String = {

    if (s.length == 0 || s == null || s.length < t.length)
      return ""

    val map: Map[Char, Int] = Map.empty

    // build the original map
    for (i <- 0 to t.length - 1) {
      val c = t.charAt(i)
      if (map.contains(c)) {
        map.put(c, map.get(c).get + 1) // REPEATED CHAR CASE
      } else {
        map.put(c, 1)
      }
    }

    // find the first window
    var found: Map[Char, Int] = Map.empty
    var right = 0
    var count = 0
    while (right < s.length - 1 && count < t.length) {
      val k = s(right)
      if (map.contains(k)) {
        if (found.getOrElse(k, 0) < map.get(k).get) { // if repeated chars and appear more than original
          found.put(k, found.getOrElse(k, 0) + 1)
          count += 1
        } else {
          found.put(k, found.getOrElse(k, 0) + 1)
        }
      }
      right += 1
    }


    var left = 0
    var minLength = 0

    var leftLoop = true
    while (leftLoop && left < s.length - 1) {
      val k = s(left)
      if (found.contains(k)) {
        if (found.get(k).get > map.get(k).get) {
          found.put(k, found.get(k).get - 1)
          left += 1
        } else {
          leftLoop = false
          minLength = right - left
        }
      }



      left += 1
    }

    // reset right to one less position since it moves past 1 location to true window
    minLength = right - left

    // Now we just have to slide the window while meeting the constraints
    // character to be dropped is at left
    var droppedChar = s(left)
    var loop = false
    while (right < s.length - 1) {
      while (s(right) != droppedChar && right < s.length-1) {
        right += 1 //
      }
      // we need to move left such as it hits a valid char
      loop = true
      while (loop && left < s.length - 1) {
        val k = s(left)
        if (found.contains(k)) {
          if (found.get(k).get > map.get(k).get) {
            found.put(k, found.get(k).get - 1)
            left += 1
          } else {
            droppedChar = k
            loop = false
            minLength = right - left
          }
        }
        left += 1
      }
    }
    println(s"Substring: ${s.substring(left, left + minLength - 1)}")
    s.substring(left, left + minLength - 1)
  }
  */

  def minWindow(s: String, t: String): String = {
    var map = new Array[Int](128)
    for (i <- 0 to t.length - 1) {
      val c = t.charAt(i)
      map(c) = map(c) + 1
    }

    var start = 0
    var end = 0
    var minStart = 0
    var minLen = Int.MaxValue
    var counter = t.length

    while (end < s.length) {
      var c1 = s.charAt(end)
      if (map(c1) > 0) counter -= 1
      map(c1) = map(c1) - 1
      end += 1

      while (counter == 0) {
        if (minLen > end - start) {
          minLen = end - start
          minStart = start
        }
        var c2 = s.charAt(start)
        map(c2) = map(c2) + 1
        if (map(c2) > 0) counter += 1
        start += 1
      }
    }

    if (minLen == Int.MaxValue) {
      ""
    } else {
      println(s"Substring: ${s.substring(minStart, minStart + minLen)}")
      s.substring(minStart, minStart + minLen)
    }
  }

  //minWindow("ADOBECODEBANC", "ABC")
  //minWindow("HOADOBECODEBANC", "ABC")
  minWindow("HOADOBEC", "ABC")
  //minWindow("ADOBEC", "ABC")
}
