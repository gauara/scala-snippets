package leetcode.easy.arrayandstrings

// https://leetcode.com/problems/valid-palindrome/description/

object Set125ValidPalindrome extends App {



  def isPalindrome(s: String): Boolean = {

    val x = 'a' to 'z'
    val y = 'A' to 'Z'
    val z = '0' to '9'

    val set = x ++ y ++ z
    var str = s.map(_.toLower).filter(set.contains(_))

    var i = 0
    var j = str.length-1
    while (i < j) {
      if (str(i) == str(j)) {
        i += 1
        j -= 1
      } else {
        //println(s"String: $str is a NOT A Palindrome")
        return false
      }
    }
    //println(s"String: $str is a Palindrome")
    true
  }

  isPalindrome("A man, a plan, a canal: Panama")
  isPalindrome("race a car")

}
