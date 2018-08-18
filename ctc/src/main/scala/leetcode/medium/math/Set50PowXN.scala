package leetcode.medium.math

object Set50PowXN extends App {
  def pow(x: Double, r: Int): Double = {
    if (r == 0)
      return 1

    if (r == 2)
      return x * x

    val odd: Boolean = r % 2 == 1
    val res: Double = pow(x, r/2)
    val rr = if (odd) res * res * x else res * res
    //println(s"X: $x r: $r result:  $rr")
    rr
  }

  def myPow(x: Double, n: Int): Double = {

    val outRange = n == Int.MinValue
    var n1 = if (n < 0 ) -1*n else n

    if (outRange) n1 -= 1
    val res1 = pow(x, n1)
    //println(res1)
    val res = if (n >= 0) res1 else 1/res1
    //println(s"Result : $res")
    res

    if (outRange)
      res/x
    else
      res
  }
}
