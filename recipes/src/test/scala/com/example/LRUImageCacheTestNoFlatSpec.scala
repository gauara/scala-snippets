package com.example

import com.examples.LRUImageCache

import scala.collection.mutable.ListBuffer
import scala.io.StdIn

object LRUImageCacheTestNoFlatSpec extends App {
  println("Enter Cache Bytes size")
  val bytes = StdIn.readLine().toInt

  println("Enter Number of URLs")
  val n = StdIn.readLine().toInt

  val urls = ListBuffer.empty[String]

  var count = 0

  do {
    val u = StdIn.readLine()
    urls.append(u)
    count += 1
  } while (count < n)

  val cache = LRUImageCache.LRUCache(bytes)

  urls.foreach { u =>
    println(s"Url : $u")
    val res = cache.get(u)
    println(res)
  }
}
