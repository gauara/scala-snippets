package leetcode.hard.arrayandstrings

object Set238ProductOfArrayExceptSelfOpt2 extends App {
  def productExceptSelf(nums: Array[Int]): Array[Int] = {

    val output: Array[Int] = new Array(nums.length)
    val length = nums.length
    // output is right array
    output(length-1) = 1 // set last element of array to 1
    // at ith location, we are storing product of right side of this ith location
    // excluding this element itself
    // NOTE nums(i+1) not nums(i)
    // we initialized  last location and starting from penultimate location

    for (i <- length-2 to 0 by -1) {
      output(i) = nums(i+1)*output(i+1) // NOTE -- JUST be very careful about these things -- its nums i and output i+1 array
    }

    // LEFT Side product now
    // we will start in nums by index = 1
    // we will store number

    // since we are accessing nums(i-1), we need to preserve it first for next iteration
    var prev = nums(0)
    var next: Int = 1
    nums(0) = 1
    for (i <- 1 to length-1) {
      var next = nums(i)
      nums(i) = prev * nums(i-1)
      prev = next

      // now nums(i) store the left array product
      // since we are iterating we can store the final result in output
      // output (i) = ouput(i) * nums(i)
      // we don't need to worry about the first element since nums(0) == 1
      output(i) = output(i) * nums(i)
      }
    println(output.mkString(","))
    output
  }
  productExceptSelf(Array(1, 2, 3, 4))
  productExceptSelf(Array(-3, 2, -3, 8))

}
