package leetcode.medium.hashtable

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

object Set49GroupAnagramOpt2 extends App {

  def groupAnagrams(strs: Array[String]): List[List[String]] = {

    var result: ListBuffer[ListBuffer[String]] = ListBuffer.empty
    var map = mutable.Map.empty[String, ListBuffer[String]]

    for(i <- 0 to strs.length-1) {
      val sorted = strs(i).sorted
      if (!map.contains(sorted)) {
        map.put(sorted, ListBuffer(strs(i)))
      } else {
        val li = map.get(sorted).get :+ strs(i)
        map.put(sorted, li)
      }

    }
    map.foreach(k =>
      result.append(k._2)
    )
    result.foreach(println)
    result.map(_.toList).toList
  }
  groupAnagrams(Array("eat", "tea", "tan", "ate", "nat", "bat", "ba", "ab"))
}
