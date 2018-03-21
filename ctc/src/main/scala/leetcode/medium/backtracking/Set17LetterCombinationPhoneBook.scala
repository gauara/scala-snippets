package leetcode.medium.backtracking

import scala.collection.mutable._

// ACCEPTED
object Set17LetterCombinationPhoneBook extends App {

  def printPhoneWords(number: Array[Int], curDigit: Int, output: String, keyaPad: Map[Int, String], result: ListBuffer[String]): Unit = {

    // Checking at full length as output needs be filled until last char
    // and when reaches number length we know all rotation at curDigit are completed

    if (curDigit == number.length) {
      result.+=(output)
      return
    } else {
      for(i <- 0 to keyaPad(number(curDigit)).length-1) {

        // NOT ELEGANT AT ALL
        //output.setCharAt(curDigit, keyaPad(number(curDigit))(i))
        val output1 = output + keyaPad(number(curDigit))(i).toString
        printPhoneWords(number, curDigit+1, output1, keyaPad, result)
      }
    }
  }

  def letterCombinations(digits: String): List[String] = {
    if(digits.isEmpty) return List.empty[String]

    var number = digits.toArray.map(_.toString.toInt)
    var result = ListBuffer.empty[String]

    val kepPad = Map(
      0 -> "",
      1 -> "",
      2 -> "abc",
      3 -> "def",
      4 -> "ghi",
      5 -> "jkl",
      6 -> "mno",
      7 -> "pqrs",
      8 -> "tuv",
      9 -> "wxyz"
    )
    printPhoneWords(number, 0, "", kepPad, result)
    result.toList
  }
}