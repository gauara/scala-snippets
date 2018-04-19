package leetcode.hard.arrayandstrings

object Set238ProductOfArrayExceptSefOpt3 extends App {
  def productExceptSelf(nums: Array[Int]): Array[Int] = {

    val output: Array[Int] = new Array(nums.length)
    val length = nums.length
    // output is right array
    output(length-1) = 1 // set last element of array to 1
    // at ith location, we are storing product of right side of this ith location
    // excluding this element itself
    // NOTE nums(i+1) not nums(i)
    // we initialized  last location and starting from penultimate location

    /*
    for (i <- length-2 to 0 by -1) {
      output(i) = nums(i+1)*output(i+1) // NOTE -- JUST be very careful about these things -- its nums i and output i+1 array
    }
*/

    var i = length-2
    while (i >= 0) {
      output(i) = nums(i+1)*output(i+1)
      i -= 1
    }

    var prev = nums(0)
    for (i <- 1 to length-1) {
      output(i) = prev * output(i)
      prev = prev * nums(i)
    }
    println(output.mkString(","))
    output
  }
  productExceptSelf(Array(1, 2, 3, 4))
  productExceptSelf(Array(-3, 2, -3, 8))
}
