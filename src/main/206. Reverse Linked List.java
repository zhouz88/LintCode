/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
       public ListNode reverseList(ListNode head) {
        // ListNode pre = null, cur = head;
        // while (cur != null) {
        //     ListNode tmp = cur.next;
        //     cur.next = pre;
        //     pre = cur;
        //     cur = tmp;
        // }
        // return pre;
           if (head == null || head.next == null) {
               return head;
           }
           ListNode tmp = head.next;
           head.next = null;
           ListNode newHead = reverseList(tmp);
           if (tmp != null) {
               tmp.next = head;
           }
           return newHead;
    }
}
