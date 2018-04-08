package leetcode.medium.string

object Set8AtoIStringtoInteger extends App {
  // n = 1 returns 10
  // n = 2 returns 100
  // n = 3 returns 1000
  def getZerosMultiplier(n: Int): Int = {
    if (n == 0) return 1
    var sum = 1
    for (i <- 1 to n ) {
      sum *= 10
    }
    return sum
  }

  def myAtoi(str: String): Int = {
    var s = str.trim
    if (str.isEmpty)
      return 0

    var multiplier: Long = 1
    if (s.startsWith("-")) {
      multiplier = -1
      s = s.trim.drop(1)
    } else if (s.startsWith("+")) {
      multiplier = 1
      s = s.trim.drop(1)
    }

    s = s.dropWhile(_ == '0').takeWhile(c => c-48 >= 0 && c-48 <= 9) // drop any initial 0s

    if (s.isEmpty)
      return 0

    var no = s.map(_ - 48)

    val invalid = no.exists(n =>  n < 0 || n > 9)
    if (invalid)
      return 0

    var num: Long = 0
    var loop = true
    no.reverse.zipWithIndex.foreach { (dandi) =>
      if (loop) {
        num += dandi._1 * getZerosMultiplier(dandi._2)
        if (num > Int.MaxValue)
          loop = false
      }
    }
    num = num*multiplier
    println(num)
    println(num.toInt)
    return num.toInt
  }
  myAtoi("123")
  myAtoi("+1")
  myAtoi("2147483648")
}
