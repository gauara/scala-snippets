package leetcode.hard.design


case class TrieNode(
  var children: Array[TrieNode] = new Array[TrieNode](26),
  var endsWord: Boolean = false
) {
  //override def toString: String = endsWord.toString
}

class Trie() {

  private val root: TrieNode = TrieNode()

  def insert(word: String) {
    if (word.isEmpty)
      return

    if (search(word))
      return

    var curr = root
    for(i <- 0 to word.length-1) {
      if (curr.children(word(i)-'a') == null) {
        //println(s"Char <<${word(i)}>> does not exists")
        val node = TrieNode()
        curr.children(word(i)-'a') = node
        curr = node
      } else {
        //println(s"Char <<${word(i)}>> already exists")
        curr = curr.children(word(i)-'a')
      }
    }
    curr.endsWord = true
  }

  def search(word: String): Boolean = {
    var curr = root

    for (i <- 0 to word.length-1) {
      if (curr.children(word(i)-'a') == null) {
        return false
      } else {
        curr = curr.children(word(i)-'a')
      }
    }

    if (curr.endsWord) true else false

  }

  def startsWith(prefix: String): Boolean = {
    var curr = root
    for (i <- 0 to prefix.length-1) {
      if (curr.children(prefix(i)-'a') == null) {
        return false
      } else {
        curr = curr.children(prefix(i)-'a')
      }
    }
    true
  }

}


object Set208Trie extends App {
  var obj = new Trie()

//  obj.insert("the")
//  obj.insert("there")
//  obj.insert("their")

//  println(obj.startsWith("th"))
//  println(obj.search("the"))
//  println(obj.search("their"))
//  println(obj.search("there"))
//
//  println(obj.startsWith("he"))
//  println(obj.search("foo"))
//  println(obj.search("bar"))


  println(obj.insert("abc"))
  println(obj.search("abc"))
  println(obj.search("ab"))
  println(obj.insert("ab"))
  println(obj.search("ab"))
  println(obj.insert("ab"))
  println(obj.search("ab"))

}



