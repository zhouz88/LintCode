/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
     public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        int carry = 0;
        while (l1 != null && l2 != null) {
            int total = carry + l1.val + l2.val;
            if (total < 10) {
                p.next = new ListNode(total);
                carry = 0;
            } else {
                p.next = new ListNode(total - 10);
                carry = 1;
            }
            p = p.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int total = carry + l1.val;
            if (total < 10) {
                p.next = new ListNode(total);
                carry = 0;
            } else {
                p.next = new ListNode(total - 10);
                carry = 1;
            }
            p = p.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            int total = carry + l2.val;
            if (total < 10) {
                p.next = new ListNode(total);
                carry = 0;
            } else {
                p.next = new ListNode(total - 10);
                carry = 1;
            }
            p = p.next;
            l2 = l2.next;
        }
        if (carry ==1) {
            p.next = new ListNode(1);
        }
        return dummy.next;
    }
}
