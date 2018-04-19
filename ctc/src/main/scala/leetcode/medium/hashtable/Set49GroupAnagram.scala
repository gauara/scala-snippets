package leetcode.medium.hashtable

import scala.collection.mutable.{ArrayBuffer, ListBuffer}

object Set49GroupAnagram extends App {


  def areAnagrams(w1: String, w2: String): Boolean = {

    //if (w1.length != w2.length)  return false

    val arr1 = new Array[Int](128)
    val arr2 = new Array[Int](128)


    for (i <- 0 to w1.length-1) {
      arr1(w1(i)) = arr1(w1(i)) + 1
      arr2(w2(i)) = arr2(w2(i)) + 1
    }

    for (i <- 0 to 125) {
      if (arr1(i) != arr2(i)) return false
    }
    true
  }

  def groupAnagrams(strs: Array[String]): List[List[String]] = {

    var found: Map[String, Boolean] = Map.empty
    var result: ArrayBuffer[ArrayBuffer[String]] = ArrayBuffer.empty

    for (i <- 0 to strs.length-1) {
      if (!found.contains(strs(i))) {
        var lb: ArrayBuffer[String] = ArrayBuffer.empty
        lb.+=(strs(i))
        found = found + (strs(i) -> true)

        if (i < strs.length-1) {
          for (j <- i + 1 to strs.length-1) {
            if (strs(i).length == strs(j).length && areAnagrams(strs(i), strs(j))) {
              lb.+=(strs(j))
              found = found + (strs(j) -> true)
            }
          }
        }

        result.+=(lb)
      }
    }
    println(result.mkString)
    result.map(_.toList).toList
  }

  groupAnagrams(Array("eat", "tea", "tan", "ate", "nat", "bat"))

}
