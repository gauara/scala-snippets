package leetcode.medium.backtracking

import scala.collection.mutable.ListBuffer

object Set78AllSubsetsOfANumber extends App {
  def getSubsets(result: ListBuffer[List[Int]], nums: Array[Int], start: Int, prefix: List[Int]): Unit = {

    result.+=:(prefix)

    println(prefix.mkString(","))

    if (start == nums.length) {
      return
    }
    for (i <- start to nums.length-1) {
      val pre = prefix :+ nums(i)
      getSubsets(result, nums, i+1, pre) // we have to start from i for next level, that is ith index
    }
  }

  def subsets(nums: Array[Int]): List[List[Int]] = {

    println("***** Getting all subsets *********")

    var result = ListBuffer[List[Int]]()

    // MAKE SURE TO SORT NUMBERS
    getSubsets(result, nums.sorted, 0, List.empty[Int])

    result.+=:(List.empty[Int])


    println(s"printing result")

    val finalResult = result.map(_.toList).toList

    //finalResult.foreach(l => println(l.mkString))
    finalResult
  }

  subsets(Array(1, 2, 3, 4))
  subsets(Array(-1, 2, 3))

}
