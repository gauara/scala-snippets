package leetcode.hard.arrayandstrings

import scala.collection.mutable.Stack

object Set227BasicCalculatorII extends App {

  def getDigit(s: String, start: Int): String = {
    var i = start
    var str = new StringBuilder()

    if (s(i) == '-') {
      str.append('-')
      i += 1
    }

    while (i < s.length && s(i) >= 48 && s(i) <= 57) {
      str.append(s(i))
      i += 1
    }
    if (str.isEmpty) "" else str.toString()
  }

  def calculate(s: String): Int = {
    val str = s.replaceAll(" ", "")
    println(s"String: $str")
    var stack = new Stack[Int]()
    var i = 0
    while (i < str.length) {
      if (stack.nonEmpty && str(i) == '*') {
        i += 1
        val d = getDigit(str, i)
        i += d.size
        stack.push(stack.pop() * d.toInt)
      } else if (stack.nonEmpty && str(i) == '/') {
        i += 1
        val d = getDigit(str, i)
        i += d.size
        stack.push(stack.pop() / d.toInt)
      } else {
        val d = getDigit(str, i)
        if (d.nonEmpty) {
          stack.push(d.toInt)
          i += d.size
        } else {
          i += 1
        }
      }
    }

    println(stack.reverse.mkString(","))
    println(s"Size: ${stack.size}")
    println(s"Result: ${stack.reduce(_ + _)}")
    stack.reduce(_ + _)
  }

  //println(getDigit("-35 9", 0))
  calculate("3+2*2")
  calculate(" 3+5 / 2 ")
  calculate(" 3+15 /  -22 ")
  calculate("3*15/9 ")
  calculate(" 3/2 ")
}
