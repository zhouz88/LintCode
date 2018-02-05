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
       public boolean isValidBST(TreeNode root) {
        return isBST(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
    }
    
    private boolean isBST(TreeNode root, double low, double high) {
        if (root == null) {
            return true;
        }
        if (root.val <= low) {
            return false;
        }
        if (root.val >= high) {
            return false;
        }
        
        return isBST(root.left, low, root.val) && isBST(root.right, root.val, high);
    }
}
