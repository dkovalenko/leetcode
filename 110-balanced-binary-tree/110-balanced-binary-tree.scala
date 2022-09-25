/**
 * Definition for a binary tree node.
 * class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
 *   var value: Int = _value
 *   var left: TreeNode = _left
 *   var right: TreeNode = _right
 * }
 */
object Solution {
  def isBalanced(root: TreeNode): Boolean = {
    if (root == null) return true
    
    Math.abs(height(root.left) - height(root.right)) < 2 && 
      isBalanced(root.left) && isBalanced(root.right)
  }
  
  def height(root: TreeNode): Int = {
    if (root == null) return 0
    1 + Math.max(height(root.left), height(root.right))
  }
}