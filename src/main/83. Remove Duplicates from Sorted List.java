

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        ListNode cur = head;
        ListNode next = head.next;

        while (next != null) {
            if (next.val != cur.val) {
                p = p.next;
                next = next.next;
                cur = cur.next;
            } else {
                while (next.next != null && next.val == next.next.val) {
                    next = next.next;
                }
                cur = next;
                next = next.next;                
                p.next = cur;
            }
        }
        return dummy.next;
    }
}
