package leetcode.medium.tressandgraphs

import javax.swing.tree.TreeNode

object Set105BinaryTreeFromPreorderInorder extends App {


  class TreeNode(var _value: Int) {
    var value: Int = _value
    var left: TreeNode = null
    var right: TreeNode = null

    override def toString: String = value.toString
  }



  def printInOrder(root: TreeNode): Unit = {
    if (root == null)
      return

    printInOrder(root.left)
    print(root.value + " ")
    printInOrder(root.right)
  }


  case class RootAndIndex(value: Int, index: Int)

  def getRootAndIndex(pstart: Int, istart: Int, iend: Int, porder: Array[Int], iorder: Array[Int]): RootAndIndex = {

    if (istart > iend || istart < 0 )
      return null

    var r: RootAndIndex = null

    def getIndex(v: Int): Int = {
      var idx: Int = -1
      for (i <- istart to iend) {
        if (iorder(i) == v)
          idx = i
      }
      //println(s"istart: $istart, iend: $iend, v: $v, idx: $idx")
      idx
    }

    var loop = true

    for (i <- pstart to porder.length - 1 if loop == true) {
      if (loop) {
        val idx = getIndex(porder(i))
        if (idx != -1) {
          r = RootAndIndex(value = porder(i), index = idx)
          loop = false
        }
      }
    }

    //println(s"ps: $pstart, istart: $istart, iend: $iend, r: $r")
    r
  }

  def buildBt(pstart: Int, istart: Int, iend: Int, preorder: Array[Int], inorder: Array[Int]): TreeNode = {

    var root: TreeNode = null
    if (istart > iend || istart >= inorder.length || istart < 0 || iend >= inorder.length || iend < 0)
      return root

    //println(s"istart: $istart, iend: $iend")
    val res = getRootAndIndex(pstart, istart, iend, preorder, inorder )

    if (res != null) {
      val v = res.value
      val l = buildBt(pstart+1, istart, res.index-1, preorder, inorder)
      val r = buildBt(pstart+1, res.index+1, iend, preorder, inorder)

      root = new TreeNode(v)
      root.left = l
      root.right = r

      //println(s"istart: $istart, iend: $iend")
      println(s"Root Value: $v left: ${root.left} right: ${root.right} and index : ${res.index}, istart: $istart, iend: $iend")
    }
    root
  }

  def buildTree(preorder: Array[Int], inorder: Array[Int]): TreeNode = {
    if (preorder.length == 1) {
      return new TreeNode(preorder(0))
    } else {
      val size = preorder.length
      buildBt(0, 0, size-1, preorder, inorder)
    }
  }

  /*
  val r = new TreeNode(3)
  r.left = new TreeNode(9)
  r.right = new TreeNode(20)
  r.right.left = new TreeNode(15)
  r.right.right = new TreeNode(7)
  printInOrder(r)*/


  val root = buildTree(Array(3, 9, 20, 15, 7), Array(9, 3, 15, 20, 7))
  printInOrder(root)
}
