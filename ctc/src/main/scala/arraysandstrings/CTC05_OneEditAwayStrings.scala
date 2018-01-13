package arraysandstrings

import scala.math.abs

// STATUS - NOT WORKING

object CTC05_OneEditAwayStrings extends App {

  def isOneEditAway(str1: String, str2: String): Boolean = {

    if (abs(str1.length - str2.length) > 1) return false


    var miss = 0


    for (i <- 0 until(str1.length - 1)) {
      if (str1.charAt(i) != str2.charAt(i)) miss += 1
    }

    if (str1.length == str2.length) miss < 2
    else miss == 0
  }

  println(isOneEditAway("strs", "str"))
  println(isOneEditAway("pale", "bale"))
  println(isOneEditAway("pale", "bake"))
  println(isOneEditAway("pale", "bakeabcs"))
  println(isOneEditAway("Hello", "Mellos"))

}
