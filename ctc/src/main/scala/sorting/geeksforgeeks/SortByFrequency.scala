package sorting.geeksforgeeks

object SortByFrequency extends App {

  case class Data(value: Int, var counts: Int, var firstIndex: Int)

  def sort(arr: Array[Int]): Unit = {

    var hash: Map[Int, Data] = Map.empty[Int, Data]

    var index = 0;
    arr.foreach { i =>
      if(hash.contains(i)) {
        val d = hash.get(i).get
        d.counts = d.counts + 1
        hash = hash.updated(i, d)
      } else {
        hash = hash.updated(i, Data(i, 1, index) )
      }
      index += 1
    }

    println("printing : " + hash)

    val result = hash.values.toSeq.sortWith(_.counts > _.counts)
    hash.foreach(k => println(s"Key: ${k._1} and Counts : ${k._2.counts}"))
    result.foreach(k => println(k.value))
  }

  sort(Array(1, 2, 1, 1 ,3, 4, 4, 4, 4))

}
