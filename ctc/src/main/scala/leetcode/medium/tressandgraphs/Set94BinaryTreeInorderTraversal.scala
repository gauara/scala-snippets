package leetcode.medium.tressandgraphs

import scala.collection.mutable.ListBuffer

object Set94BinaryTreeInorderTraversal extends App {

  class TreeNode(var _value: Int) {
    var value: Int = _value
    var left: TreeNode = null
    var right: TreeNode = null
  }


  def inorder(root: TreeNode, l: ListBuffer[Int]): Unit = {
    if (root == null)
      return

    inorder(root.left, l)
    l.append(root.value)
    inorder(root.right, l)
  }

  def inorderTraversal(root: TreeNode): List[Int] = {
    val result: ListBuffer[Int] = ListBuffer.empty
    inorder(root, result)
    result.toList
  }
}
