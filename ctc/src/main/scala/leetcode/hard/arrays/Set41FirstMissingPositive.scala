package leetcode.hard.arrays

object Set41FirstMissingPositive extends App {

  def returnMissing(nums: Array[Int]): Int = {
    for(i <- 0 to nums.length-1) {
      if (nums(i) != i + 1)
        return i + 1
    }
    nums.length + 1 // NOTE this return type
  }

  def swap(nums: Array[Int], i: Int, j: Int): Unit = {
    if (i < 0 || j < 0 || i > nums.length-1 || j > nums.length-1 || i == j)
      return

    val temp = nums(i)
    nums(i) = nums(j)
    nums(j) = temp
  }


  def firstMissingPositive(nums: Array[Int]): Int = {
    if (nums.isEmpty)
      return 1 // NOTE THIS EDGE TEST CASE

    var i = 0
    while(i < nums.length) {

      // Our objective is to change array to be --
      // [ 1, 2, 3, 4, 5, 8]
      // build ^^ and once done we call returnMissing and return 6 e.g
      // so move 1 to zeroth position

      // keep moving - if number is negative or 0
      // if number is more than the length of the array itself
      // number is already at its location
      if(nums(i) <= 0 || nums(i) > nums.length || nums(i) == i + 1) {
        i += 1

      // numbers to be swapped are not equal
      // swap the current to put into its correct position
      } else if(nums(i) != nums(nums(i)-1)) {
        swap(nums, i, nums(i)-1)
      } else {
        i += 1
      }
    }

    val result = returnMissing(nums)
    println(s"First missing positive number is $result")
    result
  }

  firstMissingPositive(Array(1))

}
