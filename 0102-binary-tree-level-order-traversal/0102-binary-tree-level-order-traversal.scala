/**
 * Definition for a binary tree node.
 * class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
 *   var value: Int = _value
 *   var left: TreeNode = _left
 *   var right: TreeNode = _right
 * }
 */
object Solution {
  def levelOrder(root: TreeNode): List[List[Int]] = {
    val q = collection.mutable.Queue.empty[TreeNode]
    val buf = collection.mutable.ArrayBuffer.empty[List[Int]]

    if (root == null) return Nil
    q.enqueue(root)
    while(q.nonEmpty) {
      val currentElements = q.dequeueAll(_ => true)
      buf += currentElements.map(_.value).toList
      currentElements.foreach { currentEl =>
        
        if (currentEl.left != null) {
          q.enqueue(currentEl.left)
        }
        if (currentEl.right != null) {
          q.enqueue(currentEl.right)
        }
      }
    }

    buf.toList
  }
}