package arraysandstrings


// STATUS - NEED TO COMPLETE WITH BOOK TRICK

/*

NOTE -- Converting Char array to string gives garbage
scala> a.toCharArray
res2: Array[Char] = Array(h, e, l, l, o)

scala> res2.toString
res3: String = [C@f60c14e

USE str.mkString

NOTE -- Char Array converted to string doesnt print, str Array[Char], str is just a name
To print character array, will need to loop through it


 */



object CTC09_StringRotation extends App {

  def rotateByone(str: String): String = {
    val c = str.charAt(0)

    val str1 = str.toCharArray
    for (i <- 0 until(str.length - 1)) {
      str1(i) = str.charAt(i + 1)
    }

    str1(str.length - 1) = c

    str1.mkString
  }

  //println(rotateByone("hello"))



  def isRotation(str1: String, str2: String): Boolean = {
    var prev = str1
    var cur = ""
    for (i <- 0 until(str1.length)) {
      cur = rotateByone(prev)
      prev = cur
      if (cur == str2) return true
    }
    false
  }


  println(isRotation("hello", "elloh"))
  println(isRotation("waterbottle", "erbottlewat"))
  println(isRotation("world", "woldr"))

}
