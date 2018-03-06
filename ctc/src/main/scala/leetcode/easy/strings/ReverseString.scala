package leetcode.easy.strings

// NOTE - scala strings are immutable

// NOTE - s = "hello", s(0) = 'b' will throw error

object ReverseString extends App {
  def reverseString(s: String): String = {
    val arr = s.toArray
    var i: Int = 0
    var j: Int = arr.length - 1

    while (i < j) {
      val temp = arr(i)
      arr(i) = arr(j)
      arr(j) = temp
      i += 1
      j -= 1
    }
    arr.mkString
  }

  def reverseStringWithoutArray(s: String): String = {
    val b = new StringBuilder()
    b.append(s)

    var i: Int = 0
    var j: Int = s.length - 1

    while (i < j) {
      val temp = b(i)
      b(i) = b(j)
      b(j) = temp
      i += 1
      j -= 1
    }
    b.mkString
  }
  println(reverseStringWithoutArray("hello"))

}
