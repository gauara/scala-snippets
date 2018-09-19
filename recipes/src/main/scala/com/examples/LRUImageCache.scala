package com.examples

import java.net.URL
import java.net.HttpURLConnection

object LRUImageCache extends App {
  case class CacheItem(
                        imgUrl: String,
                        imgContent: Array[Byte],
                        imgSize: Int
                      )

  case class LRUCache(capacity: Int) {
    var cache = scala.collection.mutable.LinkedHashMap.empty[String, CacheItem]

    def size = cache.values.map(_.imgSize).sum

    private def buildResponse(url: String, method: String, size: Int) = Array(url, method, size.toString).mkString(" ")

    private def downLoadImage(url: String): Array[Byte] = {
      import scala.io.Source
      //      val x = Source.fromURL(url)
      //      val y = Stream.continually(x.reader.read)
      //      val z = y.takeWhile(_ != -1)
      //        .map(_.toByte).toArray


      val urL = new URL(url)
      val connection = urL.openConnection().asInstanceOf[HttpURLConnection]
      connection.setReadTimeout(5000) // guess its ms
      connection.setConnectTimeout(5000)

      val in = connection.getInputStream
      val b = Stream.continually(in.read)
      val c = b.takeWhile(_ != -1)
        .map(_.toByte)
        .toArray
      //assert(z == c)
      c
    }

    def purge(size: Int): Unit = {
      var spaceCreated = 0
      while (spaceCreated < size) {
        val n = cache.iterator.next
        spaceCreated += n._2.imgSize
        cache.remove(n._1)
      }
    }

    def get(url: String): String = {

      if (cache.contains(url)) {
        val item = cache(url)
        cache.remove(url)
        cache.put(url, item)
        buildResponse(url, "CACHED", cache(url).imgSize)
      } else {
        // download and buffer image
        // calculate image size
        // make space for image if no space - LRU

        val imageContent = downLoadImage(url)
        val imgSize = imageContent.size
        if (imgSize > capacity)
          return "TOO BIG TO CACHE"

        if (size + imgSize >= capacity) {
          purge(imgSize)
          cache.put(url, CacheItem(imgUrl = url, imgContent = imageContent, imgSize = imgSize))
        } else {
          //save image to cache
          cache.put(url, CacheItem(imgUrl = url, imgContent = imageContent, imgSize = imgSize))
        }
        buildResponse(url, "DOWNLOADED", cache(url).imgSize)
      }
    }

  }
}
