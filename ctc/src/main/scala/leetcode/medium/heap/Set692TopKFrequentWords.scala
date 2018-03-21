package leetcode.medium.heap

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

object Set692TopKFrequentWords extends App {


  // BUILD COMPARE FOR MAX HEAP ( that is THIS wins over THAT)
  // DO REVERSE TO GET A MIN HEAP

  case class WordToFreq(s: String, f: Int) extends Ordered[WordToFreq] {
    override def compare(that: WordToFreq): Int = {
      //if (this.f == that.f ) that.s.compareTo(this.s)
      //if (this.f == that.f ) that.s.length - this.s.length // THIS has high priority if length of THIS is shorter than THAT
      //if (this.f == that.f ) that.s.charAt(0) - this.s.charAt(0) // THIS has high priority if length of THIS is shorter than THAT
      if (this.f == that.f ) that.s.compareTo(this.s) // THIS has high priority if length of THIS is shorter than THAT
      else this.f - that.f
    }
  }

  def topKFrequent(words: Array[String], k: Int): List[String] = {

    var m: Map[String, Int] = Map.empty
    var l: ListBuffer[String] = mutable.ListBuffer.empty

    for (i <- 0 to words.length-1) {
      val k = words(i)
      if (m.contains(k)) m = m + (k -> (m.get(k).get + 1))
      else m = m + (k -> 1)
    }

    // WE NEED A MIN HEAP
    var minHeap =  mutable.PriorityQueue.empty[WordToFreq].reverse

    for {
      kv <- m
    } yield {
      println(s"$kv")
      minHeap.enqueue(WordToFreq(kv._1, kv._2))
      println(s"minheap size ${minHeap.size}")
      if (minHeap.size > k) // we want to dequeue when size = k + 1, so maintain size = k thereafter
        minHeap.dequeue()
    }

    println(minHeap.mkString)
    while (!minHeap.isEmpty) { // it has only K items
      l.+=:(minHeap.dequeue.s)
    }
    println(s"output: ${l.toString}")
    l.toList
  }

  topKFrequent(Array("i", "love", "leetcode", "i", "love", "coding"), 2)


  // LEETCODE TEST CASE

  val s =       "plpaboutit    ,    jnoqzdute    ,    sfvkdqf    ,    mjc    ,    nkpllqzjzp    ,    " +
    "foqqenbey    ,    ssnanizsav    ,    nkpllqzjzp    ,    sfvkdqf    ,    isnjmy    ,    " +
    "pnqsz    ,    hhqpvvt    ,    fvvdtpnzx    ,    jkqonvenhx    ,    cyxwlef    ,   " +
    " hhqpvvt    ,    fvvdtpnzx    ,    plpaboutit    ,    sfvkdqf    ,    mjc    ,    " +
    "fvvdtpnzx    ,    bwumsj    ,    foqqenbey    ,    isnjmy    ,    nkpllqzjzp    ,    " +
    "hhqpvvt    ,    foqqenbey    ,    fvvdtpnzx    ,    bwumsj    ,    hhqpvvt    ,    " +
    "fvvdtpnzx    ,    jkqonvenhx    ,    jnoqzdute    ,    foqqenbey    ,    jnoqzdute    ,    " +
    "foqqenbey    ,    hhqpvvt    ,    ssnanizsav    ,    mjc    ,    foqqenbey    ,    bwumsj    ,    " +
    "ssnanizsav    ,    fvvdtpnzx    ,    nkpllqzjzp    ,    jkqonvenhx    ,    hhqpvvt    ,    mjc    ,    " +
    "isnjmy    ,    bwumsj    ,    pnqsz    ,    hhqpvvt    ,    nkpllqzjzp    ,    jnoqzdute    ,    " +
    "pnqsz    ,    nkpllqzjzp    ,    jnoqzdute    ,    foqqenbey    ,    nkpllqzjzp    ,    " +
    "hhqpvvt    ,    fvvdtpnzx    ,    plpaboutit    ,    jnoqzdute    ,    sfvkdqf    ,    " +
    "fvvdtpnzx    ,    jkqonvenhx    ,    jnoqzdute    ,    nkpllqzjzp    ,    jnoqzdute    ,    " +
    "fvvdtpnzx    ,    jkqonvenhx    ,    hhqpvvt    ,    isnjmy    ,    jkqonvenhx    ,    " +
    "ssnanizsav    ,    jnoqzdute    ,    jkqonvenhx    ,    fvvdtpnzx    ,    hhqpvvt    ,    " +
    "bwumsj    ,    nkpllqzjzp    ,    bwumsj    ,    jkqonvenhx    ,    jnoqzdute    ,    " +
    "pnqsz    ,    foqqenbey    ,    sfvkdqf    ,    sfvkdqf  "


  //println(s.split(",").map(_.trim).mkString)
  topKFrequent(s.split(",").map(_.trim), 3)

}
