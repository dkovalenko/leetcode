/**
 * Definition for singly-linked list.
 * class ListNode(var _x: Int = 0) {
 *   var next: ListNode = null
 *   var x: Int = _x
 * }
 */

object Solution {
  def hasCycle(head: ListNode): Boolean = {
    if (head == null) return false
    if (head.x == Int.MinValue) return true
    head.x = Int.MinValue
    hasCycle(head.next)
  }
}