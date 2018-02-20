/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
         ListNode p = head;
         while (n != 0) {
             p = p.next;
             n--;
         }
         if (p == null) {
             return head.next;
         }
         ListNode q = head;
         while (p.next != null) {
             q = q.next;
             p = p.next;
         }
         q.next = q.next.next;
         return head;
    }
}
