/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
         ListNode dummy = new ListNode(0);
         if (head == null) {
             return head;
         }
         ListNode tmp = head;
         int l = 0;
         while (tmp != null) {
             l++;
             tmp = tmp.next;
         }
         k = k%l;
        if (k == 0) {
             return head;
        }
         ListNode p = dummy , pre = dummy;
         dummy.next = head;
         while (k != 0) {
             p = p.next;
             k--;
         }
         while (p.next != null) {
             p = p.next;
             pre = pre.next;
         }
         head = pre.next;
         pre.next = null;
         p.next = dummy.next;
         return head;
    }
}
