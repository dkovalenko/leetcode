/**
 * Definition for singly-linked list.
 * class ListNode(_x: Int = 0, _next: ListNode = null) {
 *   var next: ListNode = _next
 *   var x: Int = _x
 * }
 */
object Solution {
    def reverseList(head: ListNode): ListNode = {
      var current: ListNode = head
      var prev: ListNode = null
      
      while (current != null) {
        val nextTmp = current.next
        current.next = prev
        prev = current
        current = nextTmp
      }
      prev
    }
}