package leetcode.easy.math


// https://leetcode.com/problems/power-of-three/description/

object Set326PowerOfThree extends App {

  def isPowerOfThree(n: Int): Boolean = {
    var x: Int = n
    var m: Int = -1
    var tmp: Int = -1

    if (x == 1) return true
    if (n < 3) return false // NOTE negative Ints, e.g -3 is not considered as power of 3


    var break: Boolean = false
    while (x >= 3 && !break) {
      tmp = x/3
      m = x%3
      x = tmp
      if (x >= 3 && m != 0) break = true
    }

    val ret = if (break) false else x == 1 && m == 0
    //println(s"X: $x M: $m")
    //if (ret) println(s"$n is power of 3") else println(s"$n is NOT power of 3")
    ret
  }

  isPowerOfThree(27)
  isPowerOfThree(0)
  isPowerOfThree(9)
  isPowerOfThree(45)
  isPowerOfThree(6)

  isPowerOfThree(19684)

}
