package leetcode.medium.backtracking

import scala.collection.mutable.ListBuffer

object Set78SubsetsUsingStringPrefix extends App {

  def getSubsets(result: ListBuffer[String], nums: Array[Int], start: Int, prefix: String): Unit = {
    if (start == nums.length) {
     return
   }
    for (i <- start to nums.length-1) {

      var pre: String = prefix + nums(i).toString
      result.+=:(pre)
      getSubsets(result, nums, i+1, pre) // we have to start from i for next level, that is ith index
    }
  }

  def subsets(nums: Array[Int]): List[List[Int]] = {

    var result = ListBuffer[String]()
    var finalResult = ListBuffer[List[Int]]()
    finalResult.+=:(Nil) // empty subset case


    // MAKE SURE TO SORT NUMBERS
    getSubsets(result, nums.sorted, 0, "")
    result.foreach(l => {
      val li: List[Int] = l.toArray.map(_.toString.toInt).toList
      finalResult.+=:(li)
    })

    println(s"printing result")

    finalResult.foreach(l => println(l.mkString))
    finalResult.toList
  }

  subsets(Array(1, 2, 3))
  //subsets(Array(-1, 2, 3))
}
