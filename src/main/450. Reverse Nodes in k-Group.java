450. Reverse Nodes in k-Group/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */


public class Solution {
    /*
     * @param head: a ListNode
     * @param k: An integer
     * @return: a ListNode
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        // write your code here
        if (head == null) {
            return null;
        }
        int num = k;
        ListNode p = head;
        ListNode pre = null;
        
        while (num != 0 && p != null) {
            num--;
            pre = p;
            p = p.next;
        }
        if (num == 0) {
            pre.next = null;
            pre = head;
            head = reverse(head);
            p = reverseKGroup(p, k);
            pre.next = p;
            return head;
        } else {
            return head;
        }
    }
    
    private ListNode reverse(ListNode head) {
        ListNode pre = head, cur = head;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }
}
