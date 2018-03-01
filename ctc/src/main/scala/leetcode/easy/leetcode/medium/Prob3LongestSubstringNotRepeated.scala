package leetcode.easy.leetcode.medium

import arraysandstrings.CTC01_UniqueCharsInString
import leetcode.easy.leetcode.medium.Prob3LongestSubstringNotRepeated.lengthOfLongestSubstringUsingFor

object Prob3LongestSubstringNotRepeated extends App {

  def lengthOfLongestSubstring(s: String): Int = {
    val result = if(s.isEmpty) {
      0
    } else {
      var maxLength = 1
      for (l <- 1 to s.length) {
        var j = 0

        while (j < s.length) {
          if(j + l <= s.length) {
            val str = s.substring(j, j + l)
            //println(s"String $str")
            if(CTC01_UniqueCharsInString.isUniqueChars1(str)) {
              maxLength = l
            }
          }
          j += 1
        }
      }
      maxLength
    }

    println()
    println(s"Length of non repeated string is: $result")
    result
  }




  def lengthOfLongestSubstringUsingFor(s: String): Int = {
    val result = if(s.isEmpty) {
      0
    } else {
      var maxLength = 1
      for (l <- 1 to s.length) {
        for (j <- 0 to s.length) {
          if (j + l <= s.length) {
            val str = s.substring(j, j + l)
            println(str)
            if(CTC01_UniqueCharsInString.isUniqueChars1(str)) {
              maxLength = l
            }
          }
        }
      }
      maxLength
    }

    println()
    println(s"Length of non repeated string: $s using FOR is: $result")
    result
  }

  /*lengthOfLongestSubstring("hello")
  lengthOfLongestSubstring("aaa")
  lengthOfLongestSubstring("abcdeefghijk")
  lengthOfLongestSubstring("aabbcde")
  lengthOfLongestSubstring("")
  lengthOfLongestSubstring("a")
*/

  lengthOfLongestSubstringUsingFor("hello")
  lengthOfLongestSubstringUsingFor("aaa")
  lengthOfLongestSubstringUsingFor("abcdeefghijk")
  lengthOfLongestSubstringUsingFor("aabbcde")
  lengthOfLongestSubstringUsingFor("")
  lengthOfLongestSubstringUsingFor("a")
}
