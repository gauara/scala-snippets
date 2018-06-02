package leetcode.hard.treesandgraphs

import scala.collection.mutable
import scala.collection.mutable.ListBuffer
import scala.collection.mutable.Set

// https://leetcode.com/problems/word-ladder/description/

object Set127WordLadder extends App {

  def getAllValidCombinations(w: String, visited: Set[String], wordList: scala.collection.immutable.Set[String]): ListBuffer[String] = {

    val validWords: ListBuffer[String] = ListBuffer.empty[String]

    for (i <- 0 to w.length-1) {
      val word = w.toCharArray
      for (c <- 'a' to 'z') { // a to z
        //val word: String = (w.substring(0, i) + j.toChar.toString + w.substring(i+1, w.length)).trim
        word(i) = c
        val w2s = word.mkString

        if (w2s == "hot") {
        }
        val validWord = !visited.contains(w2s) && wordList.contains(w2s) && w2s != w
        if (validWord) {
          validWords.append(w2s)
        }
      }
    }
    validWords
  }

  def ladderLength(beginWord: String, endWord: String, wordList: List[String]): Int = {
    case class Item(w: String, level: Int)
    val wordListSet: scala.collection.immutable.Set[String] = wordList.toSet

    val queue: mutable.Queue[Item] = mutable.Queue.empty[Item]

    val visited: Set[String] = mutable.Set.empty[String]
    queue.enqueue(Item(beginWord, 1))
    visited.+=(beginWord)

    while (queue.nonEmpty) {
      val w = queue.dequeue()

      if (w.w == endWord) {
        return w.level
      }

      visited.+=(w.w)
      val list = getAllValidCombinations(w.w, visited, wordListSet)
      list.foreach { i =>
        queue.enqueue(Item(i, w.level+1))
      }
    }
    0
  }
}
