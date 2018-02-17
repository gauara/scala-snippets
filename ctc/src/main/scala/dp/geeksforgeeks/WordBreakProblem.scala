package dp.geeksforgeeks

object WordBreakProblem extends App {

  // DONT THINK THIS CASE IS ALLOWED WHEN ONE WORD CAN BE PREFIX OF OTHER - e.g "a" "am" here
  //val dict: Set[String] = Set("i", "a", "am", "happy")
  val dict: Set[String] = Set("i", "am", "happy")

  def inDict(s: String): Boolean = {
    dict.contains(s) || s == ""
  }

  def wordBreak(s: String): Boolean = {
    if (s.isEmpty) // THIS IS THE BASE CASE
      return true

    val size = s.length
    var result = false

    println("String: " + s)
    for(i <- 1 to size) { // CAREFULLY NOTE THE SIZE HERE, its inclusive of size, perhaps for the substring reason
      val substr = s.substring(0, i)
      val isPresent = inDict(substr)
      println("Sub String: " + substr)
      println("is Present: " + isPresent)

      if(isPresent) {
        result = wordBreak(s.substring(i, size))
        return result
      } else{
        false
      }
    }

    result
  }



  def wordBreak1(s: String): Boolean = {
    if (s.isEmpty)
      return true

    val size = s.length

    println("String: " + s)
    for(i <- 1 to size) {
      val substr = s.substring(0, i)
      val isPresent = inDict(substr)
      println("Sub String: " + substr)
      println("is Present: " + isPresent)

      if (isPresent && wordBreak(s.substring(i, size-i)))
        return true
    }
    return false
  }


  def wordBreak2(s: String): Boolean = {
    if (s.isEmpty) // THIS IS THE BASE CASE
      return true

    val size = s.length
    var result = false

    println("String: " + s)
    for(i <- 1 to size) { // CAREFULLY NOTE THE SIZE HERE, its inclusive of size, perhaps for the substring reason
      val (substr, rest) = s.splitAt(i)
      val isPresent = inDict(substr)
      println("Sub String: " + substr)
      println("is Present: " + isPresent)

      if(isPresent) {
        result = wordBreak(rest)
        return result
      } else{
        false
      }
    }

    result
  }





  println("****************** Appraoch 1 ******************")
  println(wordBreak("iamhappy"))

  println("************************************************")
  println("****************** Appraoch 2 ******************")

  println(wordBreak1("iamhappy"))

  println("****************** Appraoch 3 ******************")
  println(wordBreak2("iamhappy"))


}
