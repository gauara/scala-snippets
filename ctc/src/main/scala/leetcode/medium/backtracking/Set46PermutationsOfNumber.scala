package leetcode.medium.backtracking

import scala.collection.mutable.ListBuffer

object Set46Permutations extends App {

  def getPermutes(result: ListBuffer[ListBuffer[Int]], nums: Array[Int], start: Int): Unit = {
    if (start == nums.length-1){
      result.+=:(nums.to[ListBuffer])
      println(nums.mkString(","))
      return
    } else {
      for (i <- start to nums.length-1) {
        swap(nums, start, i)
        getPermutes(result, nums, start + 1)
        // since we need back what we had passed before going into downward recursion
        // swap back or we preserve a copy
        // NOTE IN CASES OF STRING WE ARE GENERATING NEW STRING AND PRESERVING ORIGINAL
        // SINCE STRINGS CANT MUTATE IN SCALA
        swap(nums, i, start)
      }
    }

    def swap(nums: Array[Int], i: Int, j: Int): Unit = {
      val t = nums(i)
      nums(i) = nums(j)
      nums(j) = t
    }
  }

  def permute(nums: Array[Int]): List[List[Int]] = {
    var result = ListBuffer[ListBuffer[Int]]()

    getPermutes(result, nums, 0)
    val ret = result.map(_.toList).toList
    println(s"printing result")
    ret.foreach(println)
    ret
  }

  permute(Array(1, 2, 3))
}
