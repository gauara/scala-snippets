package leetcode.easy.others

object Set190ReverseBits extends App {

  def reverseBits(n: Int): Int = {

    val one :Int = 1
    var x: Int = 0

    for (i <- 0 to 31) {
      val ithBitON = one << (31-i)
      val nd = n & ithBitON
      println(s"i: $i and nd: $nd")

      if ( nd != 0 ) { // if ith bit is ON
        // turn on the 31-ith bit in x
        x = x | (one << i) // X ith bit is already 0
        println(s"X: $x")
      }
    }
    println(s"Original Number: $n After Reversing Bits: $x")
    x
  }

  reverseBits(13)

}
