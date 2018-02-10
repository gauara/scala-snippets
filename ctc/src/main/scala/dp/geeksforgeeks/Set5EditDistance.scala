package dp.geeksforgeeks

object Set5EditDistance extends App {

  def editDistance(str1: String, str2: String): Int = {
    val numRows = str1.length + 1
    val numCols = str2.length + 1

    val rowRange = numRows-1
    val colRange = numCols-1

    var T : Array[Array[Int]] = Array.ofDim(numRows, numCols)

    // base case set up
    for {
      i <- 0 to rowRange
      j <- 0 to colRange
    } yield {
      if (i == 0)
        T(i)(j) = j
      if (j == 0)
        T(i)(j) = i
    }

    for {
      i <- 1 to rowRange
      j <- 1 to colRange
    } yield {

      if (str1(i-1) == str2(j-1)) { // NOTE all these crazy array out of bounds conditions
        T(i)(j) = T(i-1)(j-1)
      } else {
        T(i)(j) = 1 + Math.min(Math.min(
          T(i-1)(j-1),
          T(i)(j-1)),
          T(i-1)(j)
        )
      }
    }

    T(rowRange)(colRange)
  }

  println(editDistance("sunday", "saturday"))
  println(editDistance("saturday", "sunday"))
}
