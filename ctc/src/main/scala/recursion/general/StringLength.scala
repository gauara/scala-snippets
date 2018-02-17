package recursion.general

object StringLength extends App {
  def length(str: String): Int = {
    if (str.isEmpty)
      return 0
    else {
      1 + length(str.splitAt(1)._2)
    }
  }

  println(length("hello"))
  println(length("abc"))

  println(length("helloworld"))
}
