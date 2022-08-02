/**
 * Definition for singly-linked list.
 * class ListNode(_x: Int = 0, _next: ListNode = null) {
 *   var next: ListNode = _next
 *   var x: Int = _x
 * }
 */

object Solution {
    def mergeTwoLists(list1: ListNode, list2: ListNode): ListNode = {
    
    
    if (list1 == null) return list2
    if (list2 == null) return list1
    //println(list1.x, list2.x)
    
    val leftMin = list1.x < list2.x
    ListNode(
      if (leftMin) list1.x else list2.x,
      mergeTwoLists(if (leftMin) list1.next else list2.next, if (!leftMin) list1 else list2)
    )      
      
    }
}