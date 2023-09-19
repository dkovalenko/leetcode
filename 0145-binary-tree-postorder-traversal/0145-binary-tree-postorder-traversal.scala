/**
 * Definition for a binary tree node.
 * class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
 *   var value: Int = _value
 *   var left: TreeNode = _left
 *   var right: TreeNode = _right
 * }
 */
object Solution {
  def postorderTraversal(root: TreeNode): List[Int] = {
    root match {
      case null => Nil
      case _ => postorderTraversal(root.left) ++ postorderTraversal(root.right) ++ List(root.value)
    }
  }
}