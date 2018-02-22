/**
 * Definition for singly-linked list.

 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        //edge case
        if (head == null || head.next == null) {
            return head;
        }
        
        //general
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        ListNode first = p.next;
        ListNode second = first.next;
        ListNode next = second.next;
        
        while (true) {
            p.next = second;
            second.next = first;
            first.next = next;
            
            p = first;
            first = next;
            
            if (first == null || first.next == null) {
                break;
            } else {
                second = first.next;
                next = second.next;
            }
        }
        
        return dummy.next;
    }
}
