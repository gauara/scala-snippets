package leetcode.medium.bfs

object Set127WordLadder extends App {

  def validate(curWord: String, nextWord: String): Boolean = {
    curWord.diff(nextWord).size == 1
  }
/*
  def wordLadder(curWord: String, endWord: String, wordList: List[String], curLength: Int): (Int, Boolean) = {
    if (curWord == endWord)
      return (curLength, true)


    var i = 0
    var result = (curLength, false)

    while(i < wordList.length) {
      if (validate(curWord, wordList(i))) {
        result = wordLadder(wordList(i), endWord, wordList, curLength + 1)

      }
    }

    (curLength, false)
  }

  def ladderLength(beginWord: String, endWord: String, wordList: List[String]): Int = {
  }
  */

}
