package arraysandstrings

// STATUS - WORKING

object CTC01UniqueCharsInString extends App {

  def isUniqueChars1(str: String): Boolean = {

    // Method 1 - using boolean Array
    val boolArray: Array[Boolean] = new Array(128)

    println("String length " + str.length)
    // until gives kinda range or number of iterations, i is just index doesnt
    //for (i <- 0 until(str.length - 1) ){

    // In scala use "by" for increasing loop for more than 1, that is
    // for (i <- 0 until(str.length) by 2 ){ // increases the loop counter by 2



    for (i <- 0 until str.length){
      //println("i: " + i + " Char: " + str.charAt(i))

      if (boolArray(str.charAt(i)) == true)
        return false
      boolArray(str.charAt(i)) = true
    }
    true
  }

  println(isUniqueChars1("hello"))
  println(isUniqueChars1("abcd"))
  println(isUniqueChars1("abcc"))

}
