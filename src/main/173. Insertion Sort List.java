/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */


public class Solution {
    /*
     * @param head: The first node of linked list.
     * @return: The head of linked list.
     */
    public ListNode insertionSortList(ListNode head) {
        // write your code here
        //corner case
        
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode dummyNode = new ListNode(0);
        ListNode p = dummyNode;
        
        ListNode pre = head;
        ListNode cur = head.next;
        
        while (true) {
            p = dummyNode;
            pre.next = null;
            while (p.next != null && p.next.val < pre.val) {
                p = p.next;
            }
            //
            if (p.next == null) {
                p.next = pre;
            } else {
                ListNode tmp = p.next;
                p.next = pre;
                pre.next = tmp;
            }
            ///
            pre = cur;
            if (pre == null) {
                break;
            }
            cur = cur.next;
        }
        
        return dummyNode.next;
        
    }
}
