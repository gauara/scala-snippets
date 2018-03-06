package leetcode.hard.others

import scala.collection.mutable.Stack

// STATUS - ACCEPTED

object Set84LargestRectangleInHistogram extends App {

  def largestRectangleArea(heights: Array[Int]): Int = {

    val stack: Stack[Int] = Stack.empty[Int] // stack to hold all indexes


    var i = 0
    var maxArea = 0

    while (i < heights.length) {
      // push to stack if bar height is higher or equal to top of stack
      if(stack.isEmpty || (stack.size > 0 && heights(stack.top) <= heights(i))) {
        stack.push(i)
        i += 1
      } else { // try popping out until we find a bar which is equal or smaller height

        val top = stack.top // you have to consider the top bar so check top first before you pop
        stack.pop()


        val width = if (stack.isEmpty) {
          i
        } else {
          i - stack.top - 1
        }
        val areaWithTopBar =  heights(top) * width // i - Right - Left

        println(s"First loop maxArea : $maxArea and areaWithTop : $areaWithTopBar")
        maxArea = Math.max(maxArea, areaWithTopBar)
      }
    }

    // check is stack is not empty - e.g all increasing order bars are there in stack
    // we will need to repeat the same process

    while (stack.isEmpty == false) {
      val top = stack.top // you have to consider the top bar so check top first before you pop
      stack.pop()

      val width = if (stack.isEmpty) {
        i
      } else {
        i - stack.top - 1
      }
      val areaWithTopBar =  heights(top) * width // i - Right - Left
      println(s"Second loop maxArea : $maxArea and areaWithTop : $areaWithTopBar")
      maxArea = Math.max(maxArea, areaWithTopBar)
    }

    println(s"Result : $maxArea")
    maxArea
  }

  largestRectangleArea(Array(1))
}
