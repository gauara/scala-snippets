package backtracking

object PermutationStringNoDups extends App {

  def permute(str: String, start: Int, end: Int): Unit = {
    if (start == end){
      println(str)
    } else {
      for (i <- start to end) {
        val str1 = swap(str, start, i)
        permute(str1, start + 1, end)
        //swap(str1, start, i)
      }
    }

    def swap(str: String, i: Int, j: Int): String = {
      val charArray = str.toCharArray
      val t = charArray(i)
      charArray(i) = charArray(j)
      charArray(j) = t
      String.valueOf(charArray)
    }
  }
  permute("ABCD", 0, 3)
}
