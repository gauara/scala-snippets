package leetcode.hard.treesandgraphs

// https://leetcode.com/problems/inorder-successor-in-bst/description/
// https://algorithms.tutorialhorizon.com/inorder-successor-in-binary-tree/

object Set285GeneralInOrderBinaryTreeSuccessor extends App {

  case class TreeNode(v: Int) {
    var left: TreeNode = null
    var right: TreeNode = null
  }


  def printInOrder(root: TreeNode): Unit = {
    if (root == null)
      return

    printInOrder(root.left)
    print(root.v + " ")
    printInOrder(root.right)
  }

  case class NodeWrapper(var found: Boolean = false) {
    var node: TreeNode = null
  }

  def findMinInTree(root: TreeNode): TreeNode = {
    var curr = root
    while (curr != null && curr.left != null) {
      curr = curr.left
    }
    curr
  }

  def inorderHelper(root: TreeNode, x: TreeNode, res: NodeWrapper): TreeNode = {
    // each node keep returning itself to its parent
    //println(root.v)
    if (root == null)
      return null

    lazy val n1: TreeNode = inorderHelper(root.left, x, res)
    lazy val n2: TreeNode = inorderHelper(root.right, x, res)

    lazy val temp: TreeNode = if (n1 != null) n1 else n2

    if (root == x || temp != null) {

      if (temp != null) { // if temp != null it also means root != x
        if (temp == root.left && res.found == false) {
          res.found = true
          res.node = root
        }
      }
      return root
    }
    return null
  }

  def inorder(root: TreeNode, x: TreeNode): TreeNode = {
    val r: NodeWrapper = NodeWrapper()

    if (x != null)
      println(s"To Find In Order successor of node: ${x.v}")

    if (x.right != null) {
      r.node = findMinInTree(x.right)
    } else {
      inorderHelper(root, x, r)
    }
    r.node
  }

  var root: TreeNode = TreeNode(1)
  var l1: TreeNode =  TreeNode(2)
  var l2: TreeNode =  TreeNode(3)
  root.left = l1
  root.right = l2

  l1.left = TreeNode(4)
  l1.right = TreeNode(5)
  l2.right = TreeNode(6)


  printInOrder(root)

  println("")
  println(inorder(root, root.right))
  println(inorder(root, root.left.left))
  println(inorder(root, root.left.right))
}
