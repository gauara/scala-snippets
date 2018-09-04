package com.examples

import java.io.{BufferedOutputStream, FileOutputStream}
import java.net.{HttpURLConnection, URL}

import java.io.File
import sys.process._




object ImageFileDownloader extends App {
  val img1 = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQUmye3tm1VNZTpnW9nV8Ci93ue22T-5bINK5ScHSPpcxfq87eTVA"


  def downloadImageToByteArray(imgUrl: String): Array[Byte] = {
    val url = new URL(imgUrl)
    val connection = url.openConnection().asInstanceOf[HttpURLConnection]
    connection.setReadTimeout(5000) // guess its ms
    connection.setConnectTimeout(5000)

    // now get an input stream from the connection
    val in = connection.getInputStream

    val byteArray: Array[Byte] = Stream.continually(in.read) // in.read returns next byte of data, OR
      .takeWhile(_ != -1) // returns -1 when end of the stream is reached
      .map(_.toByte) // convert int to byte
      .toArray // convert Stream to array to materialize it

    println(byteArray.size)

    in.close() // close the input stream
    byteArray
  }

  def downLoadImageToLocalFile(url: String, dstPath: String) = {
    val content = downloadImageToByteArray(url)

    val dstFile = new java.io.File(dstPath)
    val out: BufferedOutputStream = new BufferedOutputStream(new FileOutputStream(dstFile))

    out.write(content)

    out.flush() // MUST DO TO AVOID issues
    out.close() // clean up resources once used
  }


  def downloadImageUsingExecutableCmd(url: String, dstPath: String): Unit = {
    new URL(url) #> new File(dstPath) !!
  }


  downLoadImageToLocalFile(img1, "/tmp/img1")
  downloadImageUsingExecutableCmd(img1, "/tmp/img2")

  // another good example -- https://alvinalexander.com/scala/how-to-read-write-binary-files-in-scala-examples

}
