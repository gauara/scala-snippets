package leetcode.medium.backtracking

import scala.collection.mutable.{ArrayBuffer, ListBuffer}

object Set254FactorCombinations extends App {

  // IT is important that this factorList/prefixList is not mutable
  def factors(result: ListBuffer[List[Int]], factorList:List[Int], n: Int, start: Int ): Unit = {
    //println(s"n: $n start: $start")
    if (n == 1) {
      if (factorList.size > 1) { // if size is 1 it means number is divided by itself and n == 1
        println(factorList.mkString(","))
        result.append(factorList)
      }
      return
    }

    for(i <- start to n if start <= n) { // NOTE
      if (n % i == 0) {
        val prefixList = factorList :+ i
        factors(result, prefixList, n/i, i)
      }
    }
  }

  def getFactors(n: Int): List[List[Int]] = {
    println(s"Finding factor combinations for $n \n")
    var result: ListBuffer[List[Int]] = ListBuffer.empty[List[Int]]
    var factorList: List[Int] = List.empty[Int]

    factors(result, factorList, n, 2)
    val rt = result.map(_.toList).toList
    rt
  }

  getFactors(24)
  getFactors(32)
}
