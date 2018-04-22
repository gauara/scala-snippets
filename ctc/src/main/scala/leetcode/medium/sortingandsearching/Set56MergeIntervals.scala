package leetcode.medium.sortingandsearching

import scala.collection.mutable
import scala.collection.mutable.{ListBuffer, Stack}


object Set56MergeIntervals extends App {

  class Interval(var _start: Int = 0, var _end: Int = 0) {
    var start: Int = _start
    var end: Int = _end

    override def toString: String = s"Start: ${_start} End: ${_end}"
  }

  def merge(intervals: List[Interval]): List[Interval] = {

    if (intervals.isEmpty)
      return List.empty[Interval]

    val sortedIntervals = intervals.sortBy(_._start) // sorted by start time

    var stack: mutable.Stack[Interval] = new Stack()

    var result: ListBuffer[Interval] = ListBuffer.empty

    sortedIntervals.reverse.foreach(stack.push(_))
    while (stack.size > 1) {
      val pop = stack.pop()
      //println(pop.toString)
      if(stack.top._start <= pop._end) {
        val top = stack.pop()
        stack.push(new Interval(_start = pop.start, _end = Math.max(pop.end, top._end)))
      } else {
        result.append(pop)
      }
    }


    val res= result.+=(stack.pop()).toList // NOTE that append gives UNIT so we are using this .+= method
    println(res.mkString("\n"))
    res
  }


  // [[1,3],[2,6],[8,10],[15,18]]
/*
  merge(
    List(
      new Interval(1, 3),
      new Interval(2, 6),
      new Interval(8, 10),
      new Interval(15, 18)
    )
  )

  merge(
    List(
      new Interval(1, 4),
      new Interval(4, 5)
    )
  )*/


  merge(
    List(
      new Interval(1, 4),
      new Interval(2, 3)
    )
  )


}
