package leetcode.medium.sortingandsearching

object Set34FindFirstandLastPositionofElementSortedArray extends App {


  def min(nums: Array[Int], l: Int, r: Int, target: Int): Int = {
    if (r < l)
      return -1

    val mid = (l + r) / 2
    if (nums(mid) == target) {
      if (mid == 0 || nums(mid - 1) < nums(mid)) {
        mid
      } else {
        min(nums, 0, mid - 1, target)
      }
    } else if (nums(mid) > target) {
      min(nums, 0, mid - 1, target)
    } else {
      min(nums, mid + 1, r, target)
    }
  }

  def max(nums: Array[Int], l: Int, r: Int, target: Int): Int = {
    if (r < l)
      return -1

    val mid = (l + r)/2
    if (nums(mid) == target) {
      if (mid == r || nums(mid+1) > nums(mid)) {
        mid
      } else {
        max(nums, mid+1, r, target)
      }
    } else if (nums(mid) > target) {
      max(nums, 0, mid-1, target)
    } else {
      max(nums, mid + 1, r, target)
    }
  }

  def searchRange(nums: Array[Int], target: Int): Array[Int] = {
    val first: Int = min(nums, 0, nums.length-1, target)
    val last: Int = max(nums, 0, nums.length-1, target)

    val res = Array(first, last)
    println(s"First and Last: ${res.mkString(",")}")
    res
  }

  searchRange(Array(1, 2, 2, 2, 2, 3, 4, 7, 8, 8), 8)
  searchRange(Array(2, 2,2, 3), 2)
}
