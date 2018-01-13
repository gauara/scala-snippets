package sorting.geeksforgeeks


object OverlappingIntervals extends App {

  //arr[] = {{1,3}, {5,7}, {2,4}, {6,8}}

  case class Interval(start: Int, end: Int)

  def sortIntervalsByStartTime(arr: Array[Interval]): Array[Interval]=  {
    // NOTE -- sorting is not mutating the array and hence store result in result
    val sorted = arr.sortWith(_.start < _.start)
    println("Sorted Intervals by Start time")
    sorted.foreach(i => println(s"Start : ${i.start} End : ${i.end}"))
    sorted
  }

  def isOverLap(arr: Array[Interval]): Boolean = {
    val sorted = sortIntervalsByStartTime(arr)
    var overlaps = 0

    for (i <- 0 to sorted.length - 2) {
      if (sorted(i + 1).start < sorted(i).end) overlaps += 1
    }
    println(s"Overlaps : $overlaps")

    overlaps > 0
  }

  val intervals = Array(
    Interval(1, 3),
    Interval(5, 7),
    Interval(2, 4),
    Interval(6, 8)
  )


  val intervals1 = Array(
    Interval(1, 3),
    Interval(7, 9),
    Interval(4, 6),
    Interval(10, 13)
  )

  if (isOverLap(intervals)) println("Overlapping intervals found") else println("No Overlapping intervals")
  if (isOverLap(intervals1)) println("Overlapping intervals found") else println("No Overlapping intervals")
}
