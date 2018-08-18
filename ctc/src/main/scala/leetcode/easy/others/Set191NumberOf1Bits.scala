package leetcode.easy.others

object Set191NumberOf1Bits extends App {

  def hammingWeight(n: Int): Int = {
    var one: Int = 1
    var count = 0

    for (i <- 0 to 31) {
      if ((n & one) != 0) count += 1
      one <<= 1
    }
    println(s" Number of One bits in $n: $count")
    count
  }

  hammingWeight(11)
  hammingWeight(128)
}
