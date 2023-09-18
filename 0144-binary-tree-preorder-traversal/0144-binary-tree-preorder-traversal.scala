/**
 * Definition for a binary tree node.
 * class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
 *   var value: Int = _value
 *   var left: TreeNode = _left
 *   var right: TreeNode = _right
 * }
 */
object Solution {
  def preorderTraversal(root: TreeNode): List[Int] = {
    dfs(root)
  }
  
  def dfs(node: TreeNode): List[Int] = {
    if (node == null) return Nil
    List(node.value) ++ dfs(node.left) ++ dfs(node.right)
  }
}