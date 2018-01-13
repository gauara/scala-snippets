package arraysandstrings


object CTC04_Palindromes extends App {

  // method bit vector
  def isPalindromePermutation(str: String): Boolean = {
    var bitVector = 0

    for (i <- 0 until(str.length)) {
      bitVector = toggleNthBit(bitVector, getCharIndex(str.charAt(i)))
    }
    checkForOneONBit(bitVector)
  }

  // NOTE - you can not have mutable parameters in Scala :))
  // LOGIC TO TOGGLE NTH BIT
  def toggleNthBit(bitVector: Int, index: Int): Int = {
    var mutableBitVector = bitVector
    var result = 0

    val mask = 1 << index
    if ((mutableBitVector & mask) == 0) {
      result = mutableBitVector | mask
    } else {
      result = mutableBitVector & ~mask
    }
    result
  }

  // assuming all small chars
  def getCharIndex(char: Char): Int = {
    val r = char.getNumericValue - 'a'.getNumericValue
    //println(r)
    r
  }

  // LOGIC TO CHECK IF ONLY ONE BIT IS ON
  def checkForOneONBit(bitVector: Int): Boolean = {
    //var mutableBitVector = bitVector
    (bitVector & (bitVector - 1)) == 0
  }

  // for simplicity - only small letter alphabets allowed, a -> z
  println(isPalindromePermutation("tactcoa")) // NO ODD
  println(isPalindromePermutation("tactcob")) // > 1 ODD
  println(isPalindromePermutation("abcd")) // ALL ODD
  println(isPalindromePermutation("abcddcba")) // NO ODD
}
