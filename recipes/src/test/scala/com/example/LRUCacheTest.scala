package com.example

import scala.io.StdIn
import org.scalatest.{FlatSpec, Matchers}
import scala.collection.mutable.ListBuffer

import com.examples.LRUImageCache

class LRUCacheTest extends FlatSpec with Matchers {
  it should "test the lru image cache" in {

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
}
