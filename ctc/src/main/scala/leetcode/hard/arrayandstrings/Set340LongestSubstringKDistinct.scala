package leetcode.hard.arrayandstrings

import scala.collection.mutable

object Set340LongestSubstringKDistinct extends App {

  /*

a b c d e d d f =>
k = 3 ,deddf 0r cdedd

 */
  def lengthOfLongestSubstringKDistinct(s: String, k: Int): Int = {
    if (s.isEmpty)
      return 0

    var start = 0
    var end = 0
    var counter = 0
    var map: Array[Int] = new Array[Int](256)
    var maxLength = Int.MinValue

    while (end < s.length) {
      val c = s(end)
      if (map(c) == 0) counter += 1 // since its still a distinct char and we haven't hit window condition yet -- Most K distinct Chars
      map(c) += 1
      end += 1

      // we do not enter it if not meet/violate window condition yet
      // if we are entering means we violated window condition and now we need to maintain it
      while (counter > k) {
        // think when we should modify the counter - reduce here
        // in this case we reduce counter when map(c) becomes 0
        val c = s(start)
        if (map(c) == 1) counter -= 1 // we know that we can reduce counter since next step is to reduce the map(c)
        map(c) -= 1
        start += 1
      }
      maxLength = Math.max(maxLength, end - start)
    }
    println(s"Max Length of Substring: (s: $s, k: $k ) is: $maxLength")
    maxLength
  }


  lengthOfLongestSubstringKDistinct("abcdeddf", 3)
  lengthOfLongestSubstringKDistinct("xy", 3)
  lengthOfLongestSubstringKDistinct("abcdefgh", 1)
  lengthOfLongestSubstringKDistinct("aaaaaaa", 4)
  lengthOfLongestSubstringKDistinct("eceba", 2)
  lengthOfLongestSubstringKDistinct("a", 2)
  lengthOfLongestSubstringKDistinct("ab", 2)
  lengthOfLongestSubstringKDistinct("abaccc", 2)

}





  /*



        while (right < s.length && set.size <= k) {
        set.+=(s(right))
        println(s"Set on Add: ${set.mkString(",")}")

        curMinLength = right-left+1 // index start with 0
        if (curMinLength > minLength && set.size <= k) {
          minLength = curMinLength
          println(s"Left: $left Right: $right MinLength: $minLength Set: ${set.mkString(",")} Substring: ${s.substring(left, left + minLength)}") // substring function takes start and end index
        }
        right += 1
      }

      // when exited means set is one more than K and element at "right" location caused it

      //minLength = Math.max(right - left, minLength)

      while (set.size != k && left < right) { // right might cross string length in last while loop

        val droppedChar = s(left)
        left += 1

        while (set.size <= k && s.substring(left, minLength).contains(droppedChar)) {
          set.-=(s(left))
        }
        println(s"Set on Remove: ${set.mkString(",")}")

      }
    }
    val result = if (minLength > 0) minLength else 0
    println(s"Min Length is: $result")
    result

   */