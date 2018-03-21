package leetcode.hard.arrayandstrings

object Set238ProductOfArrayExceptSelf extends App {
  def productExceptSelf(nums: Array[Int]): Array[Int] = {
    // equivalent of right side product
    val output: Array[Int] = new Array(nums.length)

    output(nums.length-1) = nums(nums.length-1)
    for (i <- nums.length-2 to 0 by -1) {
      println(i)
      output(i) = nums(i)*output(i+1)
    }

    for (i <- 1 to nums.length-1) {
      nums(i) = nums(i)*nums(i-1)
    }

    println("----------")
    nums.foreach(println)
    println("----------")
    output.foreach(println)

    for (i <- 0 to nums.length-1) {
      var leftSide = if(i == 0) {
        1
      } else {
        nums(i-1)
      }
      var rightSide = if(i == nums.length-1) {
        1
      } else {
        output(i+1)
      }

      println(s" left: $leftSide, right: $rightSide and output($i): ${output(i)}")
      output(i) = leftSide*rightSide
    }
    println("result array: ")
    output.foreach(println)
    output
  }

  //productExceptSelf(Array(1, 2, 3))
  productExceptSelf(Array(1, 2, 3, 4))
}
