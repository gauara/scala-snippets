package leetcode.medium.tressandgraphs

import scala.collection.mutable.ArrayBuffer

// https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/

object Set230KthSmallestElementBST extends App {

  class TreeNode(var _value: Int) {
    var value: Int = _value
    var left: TreeNode = null
    var right: TreeNode = null

    override def toString: String = value.toString
  }

  def helper(root: TreeNode, arr: ArrayBuffer[Int]): Unit = {
    if (root == null)
      return

    helper(root.left, arr)
    arr.append(root.value)
    helper(root.right, arr)
  }

  def kthSmallest(root: TreeNode, k: Int): Int = {
    val arr = ArrayBuffer.empty[Int]
    helper(root, arr)
    arr(k-1)
  }

}
