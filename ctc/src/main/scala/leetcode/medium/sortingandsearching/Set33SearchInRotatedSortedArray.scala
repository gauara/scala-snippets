package leetcode.medium.sortingandsearching

object Set33SearchInRotatedSortedArray extends App {


  def binarySearch(nums: Array[Int], l: Int, r: Int, target: Int): Int = {
    if (r < l)
      return -1

    if ( l == r) {
      if (nums(l) == target) return l else return -1
    }

    val mid = (l + r)/2

    if (target == nums(mid)) {
      mid
    } else if (target > nums(mid)) {
      binarySearch(nums, mid+1, r, target)
    } else {
      binarySearch(nums, l, mid-1, target)
    }
  }

  def searchPivot(nums: Array[Int], l: Int, r: Int): Int = {

    if (r < l)
      return -1

    if (l == r)
      return l

    val mid = (l + r)/2

    // if mid is pivot element
    if (nums(mid) > nums(mid+1)) {
      mid
    } else {
      if (nums(mid) <= nums(r)) {
        // pivot element is in left half
        searchPivot(nums, l, mid)
      } else {
        // pivot element is in right half
        searchPivot(nums, mid, r)
      }
    }
  }

  def search(nums: Array[Int], target: Int): Int = {
    if (nums.length < 1)
      return -1

    val pivot = searchPivot(nums, 0, nums.length-1)

    val r = if (pivot < 0) {
      binarySearch(nums, 0, nums.length-1, target)
    } else if (nums(pivot) == target) {
      pivot
    } else if (pivot == nums.length-1) {
      binarySearch(nums, 0, pivot-1, target)
    } else if (target >= nums(pivot+1) && target <= nums(nums.length-1)) {
      binarySearch(nums, pivot+1, nums.length-1, target)
    } else {
      binarySearch(nums, 0, pivot-1, target)
    }

    println(s"Array: ${nums.mkString(",")} Pivot Idx: $pivot, and Index for Target $target is: $r")
    r
  }

//  search(Array(4,5,6,7,0,1,2), 0)
//  search(Array(4,1), 0)
  //search(Array(-1), 0)
  //search(Array(-1), -1)
//  search(Array(4,5,6,7,8,9,11,13,17,0,1,2), 0)
//
//  search(Array(1), 1)
//  search(Array(1, 3), 1)
//  search(Array(3, 1), 1)
//  search(Array(4,5,1,2,3), 1)
//  search(Array(5,1,3), 5)
  search(Array(6,7,8,1,2,3,4,5), 3)

}
