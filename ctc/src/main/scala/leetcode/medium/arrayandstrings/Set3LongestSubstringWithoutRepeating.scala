package leetcode.medium.arrayandstrings

object Set3LongestSubstringWithoutRepeating extends App {

  def lengthOfLongestSubstring(s: String): Int = {

    if (s.size <= 1)
      return s.size

    var left = 0
    var right = 0
    var maxLength = 0
    var enterLeftLoop = false

    var arr: Array[Int] = new Array[Int](256)
    while (right < s.length) {

      val c = s.charAt(right)
      if (arr(c) > 0 ) enterLeftLoop = true
      arr(c) += 1
      right += 1

      while (enterLeftLoop && left < s.length) {
        val c = s.charAt(left)
        if(arr(c) > 1) enterLeftLoop = false
        arr(c) -= 1
        left += 1
      }

      maxLength = Math.max(right-left, maxLength)
    }
    println(s"Given String: $s Max substring length without repeating characters: $maxLength")
    maxLength
  }

  lengthOfLongestSubstring("abcabcbb")
  lengthOfLongestSubstring("bbbbb")
  lengthOfLongestSubstring("pwwkew")
  lengthOfLongestSubstring("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\\\"#$%&'()*+,-./:;<=>?@[\\\\]^_`{|}~ abcdefg")
  lengthOfLongestSubstring("c")
  lengthOfLongestSubstring("a")
  lengthOfLongestSubstring("au")

  /*

  FAILED TEST CASES --
  BAD ASSUMPTION -- that characters are all lowercase between a - z
  BAD ASSUMPTION - 26

  CORRECT
   */
}
