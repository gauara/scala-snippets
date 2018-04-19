package leetcode.hard.arrayandstrings

object Set224BasicCalculator extends App {

  def getOperand(s: String, start: Int): String = {
    var i = start
    while (i < s.length && s(i) != ' ' && s(i) != '(' && s(i) != ')' && s(i) != '+' && s(i) != '-') {
      i += 1
    }
    if ( i == start) s.substring(start, i+1) else s.substring(start, i)
  }


  def calculate(s: String): Int = {
    if(s.isEmpty)
      return 0 // question says it will always be valid

    var next: Int = 1
    var result = 0

    //for (i <- 0 to s.length-1) {
    var i = 0
    while(i < s.length) {
      println(s"hello : i : $i s(i): ${s(i)}")
      if (s(i) != ' ' && s(i) != '(' && s(i) != ')') {
        if (s(i) == '+') {
          next = 1
          i += 1
        } else if (s(i) == '-') {
          next *= -1
          i += 1
        } else {
          //println(s"i: $i s(i) == ${s(i)}")


          //val digit = s(i).toString.toInt * next
          val operand = getOperand(s, i)
          val digit = operand.toString.toInt * next
          println(s"c: ${s(i)}  next: $next digit: $digit operand: '$operand'")
          result += digit
          i += operand.length
        }
      } else {
        i += 1
      }
    }
    println(s"Result for s: $s is: $result")
    result
  }


  //calculate("1 + 1")
  //calculate(" 2-1 + 2 ")
  //calculate("(1+(4+5+2)-3)+(6+8)")
  //calculate("(10+(4+5+2)-3)+(6+8)")
  //calculate("(10+(4+5+2)-30)+(6+8)")
  calculate("(5-(1+(5)))")
}
