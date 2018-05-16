package leetcode.medium.tressandgraphs

import scala.collection.mutable.ListBuffer

object Set103BinaryTreeZigzagLevelOrderTraversal extends App {

  class TreeNode(var _value: Int) {
    var value: Int = _value
    var left: TreeNode = null
    var right: TreeNode = null
  }

  def getHeight(root: TreeNode): Int = {
    if (root == null)
      return 0

    val lh = getHeight(root.left)
    val rh = getHeight(root.right)

    return Math.max(lh, rh) + 1
  }

  def getLevel(root: TreeNode, level: Int, l: ListBuffer[Int]): Unit = {
    if (root == null)
      return

    if (level == 1)
      l.append(root.value)

    getLevel(root.left, level-1, l)
    getLevel(root.right, level-1, l)
  }

  def zigzagLevelOrder(root: TreeNode): List[List[Int]] = {
    val result: ListBuffer[List[Int]] = ListBuffer.empty

    if (root == null)
      result.toList

    val height = getHeight(root)

    for (i <- 1 to height) {
      val l = ListBuffer.empty[Int]
      getLevel(root, i, l)
      if (i %2 == 1) result.append(l.toList) else result.append(l.reverse.toList)
    }
    result.toList
  }
}
