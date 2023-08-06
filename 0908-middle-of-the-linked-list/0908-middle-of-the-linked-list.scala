/**
 * Definition for singly-linked list.
 * class ListNode(_x: Int = 0, _next: ListNode = null) {
 *   var next: ListNode = _next
 *   var x: Int = _x
 * }
 */
object Solution {
    def middleNode(head: ListNode): ListNode = {
        //[1,2,3,4,5]
        var pointerOne = head
        var pointerTwo = head
        if (head.next == null) {
          return head
        }
        var proceed = true

        while (proceed) {
          if (pointerTwo.next == null || pointerTwo.next.next == null) {
            proceed = false
          } else {
            pointerOne = pointerOne.next
            //print(s"One = ${pointerOne.x}")
            pointerTwo = pointerTwo.next.next
            //print(s" Two = ${pointerTwo.x}")
            //println("")
          }
        }
        if (pointerTwo.next == null) {
          pointerOne
        } else {
          pointerOne.next
        }
        
    }
}