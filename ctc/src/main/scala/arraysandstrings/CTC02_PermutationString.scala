package arraysandstrings

// STATUS - WORKING

// Method 1 - Sort strings and compare if they are equal
// Method 2 - Count the number of the characters in each string and if they are same it means they are
//              permutation of each other

object CTC02_PermutationString extends App {

  def areStringsPermutation1(str1: String, str2: String): Boolean = {
    val arr1: Array[Int] = new Array(128)
    val arr2: Array[Int] = new Array(128)

    str1.foreach(c => arr1(c) = arr1(c) + 1)
    str2.foreach(c => arr2(c) = arr2(c) + 1)

    for (i <- 0 until 128) {
      if (arr1(i) !=  arr2(i))
        return false
    }
    true
  }

  println("Checking for the permutations of the same string")
  println(areStringsPermutation1("hello", "hello2"))
  println(areStringsPermutation1("abcdef", "fedbca"))
  println(areStringsPermutation1("abcdef", "fedbca     "))
}


// Notes -- the boolean array is by default set to false