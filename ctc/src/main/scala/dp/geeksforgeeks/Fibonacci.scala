package dp.geeksforgeeks

import scala.collection.mutable.ArrayBuffer

object Fibonacci extends App {

  def f(n: Int): Int = {
    if (n <= 1) {
      n
    } else {
      f(n-1) + f(n-2)
    }
  }

  println("Using Dynamic Programming for Fibonacci")
  println(f(5))
  println(f(6))
  println(f(7))

  def fdp(n: Int): Int = {
    val F: Array[Int] = new Array[Int](n+1)
    F(0) = 0
    F(1) = 1

    for (i <- 2 to n) {
      F(i) = F(i-1) + F(i-2)
    }
    F(n)
  }

  println("Using Dynamic Programming for Fibonacci")
  println(fdp(5))
  println(fdp(6))
  println(fdp(7))


}
