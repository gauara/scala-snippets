package dp.geeksforgeeks

object CoinChangeProblem extends App {

  // 1 2 3
  def count(sum: Int ): Int = {
    if (sum < 0)
      return 0
    if (sum == 0)
      return 1

    return count(sum-1) + count(sum-2) + count(sum-3)
  }

  println(count(4))
}
