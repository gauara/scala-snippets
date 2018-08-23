package leetcode.medium.sortingandsearching

object Set253MeetingRoomsII extends App {
  class Interval(var _start: Int = 0, var _end: Int = 0) {
   var start: Int = _start
   var end: Int = _end
   }

  def minMeetingRooms(intervals: Array[Interval]): Int = {

    val starts: Array[Int] = intervals.map(_._start).sorted // sorted
    val ends: Array[Int] = intervals.map(_._end).sorted // sorted

    var i = 0
    var j = 0
    var rooms = 0

    while (i < intervals.length && j < intervals.length) {
      if (starts(i) < ends(j)) {
        rooms += 1
        i += 1
      } else {
        // some job was already done before this incoming job started
        rooms -= 1
        j += 1
      }
    }

    println(s"Roome required : $rooms")
    rooms
  }


  // [0, 30],[5, 10],[15, 20]
  minMeetingRooms(
    Array(
      new Interval(0, 30),
      new Interval(5, 10),
      new Interval(15, 20)
    )
  )

  minMeetingRooms(
    Array(
      new Interval(7, 10),
      new Interval(2, 4)
    )
  )




}
