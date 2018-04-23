package leetcode.medium.arrayandstrings

object Set3LongestSubstringWithoutRepeating extends App {

  def lengthOfLongestSubstring(s: String): Int = {

    if (s.isEmpty)
      return 0

    var left = 0
    var right = 0
    var maxLength = 0
    var breakRight = false

    var arr: Array[Int] = new Array[Int](256)
    while (right < s.length) {
      arr(s(right)) += 1


      if (arr(s(right)) > 1) {
        breakRight = true
        println(s"Right: $right Left: $left Substring: ${s.substring(left, right)}")
      }

      right += 1
      maxLength = Math.max(right-left, maxLength)

      while (breakRight) {
        if(arr(s(left)) == 2) breakRight = false
        arr(s(left)) -= 1
        left += 1
      }
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

  /*

  FAILED TEST CASES --
  BAD ASSUMPTION -- that characters are all lowercase between a - z
  BAD ASSUMPTION - 26

  CORRECT
   */
}
