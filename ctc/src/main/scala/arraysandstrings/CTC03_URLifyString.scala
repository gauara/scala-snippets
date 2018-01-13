package arraysandstrings

// STATUS - WORKING

object CTC03_URLifyString extends App {

  val str1 = "Mr Joey Smith"

  def urlify(str: Array[Char], trueLength: Int): Unit = {
    val totalLength = str.length

    val str2: Array[Char] = new Array[Char](totalLength + 20)

    // fill it with non garbage
    for (i <- 0 until str2.length)
      str2(i) = '='

    var next: Int = 0
    for (i <- 0 until str.length) {
      if (str.charAt(i) == ' ') {

        str2(next) = '%'
        println(str2.charAt(next))
        next += 1

        str2(next) = '2'
        println(str2.charAt(next))
        next += 1

        str2(next) = '0'
        println(str2.charAt(next))
        next += 1


      } else {
        str2(next) = str.charAt(i)
        next = next + 1
      }
    }
    println("printing string")
    str2.foreach(print)
  }

  urlify("Mr Joe Smith".toCharArray, "Mr Joe Smith".length)

}
