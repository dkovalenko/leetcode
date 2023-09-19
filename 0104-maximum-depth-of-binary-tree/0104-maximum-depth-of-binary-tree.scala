/**
 * Definition for a binary tree node.
 * class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
 *   var value: Int = _value
 *   var left: TreeNode = _left
 *   var right: TreeNode = _right
 * }
 */
object Solution {
  def maxDepth(root: TreeNode): Int = {
    
    def go(node: TreeNode, depth: Int): Int = {
      if (node == null) {
        depth 
      } else {
        Math.max(go(node.left, depth + 1), go(node.right, depth + 1))
      }
    }
    
    go(root, 0)
  }
}