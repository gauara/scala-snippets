package ctc.moderate

object PrintPhoneDigits extends App {


  //def printPhoneWords(number: Array[Int], curDigit: Int, output: StringBuffer, keyaPad: Map[Int, String]): Unit = {
  def printPhoneWords(number: Array[Int], curDigit: Int, output: String, keyaPad: Map[Int, String]): Unit = {

    // Checking at full length as output needs be filled until last char
    // and when reaches number length we know all rotation at curDigit are completed

    if (curDigit == number.length) {
      println(output)
      return
//    } else if(number(curDigit) == 0 || number(curDigit) == 1) {
//      // DO NOTHING
//      printPhoneWords(number, curDigit+1, output1, keyaPad)
    } else {
      for(i <- 0 to keyaPad(number(curDigit)).length-1) {

        // NOT ELEGANT AT ALL
        //output.setCharAt(curDigit, keyaPad(number(curDigit))(i))
        val output1 = output + keyaPad(number(curDigit))(i).toString
        printPhoneWords(number, curDigit+1, output1, keyaPad)
        //return
      }
    }
  }

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

  //val number = Array(2, 3, 4)
  val number = Array(5, 4, 0)
  //printPhoneWords(number, 0, new StringBuffer(number.length+1), kepPad)
  var output = new StringBuffer()
  output.setLength(number.length) // if you DONT setLength -- setChatAt will throw exception
  printPhoneWords(number, 0, "", kepPad)
}
