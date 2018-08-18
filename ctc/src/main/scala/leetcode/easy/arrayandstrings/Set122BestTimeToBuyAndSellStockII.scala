package leetcode.easy.arrayandstrings

object Set122BestTimeToBuyAndSellStockII extends App {

  def maxProfit(prices: Array[Int]): Int = {
    var max = 0

    if (prices.length < 2) return 0

    var i = 0
    var prev = 0
    while (i < prices.length) {

      while ((i+1) < prices.length && prices(i + 1) < prices(i))
        i += 1

      val buy = prices(i)
      var j = i

      while ((j + 1) < prices.length && prices(j + 1) > prices(j))
        j += 1

      val sell = prices(j)

      i = j + 1

      max += sell - buy

    }
    println(s"Max Proft: $max")
    max
  }

  maxProfit(Array(7,1,5,3,6,4))
  maxProfit(Array(1,2,3,4,5))
  maxProfit(Array(7,6,4,3,1))

}
