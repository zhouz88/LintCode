/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        if (m == n) {
            return head; //wrong 1
        }
        ListNode p = dummy;
        ListNode q = dummy;
        m--;
        while (m != 0) {
            p = p.next;
            q = q.next;
            m--;
            n--;
        }
        while (n != 0) {
            q = q.next;
            n--;
        }
        ListNode tmp1 = p.next;
        p.next = null;
        ListNode tmp2 = q.next;
        q.next = null;
        
        p.next = reverse(tmp1);
        tmp1.next = tmp2;
        return dummy.next;
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
    
//      public class ListNode {
//       int val;
//       ListNode next;
//       ListNode(int x) { val = x; }
//    }
}
