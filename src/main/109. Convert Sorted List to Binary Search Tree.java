/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
         if (head == null) {
             return null;
         }
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        dummy.next = head;
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            p = p.next;
            fast = fast.next.next;
        }
        
        p.next = null;
        
        TreeNode root = new TreeNode(slow.val);
        root.left =  sortedListToBST(dummy.next);
        root.right =  sortedListToBST(slow.next);
        
        return root; 
    }
}
