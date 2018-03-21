package leetcode.medium.backtracking

import scala.collection.mutable.{ArrayBuffer, ListBuffer}

object Set254FactorCombinations extends App {

  //def factors(result: ArrayBuffer[ArrayBuffer[Int]], factorList:ArrayBuffer[Int], n: Int, start: Int ): ArrayBuffer[ArrayBuffer[Int]] = {
  def factors(result: ListBuffer[ListBuffer[Int]], factorList:ListBuffer[Int], n: Int, start: Int ): Unit = {
    //println(s"n: $n start: $start")
    if (n <= 1) {
      if (factorList.size > 1) { // if size is 1 it means number is divided by itself and n == 1
        // only add when item is list is not same as number
        //println(s"stats n: $n start: $start")
        //println(result.mkString)

        println(factorList.mkString(","))
        result.append(factorList)
       // println(result)
      }
      //println(result.mkString)
      return
    }

    for(i <- start to n) {
      if (n % i == 0) {
        //factorList.+=(i)
        factorList.append(i)
        //factors(result, factorList, n/i, start+1)
        //println(s"stats n: $n start: $start")

        factors(result, factorList, n/i, i)
        //println("before")
        //println(factorList.mkString(","))
        factorList.remove(factorList.size-1)
        //println("after")
        //println(factorList.mkString(","))
      }
    }

  }

  def getFactors(n: Int): List[List[Int]] = {
    var result: ListBuffer[ListBuffer[Int]] = ListBuffer.empty[ListBuffer[Int]]
    var factorList: ListBuffer[Int] = ListBuffer.empty[Int]

    factors(result, factorList, n, 2)
    //val rt = ans.map(_.toList).toList

    println("")
    val rt = result.map(_.toList).toList
    //print(result.mkString)

    println(result.mkString)
    //println(rt.mkString)
    rt
  }

  //getFactors(12)
  getFactors(24)

  /*
  var result: ListBuffer[ListBuffer[Int]] = ListBuffer.empty[ListBuffer[Int]]
  var factorList1: ListBuffer[Int] = ListBuffer.empty[Int]
  factorList1.append(1)
  factorList1.append(2)
  factorList1.append(3)

  var factorList2: ListBuffer[Int] = ListBuffer.empty[Int]
  factorList2.append(4)
  factorList2.append(5)
  factorList2.append(6)

  result.append(factorList1)
  result.append(factorList2)

  println(result.mkString(","))*/

}
