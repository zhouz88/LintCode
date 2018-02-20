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
    public int longestUnivaluePath(TreeNode root) {
        //edge case
        update(root);
        return ans == Integer.MIN_VALUE ? 0 : ans - 1;//bug 3
    }
    
    private int ans = Integer.MIN_VALUE;//bug 1 int no 
    
    private int update(TreeNode root) {
        if (root == null) {
            return 0; //bug 2
        }
        
        int l = update(root.left);
        int r = update(root.right);
        
        int L = 0, R = 0;// present the value equals this root;
        
        if (root.left != null && root.left.val == root.val) {
            L = l;
        }
        
        if (root.right != null && root.right.val == root.val) {
            R = r;
        }
        
        if (L + R + 1 > ans) {
            ans = L + R + 1;
        }
        
        return Math.max(L, R) + 1;
    }
}
