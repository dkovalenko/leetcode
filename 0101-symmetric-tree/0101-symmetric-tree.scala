/**
 * Definition for a binary tree node.
 * class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
 *   var value: Int = _value
 *   var left: TreeNode = _left
 *   var right: TreeNode = _right
 * }
 */
object Solution {
  def isSymmetric(root: TreeNode): Boolean = {
       isMirror(root, root)
  }
  def isMirror(left: TreeNode, right: TreeNode): Boolean = {
    if (left == null && right == null) return true
    if (left == null || right == null) return false
    left.value == right.value && isMirror(left.right, right.left) && isMirror(left.left, right.right)
  }
}