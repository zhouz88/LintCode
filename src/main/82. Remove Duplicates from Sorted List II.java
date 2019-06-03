

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        ListNode cur = head;
        ListNode next = head.next;

        while (next != null) {
            if (next.val != cur.val) {
                p = p.next;
                next = next.next;
                cur = cur.next;
            } else {
                while (next.next != null && next.val == next.next.val) {
                    next = next.next;
                }
                cur = next.next;
                p.next = cur;
                if (cur == null) break;
                else next = cur.next;
            }
        }
        return dummy.next;
    }
    
    /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode before = dummy;
        ListNode p = head;
        ListNode pNext = head.next;
        int count = 1;
        while (pNext != null) {
            if (pNext.val == p.val) {
                count++;
                pNext = pNext.next;
            } else {
                if (count > 1) {
                    count = 1;
                    before.next = pNext;
                    p = pNext;
                    pNext = pNext.next;
                } else {
                    before = before.next;
                    p = p.next;
                    pNext = pNext.next;
                } 
            }
        }
        if (count > 1) {
            before.next = pNext;
        }
        return dummy.next;
    }
}


  //    public class ListNode {
  //     int val;
  //     ListNode next;
  //     ListNode(int x) { val = x; }
  // }
}
