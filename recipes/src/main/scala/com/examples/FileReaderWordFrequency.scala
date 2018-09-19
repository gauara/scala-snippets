package com.examples

import scala.io.Source

object FileReaderWordFrequency extends App {
  //var wordMap = scala.collection.mutable.Map.empty[String, Int]
  var wordMap1 = scala.collection.mutable.SortedMap.empty[String, Int]
  var lhm = scala.collection.mutable.Map.empty[String, Int]

  val lines = Source.fromFile("/tmp/words.txt").getLines
  println(s"lines : $lines")

  for (line <- lines) {
    for (word <- line.split(" ")) {
      println(word)
      //wordMap.put(word, wordMap.getOrElse(word, 0) + 1)
      wordMap1.put(word, wordMap1.getOrElse(word, 0) + 1)
    }
  }

  for (elem <- wordMap1) {
    println(elem._1 + " " + elem._2)
  }
}
