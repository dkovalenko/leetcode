/**
 * Definition for a binary tree node.
 * class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
 *   var value: Int = _value
 *   var left: TreeNode = _left
 *   var right: TreeNode = _right
 * }
 */
import collection.mutable.Queue
import collection.mutable.ArrayBuffer

object Solution {
  def levelOrder(root: TreeNode): List[List[Int]] = {
    if (root == null) return Nil
    val q = Queue.empty[TreeNode]
    val buf = ArrayBuffer.empty[List[Int]]
    q.enqueue(root)
    
    while (q.nonEmpty) {
      val allCurrent = q.dequeueAll(_ => true) //Seq(TN(9),TN(20))
      buf += allCurrent.map(_.value).toList
      allCurrent.foreach { current => 
        if (current.left != null) {
          q.enqueue(current.left)
        }
        if (current.right != null) {
          q.enqueue(current.right)
        }
      }
    }
    buf.toList
  }
}