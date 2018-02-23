/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null ) {
            return head;
        }
        
        ListNode dummy1 = new ListNode(0);
        ListNode dummy2 = new ListNode(0);
        
        ListNode p = dummy1, q = dummy2;
        
        while (head != null) {
            if (head.val < x) {
                p.next = head;
                p = p.next;
            } else {
                q.next = head;
                q = q.next;
            }
            ListNode tmp = head.next;
            head.next = null;
            head = tmp;
        }
        p.next = dummy2.next;
        return dummy1.next;
    }

  //    public class ListNode {
  //    int val;
  //     ListNode next;
  //     ListNode(int x) { val = x; }
  // }
}
