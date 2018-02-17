package dp.geeksforgeeks

object Set7CoinChangeAllPossibleWays extends App {

  // array of coins is given
  /*
                        Total(n)
                   0 1 2 3 4 5 6 7 8 9 10
              0    1 0 0 0 0 0 0 0 0 0  0
              2    1
       coins  5    1
              3    1
              6    1

              // first row -- if 0 coins - 0 ways to make jth number
              // first col -- if 0 sum - 1 way to make 0 using upto i coins = 1 , that is don't use any coin {0} set
  */

  // NOTES - coins are not in sorted order
  // NOTES - coins are random that is some denominations are missing

  def coinChange(coins: Array[Int], n: Int): Int = {

    // cols = 0 to N ( base case , n = 0 ) cols = 0 1 2 3 4 5 6 7 8 9 10
    // rows = 1 + coins.length ,

    val T: Array[Array[Int]] = Array.ofDim(1 + coins.length, 1 + n)


    for( j <- 0 to n) T(0)(j) = 0 // make n with 0 coins - that is 0 ways
    for( i <- 0 to coins.length) T(i)(0) = 1 // do not select any coin to make 0 - that is 1 way

    for {
      i <- 1 to coins.length // inclusive
      j <- 1 to n
    } yield {

      // break it down to include and exclude case

      // NOTE THAT using i-1 with coins as coins array is separate and need to
      // be mindful that ith row is (i - 1)th in Coins index
      // also not that we are starting from row = 1 and col = 1 so coins(i-1) is OK, no array bounds exception

      if (j < coins(i-1)) {
        val include = 0
        val exclude = T(i-1)(j)
        T(i)(j) = include + exclude
      }

      if (j == coins(i-1)) {
        val include = 1
        val exclude = T(i-1)(j)
        T(i)(j) = include + exclude
      }

      if (j > coins(i-1)) {
        val include = T(i)(j-coins(i-1))
        val exclude = T(i-1)(j)
        T(i)(j) = include + exclude
      }

    }

    println(s"The number of ways to make $n is ${T(coins.length)(n)}")

    T(coins.length)(n)

  }

  coinChange(Array(2, 5, 3, 6), 10)
  coinChange(Array(0, 2, 5, 3, 6), 10) // interesting case where 0 denomination is given
  coinChange(Array(1, 2, 3), 4)
  coinChange(Array(1, 0, 2, 3), 4) // interesting case where 0 denomination is there and in middle somewhere
  coinChange(Array(1, 2, 5), 11)
  coinChange(Array(1, 2, 5), 6)

}
