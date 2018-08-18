package leetcode.easy.sortingandsearching

// https://leetcode.com/problems/merge-sorted-array/description/

object Set88MergeTwoSortedArray extends App {


  def merge(nums1: Array[Int], m: Int, nums2: Array[Int], n: Int): Unit = {

    var i = m-1
    var j = n-1
    var k = nums1.length-1

    while (i >= 0 && j >= 0) {
      if (nums1(i) >= nums2(j)){
        nums1(k) = nums1(i)
        i -= 1
        k -= 1
      } else {
        nums1(k) = nums2(j)
        j -= 1
        k -= 1
      }
    }

    //println(s"I: $i J: $j K: $k")
    if (i < 0) {
      while (k >= 0) {
        nums1(k) = nums2(j)
        k -= 1
        j -= 1
      }
    }

    if (j < 0) {
      while (k >= 0) {
        nums1(k) = nums1(i)
        k -= 1
        i -= 1
      }
    }
  }


  val nums1 = Array(1,2,3,0,0,0)
  merge(nums1, 3, Array(2,5,6), 3)
  println(nums1.mkString(","))

  val nums2 = Array(0)
  merge(nums2, 0, Array(1), 1)
  println(nums2.mkString(","))

}
