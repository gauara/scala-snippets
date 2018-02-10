package dp.geeksforgeeks

object BinomialCofficient extends App {

  def bc(n: Int, r: Int): Int = {
    if (n < 0 || r < 0 || r > n)
      -1
    else if(r == 0 || n == r)
        1
    else {
      bc(n-1, r-1) + bc(n-1, r)
    }
  }

  println("Binomial Cofficient")
  println(bc(5, 1))
  println(bc(5, 2))
  println(bc(5, 3))
  println(bc(5, 4))
  println(bc(5, 5))
  println(bc(15, 3))



  def bcDP(n: Int, r: Int): Int = {
    def min(i: Int, r: Int) = if (i < r) i else r

    if (n < 0 || r < 0 || r > n)
      return -1

    val C: Array[Array[Int]] = Array.ofDim(n+1, r+1)

    for {
      i <- 0 to n
      j <- 0 to min(i, r) // NOTE -- the inner loop
    } yield {
      if (j == 0 || j == i)
        C(i)(j) = 1
      else
        C(i)(j) = C(i-1)(j-1) + C(i-1)(j)
    }

    C(n)(r)
  }

  println("Binomial Cofficient using DP")
  println(bcDP(5, 1))
  println(bcDP(5, 2))
  println(bcDP(5, 3))
  println(bcDP(5, 4))
  println(bcDP(5, 5))
  println(bcDP(15, 3))

}
