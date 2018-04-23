package leetcode.medium.arrayandstrings

object Set334IncreasingTripletSubsequence extends App {

  def increasingTriplet(nums: Array[Int]): Boolean = {

    var left = Int.MaxValue
    var mid = Int.MaxValue
    for (i <- 0 to nums.length-1) {
      if (nums(i) <= left) {
        left = nums(i)
      } else if (nums(i) <= mid){
        mid = nums(i)
      } else {
        println(s"Triplet {$left, $mid, ${nums(i)}} for array ${nums.mkString(",")}")
        return true
      }
    }
    println(s"No triplet found for array ${nums.mkString(",")}")
    false
  }

  increasingTriplet(Array(1, 2, 3, 4, 5))
  increasingTriplet(Array(5, 4, 3, 2, 1))
  increasingTriplet(Array(12, 11, 10, 5, 6, 2, 30))
  increasingTriplet(Array(-1, -2, -3, -2, 0))
}


