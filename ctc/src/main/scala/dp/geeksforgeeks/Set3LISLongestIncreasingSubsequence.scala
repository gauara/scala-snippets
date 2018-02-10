package dp.geeksforgeeks

// SET 3  - https://www.geeksforgeeks.org/longest-increasing-subsequence/

object Set3LISLongestIncreasingSubsequence extends App {

  def LIS(arr: Array[Int]): Int = {

    //val lis = new Array[Int](arr.length)
    val lis = Array.fill[Int](arr.length)(1) // NOTE - Initialize each index with 1 as each element is 1 length LIS

    for {
      i <- 0 to arr.length-1
      j <- 0 to i
    } yield {
      if (arr(i) > arr(j) && lis(i) < lis(j) + 1) // NOTE - check the condition here - no equality needed
        lis(i) = lis(j) + 1
    }

    var max = Int.MinValue
    for (i <- 0 to lis.length - 1) {
      if (lis(i) > max) max = lis(i)
    }
    println(s"The LIS length is : $max")
    lis.foreach(println)
    max
  }

  LIS(Array(10, 22, 9, 33, 21, 50, 41, 60, 80))
  LIS(Array(3, 4, -1, 0, 6, 2, 3))
  LIS(Array(2, 5, 1, 8, 3))
}
