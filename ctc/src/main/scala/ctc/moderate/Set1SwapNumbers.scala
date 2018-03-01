package ctc.moderate

object Set1SwapNumbers extends App {
  def swapNumbers(a1: Int, b1: Int) = {

    println(s"a: $a1  b : $b1")

    var a = a1
    var b = b1
    a = a + b
    b = a - b
    a = a - b

    println(s"After swap a: $a  b: $b")

  }

  swapNumbers(4, 5)

  def swapNumbersBitMethod(a1: Int, b1: Int) = {
    println(s"Bit method, a: $a1  b : $b1")

    var a = a1
    var b = b1
    a = a ^ b
    b = a ^ b
    a = a ^ b

    println(s"After swap a: $a  b: $b")
  }
  swapNumbersBitMethod(6, 10)
}
