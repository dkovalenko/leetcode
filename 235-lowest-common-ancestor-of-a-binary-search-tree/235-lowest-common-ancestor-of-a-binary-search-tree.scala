/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */

import scala.collection.mutable.ListBuffer

object Solution {
  def lowestCommonAncestor(root: TreeNode, p: TreeNode, q: TreeNode): TreeNode = {
    // 6 2 4
    // 6 2
    val first = getPath(root, p.value, ListBuffer.empty[TreeNode])
    val second = getPath(root, q.value, ListBuffer.empty[TreeNode])
    
    first.intersect(second).head
  }
  def getPath(root: TreeNode, find: Int, set: ListBuffer[TreeNode]): ListBuffer[TreeNode] = {
    set.prepend(root)
    if (root.value == find) {
      return set
    } else {
      if (find < root.value) getPath(root.left, find, set) else getPath(root.right, find, set)
    }
  }
}