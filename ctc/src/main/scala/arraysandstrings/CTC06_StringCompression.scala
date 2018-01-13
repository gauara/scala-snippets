package arraysandstrings

// STATUS - WORKING

object CTC06_StringCompression extends App {

  // using another string

  def compressedString(str: String): String = {
    var compressed = new StringBuilder()
    var localCount = 0

    // WE JUST KEEP INCREASING THE COUNTER
    // AND CHECK Only WHEN CHARS ARE DIFFERENT
    for (i <- 0 until(str.length)) {
        localCount += 1

      if (i + 1 >= str.length || str.charAt(i + 1) != str.charAt(i)) {
        compressed.append(str.charAt(i)) // its smart because we are adding the last index of repeated character
        compressed.append(localCount.toString)
        localCount = 0
        //println(compressed)
      }
    }

    println("Original String : " + str + " Compressed String: " + compressed)
    if (str.length < compressed.length) str else compressed.toString()
  }

  println("Result : " + compressedString("aaabbbcccdefa"))
  println("Result : " + compressedString("aaaabbbcc"))
  println("Result : " + compressedString("aa"))
  println("Result : " + compressedString("a"))

}

/*
Using StringBuilder -- Note that string builder doubles in capacity
so it might be worth it to check first if compressed string will be smaller as book suggests
 */
