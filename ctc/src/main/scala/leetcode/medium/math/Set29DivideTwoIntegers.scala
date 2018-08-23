package leetcode.medium.math

object Set29DivideTwoIntegers extends App {

  def divide(dividend: Int, divisor: Int): Int = {



    if (dividend == 0)
      return 0

    if (math.abs(divisor) > math.abs(dividend))
      return 0

    val sign = if ((dividend < 0 && divisor > 0) || dividend > 0 && divisor < 0) -1 else 1

    if (math.abs(divisor) == math.abs(dividend))
      return 1 * sign


    var count = 0
    var sum = 0
    val dvdnd = math.abs(dividend)
    val dvsr = math.abs(divisor)

    while (sum < dvdnd) {
      count += 1
      sum += dvsr
    }

    val res = count - 1
    sign * res

  }


  println(divide(-1, 1))

}
