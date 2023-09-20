/**
 * Definition for a binary tree node.
 * class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
 *   var value: Int = _value
 *   var left: TreeNode = _left
 *   var right: TreeNode = _right
 * }
 */
object Solution {
  def hasPathSum(root: TreeNode, targetSum: Int): Boolean = {
    if (root == null) return false

    val sum = targetSum - root.value
    if (root.left == null && root.right == null) return sum == 0

    hasPathSum(root.left, sum) || hasPathSum(root.right, sum)
  }
  
  
}