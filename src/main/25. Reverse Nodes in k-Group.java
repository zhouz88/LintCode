/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k <= 1) {
            return head;
        }
        ListNode p = head;
        int i = 1;
        while (i < k) {
            p = p.next;
            if (p == null) {
                return head;
            }
            i++;
        }
        ListNode tmp = p.next;
        p.next = null;
        ListNode newHead = reverse(head);
        head.next = reverseKGroup(tmp, k);
        return newHead;
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
