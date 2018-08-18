package leetcode.easy.design

// https://leetcode.com/problems/shuffle-an-array/description/

object Set384ShuffleAnArray extends App {

  class Solution(_nums: Array[Int]) {

    var arr: Array[Int] = new Array(_nums.length)

    /** Resets the array to its original configuration and return it. */
    def reset(): Array[Int] = {
      println(s"Reset to original array: ${arr.mkString(",")}")
      _nums
    }

    /** Returns a random shuffling of the array. */
    def shuffle(): Array[Int] = {

      var s: Set[Int] = Set.empty
      var i = 0
      var collisions = 0
      while (i < _nums.length) {
        val randIndex = scala.util.Random.nextInt(_nums.length)
        if (!s.contains(randIndex)) {
          arr(i) = _nums(randIndex)
          s = s + randIndex
          i += 1
        } else {
          collisions += 1
        }
      }
      //println("Shuffle Result: " + arr.mkString(",") + " Collisions: " + collisions)
      arr
    }
  }

  val s = new Solution(Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))
  s.shuffle()
  s.shuffle()
  s.shuffle()
  s.shuffle()
  s.reset()
}
