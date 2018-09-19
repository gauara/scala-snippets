package com.examples

import scala.collection.mutable.ListBuffer
import scala.io.StdIn

object StdInConsoleReader extends App {
  println("App Started, input something")
  val inputs = ListBuffer.empty[String]

  do {
    val input = StdIn.readLine().trim()
    inputs.append(input)
    println(s"Input: $input ")
  } while (inputs.last != "quit")

  println(inputs)
}
