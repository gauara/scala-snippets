package leetcode.easy

object FizzBuzz extends App {
  def fizzBuzz(n: Int): List[String] = {
    var arr = List.empty[String]
    for (i <- 1 to n) {
      val result = if (i%3 == 0 && i%5 == 0) {
        "FizzBuzz"
      } else if (i%3 == 0) {
        "Fizz"
      } else if (i%5 == 0) {
        "Buzz"
      } else {
        i.toString
      }
      arr = arr :+ result
    }
    arr
  }

  println(fizzBuzz(5))
  println(fizzBuzz(15))
}
