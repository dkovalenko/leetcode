import collection.mutable._
/**
 * Definition for a binary tree node.
 * class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
 *   var value: Int = _value
 *   var left: TreeNode = _left
 *   var right: TreeNode = _right
 * }
 */
object Solution {
  val stack = Stack.empty[TreeNode]
  
  def preorderTraversal(root: TreeNode): List[Int] = {
    //dfs(root)
    val result = ListBuffer.empty[Int]
    stack.push(root)
    iterative(result)
    result.toList
  }
  
  def dfs(node: TreeNode): List[Int] = {
    if (node == null) return Nil
    List(node.value) ++ dfs(node.left) ++ dfs(node.right)
  }
  
  def iterative(result: ListBuffer[Int]): Unit = {
    while (stack.nonEmpty) {
      var currentNode = stack.pop
      if (currentNode != null) {
        result += currentNode.value
        stack.push(currentNode.right)
        stack.push(currentNode.left)
      }
    }
    ()
  }
}