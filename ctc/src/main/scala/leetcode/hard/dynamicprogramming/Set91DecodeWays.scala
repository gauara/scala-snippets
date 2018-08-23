package leetcode.hard.dynamicprogramming

object Set91DecodeWays extends App {
  val m = ('A' to 'Z').zipWithIndex.map(x => ((x._2 + 1).toString, x._1)).toMap

  def decodeWays(s: String, start: Int): Int = {

    if (start == s.length-1) {
      if (s(start) == '0') return 0 else return 1
    }

    val x = decodeWays(s, start + 1)
    if (start + 2 <= s.length) {
      val substr = s.substring(start, start+2)
      val ret = if (m.contains(substr)) x + 1 else x
      //println(s"SubStr: $substr Ret: $ret")
      ret
    } else {
      x
    }
  }

  def numDecodings(s: String): Int = {
    if (s == "0")
      return 0

    var i = 0
    while (i < s.length && s(i) == '0') {
      i += 1
    }

    decodeWays(s, i)
  }

  //println(numDecodings("12"))
//  println(numDecodings("226"))
//  println(numDecodings("26"))
  println(numDecodings("10"))
  println(numDecodings("0"))
  println(numDecodings("12"))
  println(numDecodings("001"))
  println(numDecodings("02"))
  println(numDecodings("021"))
}
