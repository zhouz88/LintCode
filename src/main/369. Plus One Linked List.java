import java.awt.*;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode plusOne(ListNode head) {
         head = reverse(head);
         ListNode p = head;
         while (p != null) {
             p.val ++;
             if (p.val > 9) {
                 p.val = 0;
             } else {
                 break;
             }
             p = p.next;
         }
         if (p == null) {
             head = reverse(head);
             ListNode newHead = new ListNode(1);
             newHead.next = head;
             return newHead;
         } else {
             head = reverse(head);
             return head;
         }
    }
    
    private ListNode reverse(ListNode head) {
        ListNode cur = head, pre = null;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }
}
