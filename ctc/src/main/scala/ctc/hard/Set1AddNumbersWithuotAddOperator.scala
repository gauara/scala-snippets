package ctc.hard

object Set1AddNumbersWithuotAddOperator extends App {
  def addNumbers(a: Int, b: Int): Int = {

    println(s" a: $a (${a.toBinaryString}) b: $b (${b.toBinaryString})")

    if (b == 0) return a
    val sum = a ^ b
    val carry = (a & b) << 1


     println(s"Sum: $sum (${sum.toBinaryString}) Carry: $carry (${carry.toBinaryString})")
    addNumbers(sum, carry)
  }

  println(s"Addition of numbers: ${addNumbers(5, 4)}")
  println("************************************************")
  println(s"Addition of numbers: ${addNumbers(5, 0)}")
  println("************************************************")
  println(s"Addition of numbers: ${addNumbers(0, 4)}")
  println("************************************************")
  println(s"Addition of numbers: ${addNumbers(26, 12)}")



}
