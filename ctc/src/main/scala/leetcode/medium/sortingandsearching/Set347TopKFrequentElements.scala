package leetcode.medium.sortingandsearching

object Set347TopKFrequentElements extends App {

  def topKFrequent(nums: Array[Int], k: Int): List[Int] = {

    var map: Map[Int, (Int, Int)] = Map.empty
    nums.foreach { i =>
      val f = map.getOrElse(i, (-1, 0))
      map = map.updated(i, (i, f._2 + 1))
    }
    val r = map.values.toList.sortBy(-1*_._2).take(k).map(i => i._1)
    //println(r.mkString(","))
    r
  }

  topKFrequent(Array(1,1,1,2,2,3), 2)
}
