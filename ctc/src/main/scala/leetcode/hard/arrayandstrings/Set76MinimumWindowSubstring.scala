package leetcode.hard.arrayandstrings

// Equivalent of super sequence in CTCI ??
// STATUS - NOT WORKING

import scala.collection.mutable.Map

object Set76MinimumWindowSubstring extends App {

  def minWindow(s: String, t: String): String = {

    if(s.length == 0 || s == null || s.length < t.length)
      return ""

    val map: Map[Char, Int] = Map.empty

    // PREPARE THE HASH MAP
    for (i <- 0 to t.length-1) {
      val c = t.charAt(i)
      if (map.contains(c)) {
        map.put(c, map.get(c).get + 1) // REPEATED CHAR CASE
      } else {
        map.put(c, 1)
      }
    }



    // NOW TRY LIKE A SLIDING WINDOW

    var left = 0
    var minWindow = 0
    var found = 0
    var minLeft = 0

    for (right <- 0 to s.length-1) {

      if(map.contains(s(right))) {
        val c = s(right)
        val v = map.get(c).get
        map.put(c, v -1)
        if (map.get(c).get >= 0) {
          found += 1 // we found an instance of this char
        }
      }

      // check if we have found chars == given string t
      // if so we should think about moving left and try to shrink the window


      while(found == t.length) {
        if(right - left -1 < minWindow) {
          minWindow = right - left - 1
          minLeft = left
        }

        println(s"Left : $left")
        if (map.contains(s(left))) {
          val c = s(left)
          val v = map.get(c).get
          map.put(c, v-1)

          if (map.get(c).get > 0) {
            found -= 1
          }
        }

        left += 1
      }
    }


    if(minWindow > s.length())
      return ""

    return s.substring(minLeft ,minLeft + minWindow)
  }

  minWindow("a", "a")
}
