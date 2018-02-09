230. Kth Smallest Element in a BST/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }
        int a = getCount(root.left);
        if (a > k - 1) {
            return kthSmallest(root.left, k);
        } else if (a == k - 1){
            return root.val;
        } else {
            return kthSmallest(root.right, k - a - 1);
        }
    }
    
    private int getCount(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + getCount(root.left) + getCount(root.right);
    }
}
