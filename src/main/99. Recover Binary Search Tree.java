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
    public void recoverTree(TreeNode root) {
         inOrder(root);
         int tmp = first.val;
         first.val = second.val;
         second.val = tmp;
    }
    
    TreeNode pre, first, second;
    int cnt = 0;
    
    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        if (pre != null && cnt == 0 && root.val < pre.val) {
            first = pre;
            second = root;
            cnt++;
        } else if (cnt == 1 && root.val < pre.val) {
            second = root;
            return;
        }
        pre = root;
        inOrder(root.right);
    }
}
