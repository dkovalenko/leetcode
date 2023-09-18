/**
 * Definition for a binary tree node.
 * class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
 *   var value: Int = _value
 *   var left: TreeNode = _left
 *   var right: TreeNode = _right
 * }
 */
object Solution {
  def inorderTraversal(root: TreeNode): List[Int] = {
    dfs(root)
  }

  def dfs(node: TreeNode): List[Int] = {
    if (node == null) return Nil

    dfs(node.left) ++ List(node.value) ++ dfs(node.right)
  }
}