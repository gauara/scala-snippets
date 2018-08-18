package leetcode.easy.trees

import scala.collection.mutable.ListBuffer

object Set102BinaryTreeLevelOrderTraversal extends App {

  class TreeNode(var _value: Int) {
    var value: Int = _value
    var left: TreeNode = null
    var right: TreeNode = null
  }

  def treeHeight(root: TreeNode): Int = {
    if (root == null)
      return 0

    val lh = treeHeight(root.left)
    val rh = treeHeight(root.right)
    Math.max(lh, rh) + 1
  }

  def levelOrderTraversal(root: TreeNode, l: Int, r: ListBuffer[Int] =  ListBuffer.empty[Int]): ListBuffer[Int] = {

    if (root == null)
      return r

    if (l == 1) {
      r.+=(root.value)
    }
    levelOrderTraversal(root.left, l-1, r)
    levelOrderTraversal(root.right, l-1, r)
    r
  }

  def levelOrder(root: TreeNode): List[List[Int]] = {

    val th = treeHeight(root)
    var res = ListBuffer.empty[List[Int]]

    for(i <- 1 to th) {
      val r = levelOrderTraversal(root, i)
      res.+=(r.toList)
    }
    res.toList
  }
}
