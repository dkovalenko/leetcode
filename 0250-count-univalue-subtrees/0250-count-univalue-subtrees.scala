/**
 * Definition for a binary tree node.
 * class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
 *   var value: Int = _value
 *   var left: TreeNode = _left
 *   var right: TreeNode = _right
 * }
 */
object Solution {
  var result = 0
  def countUnivalSubtrees(root: TreeNode): Int = {
    result = 0
    isSubtree(root)
    result
  }
  def isSubtree(node: TreeNode): Boolean = {
    if (node == null) return true
    val leftSubtree = isSubtree(node.left)
    val rightSubtree = isSubtree(node.right)
    if (leftSubtree && rightSubtree) {
      if (node.left != null && node.value != node.left.value) return false
      if (node.right != null && node.value != node.right.value) return false
      result += 1
      return true
    }
    return false
  }
}