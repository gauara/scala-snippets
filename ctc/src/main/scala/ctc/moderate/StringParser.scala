package ctc.moderate

object StringParser extends App {

  def stringParser(str: String): Int = {
    try {
      val result = str.toInt
      println(result)
      result
    } catch {
      case _ : Exception => {
        println("error")
        -1
      }
    }
  }
  stringParser("123")
  stringParser("415")
  stringParser("123h")
}
