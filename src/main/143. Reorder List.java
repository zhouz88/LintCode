import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next!= null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode q = slow.next, p = head;
        slow.next = null;
        q = reverse(q);
        ListNode dummy = new ListNode(0);
        ListNode i = dummy;
        int cnt = 0;
        while (q != null && p != null) {
            if (cnt % 2 == 0) {
                i.next = p;
                p = p.next;
                i = i.next;
                i.next = null;
            } else {
                i.next = q;
                q = q.next;
                i = i.next;
                i.next= null;
            }
            cnt++;
        }
        if (q != null) {
            i.next = q;
        }
        if (p != null) {//care
            i.next = p;
        }
        head = dummy.next;
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null , cur = head;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }
}
