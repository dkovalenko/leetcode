import scala.collection.mutable._
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
    val bufRecur = collection.mutable.Map.empty[Int, ListBuffer[Int]]

    // if (root == null) return Nil
    // q.enqueue(root)
    // while(q.nonEmpty) {
    //   val currentElements = q.dequeueAll(_ => true)
    //   buf += currentElements.map(_.value).toList
    //   currentElements.foreach { currentEl =>
        
    //     if (currentEl.left != null) {
    //       q.enqueue(currentEl.left)
    //     }
    //     if (currentEl.right != null) {
    //       q.enqueue(currentEl.right)
    //     }
    //   }
    // }
    def levelOrderRecur(node: TreeNode, level: Int): Unit = {
      if (node == null) return ()
      bufRecur.get(level) match {
        case Some(lb) => lb += node.value
        case None => bufRecur.put(level, ListBuffer(node.value))
      } 
      if (node.left != null) {
        levelOrderRecur(node.left, level + 1)
      }
      if (node.right != null) {
        levelOrderRecur(node.right, level + 1)
      }
    }
    levelOrderRecur(root, 0)

    bufRecur.values.map(_.toList).toList
    // buf.toList
  }

  
}