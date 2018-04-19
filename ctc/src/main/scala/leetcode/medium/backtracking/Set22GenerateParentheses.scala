package leetcode.medium.backtracking

import scala.collection.mutable.{ListBuffer, Stack}


object Set22GenerateParentheses extends App {

  def swap(str: String, i: Int, j: Int): String = {
    val charArray = str.toCharArray
    val t = charArray(i)
    charArray(i) = charArray(j)
    charArray(j) = t
    String.valueOf(charArray)
  }

  def validateParans(str: String): Boolean = {
    val st: Stack[Char] = Stack[Char]()
    for {
      s <- str
    } yield {
      if (st.isEmpty) {
        st.push(s)
      } else if (s == ')') {
        if (st.pop() != '(') return false
      } else {
        st.push(s)
      }
    }
    //println(s"from validate: $str and result ${st.isEmpty}")
    st.isEmpty
  }

  def genParan(result: ListBuffer[String], str: String, start: Int): Unit = {
    if (start == str.length-1) {

      if(validateParans(str)) {
        result.+=:(str)
        //println(str)
      }
      return
    }

    var alreadySeen: ListBuffer[String] = ListBuffer.empty
    for (i <- start to str.length-1) {
      val str1 = swap(str, start, i) // horizontally this will grow
      // OPTIMIZATION - call only if string changed after swap only except when start and i are not same
      val prefix = str.substring(0, start)
      val validPrefix = if (start > 0) prefix.nonEmpty && (prefix.count(_ == '(') - prefix.count(_ == ')') >= 0) else true

      if (validPrefix && !(start != i && str == str1 && alreadySeen.contains(str1))) {
        alreadySeen.append(str1)
        genParan(result, str1, start + 1)
      }
    }
  }

  def generateParenthesis(n: Int): List[String] = {

    val start = System.currentTimeMillis()

    var result: ListBuffer[String] = ListBuffer.empty[String]
    val s: StringBuffer = new StringBuffer()
    for (i <- 0 to n-1) {
      s.append("(")
    }
    for (i <- 0 to n-1) {
      s.append(")")
    }
    genParan(result, s.toString, 0)

    val ret = result.toSet.toList

    println(s"printing result")
    ret.foreach(println)
    val end = System.currentTimeMillis()

    println(s"Time Elapsed: ${end-start}")
    ret
  }

//  validateParans("(())")
//  validateParans("((()")

  //generateParenthesis(2)
  generateParenthesis(8)

}
