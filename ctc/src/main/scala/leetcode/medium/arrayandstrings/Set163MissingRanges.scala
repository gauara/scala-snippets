package leetcode.medium.arrayandstrings

import scala.collection.mutable.ListBuffer


// https://leetcode.com/problems/missing-ranges/description/
// Array is given to be SORTED

object Set163MissingRanges extends App {


  def getRange(f: Long, t: Long, fromInclusive: Boolean = false, toInclusive: Boolean = false): String = {

    val from = if (fromInclusive) f-1 else f
    val to = if (toInclusive) t+1 else t
    if (to - from > 1) {
       if (to - from == 2) (from+1).toString
       else (from+1).toString + "->" + (to-1).toString
    } else {
      ""
    }
  }

  def findMissingRanges(nums: Array[Int], lower: Int, upper: Int): List[String] = {
    var result: ListBuffer[String] = ListBuffer.empty
    var lowerIndexNotDone = true

    /*
    if (nums.isEmpty) {
      if (upper-lower > 1) { // if they are not equal
        if (upper-lower > 2) result.append(lower.toString + "->" + upper.toString) // equal but single number missing
        else result.append((lower + 1).toString)
      }
    }*/


    if (nums.isEmpty) {
      if (upper==lower) result.append(lower.toString)
      else result.append(lower.toString + "->" + upper.toString)
    }

    //for(i <- 0 to nums.length-1) {
    var i = 0
    while(i < nums.length) {
      var range = if (i == 0 && lowerIndexNotDone) {
        if (!lowerIndexNotDone) i += 1
        lowerIndexNotDone = false
        getRange(lower, nums(i), true)
      } else if(i == nums.length-1) {
        i += 1
        getRange(nums(nums.length-1), upper, false, true)
      } else {
        val res = getRange(nums(i), nums(i+1))
        i += 1
        res
      }
      if (range.nonEmpty) {
        if (i == 0) result.prepend(range)
        else result.append(range)
      }
    }
    println(s"Given Array: ${nums.mkString(",")} lower: $lower upper: $upper => Missing Ranges are : ${result.mkString(",")}")
    result.toList
  }
/*
  findMissingRanges(Array(0, 1, 3, 50, 75), 0, 99)
  findMissingRanges(Array(1, 3, 50, 75), 0, 99)
  findMissingRanges(Array(1, 1, 1, 1), 1, 1)
  findMissingRanges(Array(1, 1, 1, 1), 0, 1)
  findMissingRanges(Array(1, 1, 1, 1), 1, 2)
  findMissingRanges(Array(1, 1, 1, 1), -1, 1)
  findMissingRanges(Array(1, 1, 1, 1), -1, 2)
  findMissingRanges(Array(1, 1, 1, 1), 0, 2)
  findMissingRanges(Array(1), 0, 2)
  findMissingRanges(Array(), 0, 2)  // missing range is "0->2"
  findMissingRanges(Array(), 0, 1) // 0 -> 1
  findMissingRanges(Array(), 0, 0) // No missing range
  //findMissingRanges(Array(2147483647), 0, 2147483647) // No missing range
  */
  findMissingRanges(Array(2147483647), 0, 2147483647) // No missing range
}



/*

test cases not handled
--
[-1]
-2
-1

---
Input:
[2147483647]
0
2147483647
Output:
[]
Expected:
["0->2147483646"]


// Change to Long in getRange function to avoid those Max/Min Value edge cases

The case Array() // somehow is handled in code but I was not smart enough to think through it



 */