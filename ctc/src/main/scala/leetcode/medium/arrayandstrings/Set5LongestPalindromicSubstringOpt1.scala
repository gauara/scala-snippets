package leetcode.medium.arrayandstrings

// https://leetcode.com/problems/longest-palindromic-substring/description/

object Set5LongestPalindromicSubstringOpt1 extends App {

  def longestPalindrome(s: String): String = {
    if (s.length <= 1)
      return s

    var start = 0
    var end = 0
    var len = 0

    for (i <- 0 to s.length-1) {
      val l1 = expandAroundCorner(s, i, i) // odd case
      val l2 = expandAroundCorner(s, i, i+1) // odd case
      val l = Math.max(l1, l2)

      if (l > end-start) {
        start = i - (l-1)/2
        end = i + l/2 // this is true for both odd and even case
      }
    }
    val res = s.substring(start, end+1) // should work even if end is nth location in string
    println(s" Max length palindromic substring for s: $s is => $res")
    res
  }

  def expandAroundCorner(s:String, left: Int, right: Int): Int = {
    var l = left
    var r = right

    while (l >= 0 && r <= s.length-1 && s.charAt(l) == s.charAt(r)) {
      l -= 1
      r += 1
    }
    r - l - 1 // 2 3 4 5 6  =>  6 -2 - 1 = 3 because when while loop  break l and r do not point to same Chars and hence 2, 6 are not included
  }


  longestPalindrome("babad")
  longestPalindrome("bab")
  longestPalindrome("bbbbbb") // even
  longestPalindrome("bbbbb") // odd
  longestPalindrome("aabaa")
  longestPalindrome("aabbaa")
  longestPalindrome("daabaaf")
  longestPalindrome("daabbaaf")

}
